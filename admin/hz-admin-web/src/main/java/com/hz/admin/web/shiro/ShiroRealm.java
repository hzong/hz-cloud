package com.hz.admin.web.shiro;

import com.hz.admin.db.entity.TAccount;
import com.hz.admin.db.entity.ex.AccountMenuDO;
import com.hz.admin.db.entity.ex.AccountRoleDO;
import com.hz.admin.db.service.account.AccountService;
import com.hz.admin.db.service.role.RoleService;
import com.hz.admin.model.codes.StatusEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Classname ShiroRealm
 * @Description TODO
 * @Date 2020-01-19 23:44
 * @Created by hzong
 */

public class ShiroRealm extends AuthorizingRealm {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private RoleService roleService;

    /**
     * 获取用户角色和权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        TAccount user = (TAccount) SecurityUtils.getSubject().getPrincipal();
        String account = user.getAccount();

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("doGetAuthorizationInfo() called with: userName=【{}】 principalCollection = [" + principalCollection + "]",account);
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        // 获取用户角色集
        List<AccountRoleDO> roleList = accountService.selectAccountRoleList(account);
        Set<String> roleSet = new HashSet<String>();

        roleList.forEach( accountRoleDO ->{
            roleSet.add(accountRoleDO.getRoleNo());
        });
        simpleAuthorizationInfo.setRoles(roleSet);

        // 获取用户权限集
        List<AccountMenuDO> permissionList = accountService.selectAccountMenuList(account);
        Set<String> permissionSet = new HashSet<>();
        for (AccountMenuDO p : permissionList) {
            permissionSet.add(p.getMenuNo());
        }
        simpleAuthorizationInfo.setStringPermissions(permissionSet);
        return simpleAuthorizationInfo;
    }
    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户输入的用户名和密码
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("doGetAuthenticationInfo() called with: authenticationToken = [" + authenticationToken + "] username=【{}】 pwd=【{}】",username,password);
        }

        // 通过用户名到数据库查询用户信息
        // TODO: 2020-04-16
        TAccount account = accountService.selectByPrimaryKey(username);

        if (account == null) {
            throw new UnknownAccountException("用户名或密码错误！");
        }
        if (!password.equals(account.getPwd())) {
            throw new IncorrectCredentialsException("用户名或密码错误！");
        }
        if (StatusEnum.OFF.getCode() == account.getStatus()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员！");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(new TAccount(), password, getName());
        return info;
    }
}
