package com.lk.hdlazy_blog.service;


import com.lk.hdlazy_blog.mapper.UserMapper;
import com.lk.hdlazy_blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserService
 * Package:com.lk.demo.service
 * Description:
 *
 * @date:2022/8/20 14:14
 * @author:LiaoKe
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    //登录
    public User checkUser(User user){
        User result = userMapper.selectUser(user);
        return result;
    }

    //获取我的信息
    public User getUserInfo(){
        User userInfo = userMapper.selectUserInfo();
        return userInfo;
    }


}
