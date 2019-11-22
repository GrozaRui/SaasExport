package com.rui.web.shiro;

import com.rui.domain.system.Module;
import com.rui.domain.system.User;
import com.rui.service.system.ModuleService;
import com.rui.service.system.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 自定义认证realm域
 * @author: caihongrui
 * @createtime: 2019-11-21 16:39
 **/
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private ModuleService moduleService;

    /**
     * 授权
     * @param principalCollection （shiro中安全数据的集合）获取当前登录的用户对象：user
     * @return AuthorizationInfo（当前操作用户的所有权限对象） 返回对象的时候，将权限交给shiro管理（shiro会自动的判断是否具有权限）
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取安全数据中的user对象
        User user = (User) principalCollection.getPrimaryPrincipal();
        //查询当前用户所有的操作菜单权限
        List<Module> moduleList = moduleService.findModuleByUserId(user.getId());
        //构造返回值
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> modules = new HashSet<>();
        for (Module module : moduleList) {
            modules.add(module.getName());
        }
        info.setStringPermissions(modules);
        return null;
    }

    /**
     * 认证
     * @param authenticationToken （传递过来的UserNameAndPasswordToken）
     * @return 不存在则返回null
     *         如存在则返回安全数据AuthenticationInfo 然后自动调用密码比较器
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户登录认证信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String email = usernamePasswordToken.getUsername();
        //String password = usernamePasswordToken.getPassword().toString();
        //从数据库获取真实用户对象
        User user = userService.findUserByEmail(email);
        //判断若用户不为空则返回安全数据
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        } else {
            return null;
        }
    }
}
