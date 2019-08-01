package com.lfb.shiro.config.realms;


import com.lfb.shiro.entity.Permission;
import com.lfb.shiro.entity.Role;
import com.lfb.shiro.entity.User;
import com.lfb.shiro.service.PermissionService;
import com.lfb.shiro.service.RoleService;
import com.lfb.shiro.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.addStringPermission("userInfo:test");
//        UserInfo userInfo  = (UserInfo)principals.getPrimaryPrincipal();
//        for(SysRole role:userInfo.getRoleList()){
//            authorizationInfo.addRole(role.getRole());
//            for(SysPermission p:role.getPermissions()){
//                authorizationInfo.addStringPermission(p.getPermission());
//            }
//        }
        //查询所有的角色

        User user = (User) principals.getPrimaryPrincipal();
//        User user = (User) getAvailablePrincipal(principals);

        List<Role> roles = roleService.findRole(user.getId());
        List<Integer> ids = new ArrayList<>(10);
        for(Role role:roles){
            authorizationInfo.addRole(role.getName());
            System.out.println(role.getName());
            ids.add(role.getId());
        }
        System.out.println(ids);
        //查询所有的权限
        List<Permission> permissions = permissionService.findPermission(ids);
        for(Permission permission : permissions){
            authorizationInfo.addStringPermission(permission.getPermission());
            System.out.println("-->>"+ permission.getPermission());
        }


        return authorizationInfo;
    }


    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
//        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//        String username = upToken.getUsername();
        System.out.println(token.getCredentials()+" "+username);
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userService.findByUsername(username);
//        System.out.println("----->>userInfo="+userInfo);
        if(user == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                getName()  //realm name
        );
        return authenticationInfo;
    }
}
