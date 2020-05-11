

/**
 * 登录
 */
function login(data){
    ajax({
        url:LOGIN_URL,
        data:data,

        dataType:'json',
        type:'post',
        success:function (result) {
            if (success(result)){
                location.href =main_url;
            }else{
                layer.msg('登录名或密码错误');
            }
        }
    });
}