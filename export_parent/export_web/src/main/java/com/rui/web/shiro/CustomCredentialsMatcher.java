package com.rui.web.shiro;

import com.rui.util.Encrypt;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @description: 自定义密码比较器
 * @author: caihongrui
 * @createtime: 2019-11-21 16:40
 **/
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
    /**
     * 自定义密码比较
     * @param token 用户输入的email和密码
     * @param info  安全数据（用户对象，用户密码，realm名）
     * @return true：表示登录成功 false 表示登录失败
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        //获取用户输入的认证信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String email = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());

        String realPassword = (String)info.getCredentials();
        password = Encrypt.md5(password, email);
        //String testString = Encrypt.md5("123456", "lw@export.com");
        return password.equals(realPassword);
    }
}
