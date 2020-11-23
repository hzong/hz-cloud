(function () {
    document.write("<script src=\"/js/view/menu/menu-left.js" + context_ver + "\"></script>");
})();


$(function () {
    loadLeftMenu();


    /*//JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        //监听菜单选择功能
        element.on('nav(left-menus)',function(data){
            if(data.attr("level") == 1){
                renderChildMenuFun(data.attr("menuId"),this);
            }
        });



        element.on('tab(tabs)', function(data){
            console.log(this); //当前Tab标题所在的原始DOM元素
            console.log(data.index); //得到当前Tab的所在下标
            console.log(data.elem); //得到当前的Tab大容器
        });

        element.on('tabDelete(tabs)', function(data){
            console.log(this); //当前Tab标题所在的原始DOM元素
            console.log(data.index); //得到当前Tab的所在下标
            console.log(data.elem); //得到当前的Tab大容器
        });
        element.on('nav(tabs)', function(elem){
            console.log(elem); //得到当前点击的DOM对象
        });

        element.tabAdd('tabs', {
            title: '111'
            ,content: '111' //支持传入html
            ,id: '11'
        });
        // element.render('nav', 'menus');
    });*/
});


function selTab(tab_id) {
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
        /*$.each($(".layui-tab-title li"), function (i, ele) {
            var ele_dom = $(ele);
            ele_dom.removeClass("layui-this");
            if(tab_id == ele_dom.attr("lay-id")){
                ele_dom.addClass("layui-this");
            }
        });*/
        element.tabChange('tabs', tab_id);

      /*  $.each($(".layui-tab-content div"), function (i, ele) {
            var ele_dom = $(ele);
            ele_dom.removeClass("layui-this");
            if(tab_id == ele_dom.attr("lay-id")){
                ele_dom.addClass("layui-this");
            }
        });
*/
        //渲染
        element.render('nav', 'tabs');
    });

}

function addTab(params) {


    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;
        element.tabAdd('tabs', params);
        //渲染
        element.render('nav', 'tabs');
    });
}
