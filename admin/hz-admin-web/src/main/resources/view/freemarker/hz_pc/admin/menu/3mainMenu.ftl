<@override name="body">
    <div class="layui-body">


        <div class="layui-card layadmin-header">
            <div class="layui-breadcrumb" lay-filter="breadcrumb">
                <a lay-href="">主页</a>
                <a><cite>应用</cite></a>
                <a><cite>文章列表</cite></a>
            </div>
        </div>

        <div class="layui-fluid">
            <div class="layui-card">
                <div class="layui-form layui-card-header layuiadmin-card-header-auto" lay-filter="menu-list-form">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">菜单名称</label>
                            <div class="layui-input-inline">
                                <input type="text" name="menuName" placeholder="请输入" autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">状态</label>
                            <div class="layui-input-inline">
                                <select name="status">
                                    <option value="0">请选择状态</option>
                                    <option value="1">是</option>
                                    <option value="2">否</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <button class="layui-btn layuiadmin-btn-list" lay-submit
                                    lay-filter="menu-search">
                                <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                            </button>
                        </div>
                    </div>
                </div>

                <div class="layui-card-body">
                    <div style="padding-bottom: 10px;">
                        <button class="layui-btn layuiadmin-btn-list" data-type="batchdel">删除</button>
                        <button class="layui-btn layuiadmin-btn-list" data-type="add">添加</button>
                    </div>
                    <table id="LAY-app-content-list" lay-filter="LAY-app-content-list"></table>

                    <script type="text/html" id="table-content-list">
                        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="edit"><i
                                    class="layui-icon layui-icon-edit"></i>编辑</a>
                        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del"><i
                                    class="layui-icon layui-icon-delete"></i>删除</a>
                    </script>
                </div>
            </div>
            <table class="layui-hide" id="menu-list"></table>
        </div>


    </div>
</@override>
<@extends name="../tmpl/main-tmpl.ftl"/>
