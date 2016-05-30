package com.sms.realm;

import com.sms.bean.User;
import com.sms.service.PermissionService;
import com.sms.service.RoleService;
import com.sms.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * Created by zy on 2016/5/30.
 */
public class ShiroRealmImpl extends AuthorizingRealm {

    private static Logger log = LoggerFactory.getLogger(ShiroRealmImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
    {
        log.info("##################执行Shiro权限认证##################");

        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.getUserByName(username);

        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

            Set<String> roles = roleService.getRolesByUserName(username);
            Set<String> permissions = permissionService.getPermissionsByUserName(username);

            info.addRoles(roles);
            info.addStringPermissions(permissions);

            return info;
        }

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        final UsernamePasswordToken credentials = (UsernamePasswordToken) token;
        String username = credentials.getUsername();
        User user = userService.getUserByName(username);
        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if (Boolean.TRUE.equals(user.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getName(), //用户名
                user.getPassword().toCharArray(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );

        return authenticationInfo;
    }

}
