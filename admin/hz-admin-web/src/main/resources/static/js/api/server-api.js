
//####################URL地址-begin####################
var OPEN_API = "/open";
var LIMIT_API = "/limit";
var LIMIT_URL = context_url+LIMIT_API;
var LOGIN_AUTH_URL = context_url+"/login/auth";
var LOGIN_URL = context_url+"/login";
var MAIN_URL = context_url+"/main";
//####################菜单地址-begin####################
var MENU_URL = LIMIT_URL+"/menu";
var MENU_CHILDS_URL = MENU_URL+"/v1/getChilds";
var MENU_QUERY_PAGE = MENU_URL+'/v1/queryPage';
//####################菜单地址-end####################
//####################URL地址-end####################

/**
 * 登录
 */
function loginApi(data,call){
    ajax({
        url:LOGIN_AUTH_URL,
        data:data,
        dataType:'json',
        type:'post',
        success:function (result) {
            call(result);
        }
    });
}






/**
 * 记载一级菜单
 * @param call
 */
function reqLeftMenuApi(call) {
    sysajax({
        url:MENU_CHILDS_URL,
        data:{pid:0},
        dataType:'json',
        type:'post',
        success:function (result) {

            call(result);
        }
    });

}

/**
 *加载二级菜单
 * @param menuId
 * @param call
 */
function reqChildMenuApi(menuId, call) {
    //todo 这里血加载子菜单ajax

    sysajax({
        url:MENU_CHILDS_URL,
        data:{pid:menuId},
        dataType:'json',
        type:'post',
        success:function (result) {
            /*if (success(result)){
                // call([{level: 1, menuId: 1, url: "www.baidu.com", menuName: "菜单1子菜单1"},{level: 1, menuId: 2, url: "www.baidu.com", menuName: "菜单1子菜单1"}]);
                call(result.data);
            }*/

            call(result);
        }
    });

}
/*



/!**
 * 记载一级菜单
 * @param call
 *!/
function reqLeftMenu(call) {
    sysajax({
        url:MENU_CHILDS_URL,
        data:{pid:0},
        dataType:'json',
        type:'post',
        success:function (result) {
            if (success(result)){
                // call([{level: 1, menuId: 1, url: "www.baidu.com", menuName: "菜单1"}]);
                call(result.data);
            }
        }
    });

}

/!**
 *加载二级菜单
 * @param menuId
 * @param call
 *!/
function reqChildMenu(menuId, call) {
    //todo 这里血加载子菜单ajax

    sysajax({
        url:MENU_CHILDS_URL,
        data:{pid:menuId},
        dataType:'json',
        type:'post',
        success:function (result) {
            if (success(result)){
                // call([{level: 1, menuId: 1, url: "www.baidu.com", menuName: "菜单1子菜单1"},{level: 1, menuId: 2, url: "www.baidu.com", menuName: "菜单1子菜单1"}]);
                call(result.data);
            }
        }
    });

}*/
