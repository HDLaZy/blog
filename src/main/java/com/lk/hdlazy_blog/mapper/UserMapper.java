package com.lk.hdlazy_blog.mapper;


import com.lk.hdlazy_blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName:UserMapper
 * Package:com.lk.demo.mapper
 * Description:
 *
 * @date:2022/8/20 14:08
 * @author:LiaoKe
 */
@Mapper
public interface UserMapper {

    //登录使用，获取用户信息
    User selectUser(User user);
    //获取我的信息
    User selectUserInfo();

}
