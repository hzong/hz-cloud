<!DOCTYPE html>
<html>
<head>
	<title>layout 后台大布局 - Layui</title>
	<#include "../common/commonInclude.ftl">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<#include "../common/head.ftl">
	<#include "../common/left-main.ftl">


	<div class="layui-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">内容主体区域
			<div class="layui-tab" lay-allowClose="true" lay-filter="tabs">
				<ul class="layui-tab-title">
					<li class="layui-this" >网站设置</li>
					<li>商品管理</li>
					<li>订单管理</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">内容1</div>
					<div class="layui-tab-item">内容2</div>
					<div class="layui-tab-item">内容3</div>
				</div>
			</div>

		</div>
	</div>

	<#include "../common/footer.ftl">
</div>
<#include "../common/commonInclude-js.ftl">
<script src="js/biz/menu.js${ver}"></script>
<script>
	//JavaScript代码区域
	layui.use('element', function(){
		var element = layui.element;
		//监听菜单选择功能
		element.on('nav(left-menus)',function(data){
			console.log(data);
			if(data.attr("level") == 1){
				childMenu(data.attr("menuId"),this);
			}
		});
		//加载菜单
		loadMenu();
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



</script>
</body>
</html>