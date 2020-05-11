/**
 * 加载渲染一级菜单
 */
function loadMenu() {
    reqLeftMenu(function (data) {
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
                viewChildMenu(data[i].menuId, ele);
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
function viewChildMenu(menuId, curMenu) {
    //将历史子菜单清空
    curMenu.parent().find(".layui-nav-child").remove();
    //子菜单
    reqChildMenu(menuId, function (data) {
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
                '<a href="javascript:;" data-level="{0}" data-menuId="{1}" data-url="{2}">{3}</a></li>';
            var html = menu_tag.format(ele.level, ele.menuId, ele.url, ele.menuName,sel);
            nav_child_dom.append(html);
        })

        curMenu.append(nav_child_dom);
    })
}


/**
 * 记载一级菜单
 * @param call
 */
function reqLeftMenu(call) {
    sysajax({
        url:MENU_CHILDS_URL,
        data:{pid:0},
        dataType:'json',
        type:'post',
        success:function (result) {
            if (success(result)){
                // call([{level: 1, menuId: 1, url: "www.baidu.com", menuName: "菜单1"}]);
                call(result.data);
            }
        }
    });

}

/**
 *加载二级菜单
 * @param menuId
 * @param call
 */
function reqChildMenu(menuId, call) {
    //todo 这里血加载子菜单ajax

    sysajax({
        url:MENU_CHILDS_URL,
        data:{pid:menuId},
        dataType:'json',
        type:'post',
        success:function (result) {
            if (success(result)){
                // call([{level: 1, menuId: 1, url: "www.baidu.com", menuName: "菜单1子菜单1"},{level: 1, menuId: 2, url: "www.baidu.com", menuName: "菜单1子菜单1"}]);
                call(result.data);
            }
        }
    });


}