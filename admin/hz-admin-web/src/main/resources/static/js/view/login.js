
$(function() {
    // $.imports("${pageContext.request.contextPath }/statics/js/jquery.json/jquery.json.js");
    // $.imports("<script src=\"/js/view/server-api.js"+context_ver+"\"></script>");

    /**
     * 登录
     */
    var loginViewFun = function(param){
        loginApi(param,function(res){
            if (success(res)){
                location.href =MAIN_URL;
            }else{
                layer.msg('登录名或密码错误');
            }
        });

    };

    layui.use(['form','jquery'], function () {

        // 操作对象
        var form = layui.form;
        // var $ = layui.jquery;
        form.on('submit(login)',function (lay) {
            loginViewFun(lay.field);
            return false;
        })

    });
});



