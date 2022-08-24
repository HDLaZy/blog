package com.lk.hdlazy_blog.util;



import com.lk.hdlazy_blog.pojo.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class WebUtil {

    public User validateLogin(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        User user = null;
        if (session != null) {
            //这里是提前写了获取会话中的用户信息，登录时注意要保存相同的键
            user = (User) session.getAttribute("user");
        }
        return user;
    }

}
