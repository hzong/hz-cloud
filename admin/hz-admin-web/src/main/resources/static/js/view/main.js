(function() {
    document.write("<script src=\"/js/view/menu/menu-left.js"+context_ver+"\"></script>");
})();
$(function() {
    loadLeftMenu();


    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        //监听菜单选择功能
        element.on('nav(left-menus)',function(data){
            if(data.attr("level") == 1){
                renderChildMenuFun(data.attr("menuId"),this);
            }
        });

        //渲染
        element.render('nav', 'left-menus');

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
    });
});
