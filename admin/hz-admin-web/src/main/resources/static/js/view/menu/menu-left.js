/**
 * 加载渲染一级菜单
 */
function loadLeftMenu() {

    layui.use('element', function(){
        var element = layui.element;
        //渲染
        element.render('nav', 'left-menus');
    });



    reqLeftMenuApi(function (res) {
        if (!success(res)){
            return;
        }
        var data = res.data;

        var dom = $("[lay-filter=left-menus]");

        var menuEles = [];
        $.each(data, function (i, ele) {
            var menu_tag = "<li class=\"layui-nav-item \">\n" +
                "                <a class=\"\" href=\"javascript:;\" " +
                " data-level=\"{0}\" data-menuId=\"{1}\" data-url=\"{2}\">{3}</a>\n" +

                "            </li>";

            var html = menu_tag.format(ele.level, ele.menuId, ele.url, ele.menuName);
            menuEles[i] = $(html);
        });
        //加载第一个一级菜单子菜单
        if (menuEles.length == 0) {
            return;
        }

        $.each(menuEles, function (i, ele) {
            //第一个加载子菜单
            if (i == 0) {
                ele.addClass("layui-nav-itemed");
                renderChildMenuFun(data[i].menuNo, ele);
            }
            dom.append(ele);
        });
    });




}

/**
 * 渲染子菜单
 * @param menuId
 * @param curMenu
 */
function renderChildMenuFun(menuId, curMenu) {
    //将历史子菜单清空
    curMenu.parent().find(".layui-nav-child").remove();
    //子菜单
    reqChildMenuApi(menuId, function (res) {
        if (!success(res)){
            return;
        }
        var data = res.data;
        if(data.length == 0){
            return;
        }
        var nav_child_dom = $("<dl class=\"layui-nav-child\">\n" +"</dl>\n");
        var sel_dom = "layui-this";
        $.each(data, function (i, ele) {
            var sel ="";
            if(menuId == ele.menuId ){//如果传入的菜单比较如何相当则设置选中
                sel = sel_dom;
            }

            var menu_tag = '<li class="layui-nav-item {4}">' +
                '<a href="javascript:;" data-level="{0}" data-menuId="{1}" >{3}</a></li>';
            var html = menu_tag.format(ele.level, ele.menuNo, ele.url, ele.menuName,sel);
            var item_dom = $(html);
            item_dom.on("click",function(){
                layui.use('element', function(){
                    var element = layui.element;
                    var html_fromat ='<iframe src="{0}" style="width:100%;height:100%; border: 0px solid"></iframe>';
                    var iframe_dom =html_fromat.format(ele.url);
                    addTab({
                        title: ele.menuName
                        ,content: iframe_dom //支持传入html
                        ,id: ele.menuNo
                    });
                    selTab(ele.menuNo,html);

                });


            });
            nav_child_dom.append(item_dom);




        })

        curMenu.append(nav_child_dom);



    });
}



