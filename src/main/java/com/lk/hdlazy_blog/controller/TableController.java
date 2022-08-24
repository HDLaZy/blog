
package com.lk.hdlazy_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * ClassName:TableController
 * Package:com.lk.demo.controller
 * Description:
 *  页面跳转
 * @date:2022/8/20 13:44
 * @author:LiaoKe
 */
@Controller
public class TableController {

    //其它人访问首页
    @RequestMapping("/")
    public String index(){
        return "other_list.html";
    }

    //到登录页面
    @RequestMapping("/my")
    public String login(){
        return "my_login.html";
    }

    //404页面
    @RequestMapping("/notFound")
    public String notFound(){
        return "404.html";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:other_list.html";
    }

}
