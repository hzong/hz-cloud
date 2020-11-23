
(function() {
    document.write("<script src=\"/js/view/menu/menu-add.js"+context_ver+"\"></script>");
})();
$(function() {
    loadMenu();
});

function loadMenu() {

    layui.use(['form', 'table','element'], function () {
        var table = layui.table;
        var form = layui.form;

        form.on('submit(menu-search)', function (data) {
            var params = tableRenderParams('#menu-list');
            params.where = data.field;
            table.render(params);
        });
        var params = tableRenderParams('#menu-list');
        table.render(params);
    });

}


function tableRenderParams(elem) {
    return {
        elem: elem
        , url: MENU_QUERY_PAGE
        , method: 'post'
        , contentType: 'application/json'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": res.code, //解析接口状态
                "msg": res.msg, //解析提示文本
                "total": res.data.total, //解析数据长度
                "data": res.data.list //解析数据列表
            };
        }
        , where: {}
        , request: {
            pageName: 'pageNum' //页码的参数名称，默认：page
            , limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
        , response: {
            statusCode: 1 //规定成功的状态码，默认：0
            , countName: 'total' //规定数据总数的字段名称，默认：count
        }
        ,page: true
        , cols: [[
            {type: 'checkbox'}
            , { type:'numbers', title: '序号'}
            , {field: 'menuNo', title: '菜单编码'}
            , {field: 'menuName', title: '菜单名称'}
            , {field: 'menuParentNo', title: '父菜单编码'}
            , {field: 'seq', title: '菜单序号'}
            , {field: 'level', title: '级别', sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
            , {field: 'status', title: '状态'}
            , {field: 'updateTime', title: '更新时间', sort: true}
            , {field: 'createTime', title: '创建时间', sort: true}
            , {fixed: 'right', title: '操作', toolbar: '#table-content-list', width: 150}
        ]]
    };
}


