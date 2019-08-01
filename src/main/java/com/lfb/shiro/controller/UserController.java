package com.lfb.shiro.controller;


import com.lfb.shiro.entity.Permission;
import com.lfb.shiro.entity.Role;
import com.lfb.shiro.entity.User;
import com.lfb.shiro.entity.UserRole;
import com.lfb.shiro.enums.ResultEnum;
import com.lfb.shiro.exception.MyException;
import com.lfb.shiro.mapper.PermissionMapper;
import com.lfb.shiro.mapper.RoleMapper;
import com.lfb.shiro.mapper.UserRoleMapper;
import com.lfb.shiro.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author:lfb
 * @Version:V1.0
 * @CreateTime:2019/6/28 20:02
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    /*
    *       注解                                        功能
@RequiresGuest                    只有游客可以访问
@RequiresAuthentication     需要登录才能访问
@RequiresUser                      已登录的用户或“记住我”的用户能访问
@RequiresRoles                    已登录的用户需具有指定的角色才能访问
@RequiresPermissions          已登录的用户需具有指定的权限才能访问
    * */
  //  @RequiresRoles("超级管理员")
  //  @RequiresPermissions("user:del")
    @RequiresGuest
    @RequestMapping("/guest")
    @ResponseBody
    public String guest(){
        return "@RequiresGuest ";
    }

    @RequiresAuthentication
    @RequestMapping("/authc")
    @ResponseBody
    public String authc() {
        return "@RequiresAuthentication";
    }

//    @RequiresAuthentication
//    @GetMapping("/user/{id}")
//    public User getUserById(@PathVariable("id") Integer id){
//        User user = userService.getUserById(id);
//        return user;
//    }

    @RequiresUser
    @RequestMapping("/RequiresUser")
    @ResponseBody
    public String user() {
        return "@RequiresUser";
    }

    @RequiresPermissions("user:select")
    @RequestMapping("/userselect")
    //@ResponseBody
    public String userselect() {
        return "userselect";
    }

    @RequiresPermissions("user:del")
    @RequestMapping("/userdel")
    //@ResponseBody
    public String userdel() {
        return "userdel";
    }

    @RequiresRoles("test")
    @RequestMapping("/admin")
    @ResponseBody
    public String js() {
        return "超级管理员";
    }


    @RequestMapping("/vip1")
    @RequiresRoles("vip1")
    //@ResponseBody
    public String vip1() {
        return "vip1";
    }

    @RequestMapping("/userrole/{id}")
    public List<UserRole> findUserRole(@PathVariable("id") Integer id){
        List<UserRole> userRole = userRoleMapper.findUserRole(id);
        return userRole;
    }

    @RequestMapping("/role/{id}")

    public List<Role> findRole(@PathVariable("id") Integer id){
        List<Role> userRole = roleMapper.findRole(id);
        return userRole;
    }


    @GetMapping("/login")
    public void login(String username, String password, HttpServletRequest request){
        System.out.println("登录"+username);
        String sessionId = "";
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("token",token);
            sessionId = session.getId().toString();
        } catch (IncorrectCredentialsException e) {
            System.out.println(e.getMessage());
//            result.append("msg:密码错误");
         //   log.error(e.getMessage());
            throw new MyException(ResultEnum.ERROR_PASSWORD);
        } catch (LockedAccountException e) {
            System.out.println(e.getMessage());
//            result.append("msg:登录失败，该用户已被冻结");
        //    log.error(e.getMessage());
            throw new MyException(ResultEnum.FAIL_LOGIN_FREEZE);
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
//            result.append("msg:该用户不存在");
       //     log.error(e.getMessage());
            throw new MyException(ResultEnum.FAIL_NOTUSER);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.FAIL_LOGIN);
        }
    }

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }
    @RequestMapping("/403")
    //@ResponseBody
    public String noperms(){
        System.out.println("403");
        return "/403";
    }

//    @RequestMapping("/login")
//    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
//        System.out.println("HomeController.login()");
//        // 登录失败从request中获取shiro处理的异常信息。
//        // shiroLoginFailure:就是shiro异常类的全类名.
//        String exception = (String) request.getAttribute("shiroLoginFailure");
//        System.out.println("exception=" + exception);
//        String msg = "";
//        if (exception != null) {
//            if (UnknownAccountException.class.getName().equals(exception)) {
//                System.out.println("UnknownAccountException -- > 账号不存在：");
//                msg = "UnknownAccountException -- > 账号不存在：";
//            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
//                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
//                msg = "IncorrectCredentialsException -- > 密码不正确：";
//            } else if ("kaptchaValidateFailed".equals(exception)) {
//                System.out.println("kaptchaValidateFailed -- > 验证码错误");
//                msg = "kaptchaValidateFailed -- > 验证码错误";
//            } else {
//                msg = "else >> "+exception;
//                System.out.println("else -- >" + exception);
//            }
//        }
//        map.put("msg", msg);
//        // 此方法不处理登录成功,由shiro进行处理
//        return "/login";
//    }
}
