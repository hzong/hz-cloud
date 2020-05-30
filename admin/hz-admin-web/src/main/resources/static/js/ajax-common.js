/**
 * 登录后的ajax必须调用此函数
 * @param params
 */
function sysajax(params) {
    if (ENV_NAME_DEV == envName) {
        ajax(params);
    } else {
        //验证是否登录
        authStatus(function () {
            ajax(params);
        }, function () {
            window.location.href = login_view_url;
        });
    }
    ;

}

/**
 * 非登录调用请求
 * @param params
 */
function ajax(params) {
    params.type = "post";
    params.contentType = 'application/json;charset=UTF-8';
    params.data = JSON.stringify(params.data);
    if (params.error == null) {
        params.error = function (xhr, textStatus, errorThrown) {
            /*错误信息处理*/
            console.log("进入error---");
            console.log("状态码：" + xhr.status);
            console.log("状态:" + xhr.readyState);//当前状态,0-未初始化，1-正在载入，2-已经载入，3-数据进行交互，4-完成。
            console.log("错误信息:" + xhr.statusText);
            console.log("返回响应信息：" + xhr.responseText);//这里是详细的信息
            console.log("请求状态：" + textStatus);
            console.log(errorThrown);
            console.log("请求失败");
            layer.msg('请求服务器错误！');

        }
    }
    $.ajax(params);

}


var AUTHSTATUS_URL = context_url + "/authStatus";

/**
 * 验证是否登录
 */
function authStatus(fun) {
    $.ajax({
        url: AUTHSTATUS_URL,
        dataType: 'json',
        type: 'post',
        success: function (result) {
            if (success(result)) {
                fun();
            } else {
                layer.msg('验证登录状态错误！，请检查服务');
            }
        }
    });
}