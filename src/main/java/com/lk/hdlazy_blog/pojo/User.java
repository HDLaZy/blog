package com.lk.hdlazy_blog.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName:User
 * Package:blog.pojo
 * Description:
 *
 * @date:2022/6/22 18:32
 * @author:LiaoKe
 */
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String head;
    private String github;
}
