package com.lk.hdlazy_blog.controller;

import com.lk.hdlazy_blog.pojo.User;
import com.lk.hdlazy_blog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:UserController
 * Package:com.lk.demo.controller
 * Description:
 *
 * @date:2022/8/20 13:43
 * @author:LiaoKe
 */


@RestController
@Slf4j
public class UserController {


    @Autowired
    private UserService userService;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User loginUser, HttpServletRequest req){

        Map<String, Object> body = new HashMap<>();

        User query = userService.checkUser(loginUser);

        if (query == null) {
            body.put("ok", false);
            body.put("error", "账号不存在");
            //用户输入的密码和查询的用户密码不一样
        } else if (!query.getPassword().equals(loginUser.getPassword())) {
            body.put("ok", false);
            body.put("error", "账号或密码错误");
            //验证通过
        } else {
            body.put("ok", true);
            //登录成功，创建session，并保存用户信息
            HttpSession session = req.getSession();//创建session
            //在session中保存用户信息：保存数据库查询的用户，信息比较全
            session.setAttribute("user", query);
        }

        return body;
    }


    //获取我的信息
    @GetMapping("/getUserInfo")
    public Object getUserInfo(){
        User userInfo = userService.getUserInfo();
        userInfo.setPassword("******");
        log.debug("{}",userInfo);
        return userInfo;
    }

}
