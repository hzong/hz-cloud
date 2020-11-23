<!DOCTYPE html>
<html>
<head>
    <title>菜单添加 后台大布局</title>
    <#include "../../common/commonInclude.ftl">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "../../common/head.ftl">
    <#include "../../common/left-main.ftl">


    <div class="layui-body">


        <div class="layui-fluid">
            <div class="layui-row layui-col-space15">
                <div class="layui-col-md12">
                    <div class="layui-card" >
                        <div class="layui-card-header">添加菜单</div>
                        <div class="layui-card-body">
                            <div class="layui-form layui-form-pane" lay-filter="layuiadmin-app-form-list"
                                 id="layuiadmin-app-form-list"
                                 style="padding: 20px;">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">菜单编码</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="title" lay-verify="required" placeholder="请输入菜单编码"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                    <label class="layui-form-label">菜单名称</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="title" lay-verify="required" placeholder="请输入菜单名称"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">上级编码</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="author" lay-verify="required" placeholder="请输入上级菜单编码"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                    <label class="layui-form-label">状态</label>
                                    <div class="layui-input-inline">
                                        <input type="checkbox" lay-verify="required" lay-filter="status" name="status"
                                               lay-skin="switch"
                                               lay-text="启用|禁用">
                                        <div class="layui-unselect layui-form-switch" lay-skin="_switch">
                                            <em>待启用</em><i></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">地址</label>
                                    <div class="layui-input-block">
                                        <input type="text" name="author" lay-verify="required" placeholder="请输入url"
                                               autocomplete="off"
                                               class="layui-input" style="width: 500px;">
                                    </div>
                                </div>

                                <div class="layui-form-item">
                                    <label class="layui-form-label">description</label>
                                    <div class="layui-input-block">
                        <textarea name="content" lay-verify="required" style="width: 500px; height: 150px;"
                                  autocomplete="off" class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <#-- <div class="layui-form-item">
                                     <label class="layui-form-label">选择框</label>
                                     <div class="layui-input-inline">
                                         <select name="city" lay-verify="required">
                                             <option value=""></option>
                                             <option value="0">北京</option>
                                             <option value="1">上海</option>
                                             <option value="2">广州</option>
                                             <option value="3">深圳</option>
                                             <option value="4">杭州</option>
                                         </select>
                                     </div>
                                 </div>-->

                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交
                                        </button>
                                        <button type="reset" class="layui-btn layui-btn-primary">取消</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


    </div>

    <#include "../../common/footer.ftl">
</div>
<#include "../../common/commonInclude-js.ftl">
<script src="/js/view/menu/menu-add.js${ver}"></script>
<script>

</script>
</body>
</html>