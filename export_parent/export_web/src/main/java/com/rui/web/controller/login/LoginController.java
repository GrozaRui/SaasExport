package com.rui.web.controller.login;

import com.rui.domain.system.Module;
import com.rui.domain.system.User;
import com.rui.service.system.ModuleService;
import com.rui.service.system.UserService;
import com.rui.util.Encrypt;
import com.rui.web.controller.BaseController;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @description: 跳转主页
 * @author: caihongrui
 * @createtime: 2019-11-15 16:14
 **/
@Controller
public class LoginController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModuleService moduleService;

    /**
     * 实现用户登录
     *
     * @return
     */
    //@RequestMapping("/login")
    //public String login(String email,String password) {
    //    //非空判断
    //    if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
    //        return "forward:login.jsp";
    //    }
    //    //根据email获取用户对象
    //    User user = userService.findUserByEmail(email);
    //    //判断用户存在且密码是否一致 不一致跳转重新登录
    //    password = Encrypt.md5(password, email);//对密码进行md5加盐加密
    //    if (user == null || !StringUtils.equals(password, user.getPassword())) {
    //        request.setAttribute("errorMsg", "用户名或密码错误");
    //        return "forward:/login.jsp";
    //    } else {
    //        //用户存在且密码一致
    //        session.setAttribute("user", user);
    //        //查询出用户可访问(对应degree)的全部模块列表
    //        List<Module> userModuleList = moduleService.findModuleByUserId(user.getId());
    //        session.setAttribute("modules",userModuleList);
    //        return "home/main";
    //    }
    //}

    //基于shiro的身份认证（登录）
    @RequestMapping("/login")
    public String login(String email,String password) {
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        try {
            //封装数据
            UsernamePasswordToken upToken = new UsernamePasswordToken(email,password);
            //调用subject的login方法
            subject.login(upToken);

            //登录成功的逻辑
            //从shiro中获取用户对象
            User loginUser = (User)subject.getPrincipal();//安全数据（用户对象）
            session.setAttribute("user",loginUser);
            //查询当前用户所具有的所有权限
            List<Module> menus = moduleService.findModuleByUserId(loginUser.getId());
            //System.err.println("LoginController 用户的权限模块 == " + menus);

            session.setAttribute("modules",menus);
            return "home/main";
        } catch (AuthenticationException e) {
            //登录失败
            e.printStackTrace();
            request.setAttribute("errorMsg","用户名或密码错误");
            return "forward:login.jsp";
        }
    }

    @RequestMapping(value = "/logout",name="用户登出")
    public String logout(){
        //往数据库插入一条日志 syslog.save(日志)
        //SecurityUtils.getSubject().logout();   //登出
        //session.invalidate();//销毁数据
        session.removeAttribute("user");
        return "forward:login.jsp";
    }

    @RequestMapping("/home")
    public String toHomePage() {
        return "home/home";
    }

    @RequestMapping("/main")
    public String toMainPage() {
        return "home/main";
    }
}
