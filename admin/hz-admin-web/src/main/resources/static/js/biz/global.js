


//####################全局变量###################
ENV_NAME_DEV='dev';


//####################函数###################
/**
 * 成功
 * @param result
 * @returns {boolean}
 */
function success(result){
    if(result == null){
        return false;
    }else if(result.code == 1){
        return true;
    }
    return false;
}


/**
 * 是否失败
 * @param result
 * @returns {boolean}
 */
function ok(result){
    if(result == null){
        return true;
    }else if(result.code != 1){
        return false;
    }
    return true;
}


String.prototype.format = function() {
    if (arguments.length == 0)
        return this;
    for (var s = this, i = 0; i < arguments.length; i++)
        s = s.replace(new RegExp("\\{" + i + "\\}", "g"), arguments[i]);
    return s;
};


//####################URL地址###################
var OPEN_API = "/open";
var LIMIT_API = "/limit";
var LIMIT_URL = context_url+LIMIT_API;
var LOGIN_AUTH_URL = context_url+"/login/auth";
var LOGIN_URL = context_url+"/login";
var MENU_URL = LIMIT_URL+"/menu/";
var MENU_CHILDS_URL = MENU_URL+"/v1/getChilds";
var MAIN_URL = context_url+"/main";