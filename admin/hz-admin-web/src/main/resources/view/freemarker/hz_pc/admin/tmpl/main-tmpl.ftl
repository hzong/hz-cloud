<!DOCTYPE html>
<html>
<head>
	<title>hzong 后台</title>
	<#include "../common/commonInclude.ftl">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<#include "../common/head.ftl">
	<#include "../common/left-main.ftl">

	<div class="layui-body hz-body">
		<!-- 内容主体区域 -->
		<div style="padding: 15px;">内容主体区域
			<div class="layui-tab" lay-allowClose="true" lay-filter="tabs">
				<ul class="layui-tab-title">
					<#--<li class="layui-this" >网站设置</li>
					<li>商品管理</li>
					<li>订单管理</li>-->
				</ul>
				<div class="layui-tab-content">
				<#--	<div class="layui-tab-item layui-show">内容1</div>
					<div class="layui-tab-item">内容2</div>
					<div class="layui-tab-item">内容3</div>-->
				</div>
			</div>

		</div>
	</div>

	<#include "../common/footer.ftl">
</div>
<#include "../common/commonInclude-js.ftl">
<#--<script src="js/biz/menu-left.js${ver}"></script>-->
<script src="/js/view/main.js${ver}"></script>
</body>
</html>
