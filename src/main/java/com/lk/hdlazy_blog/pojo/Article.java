package com.lk.hdlazy_blog.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName:Article
 * Package:blog.pojo
 * Description:
 *
 * @date:2022/6/22 18:34
 * @author:LiaoKe
 */
@Getter
@Setter
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private java.util.Date createTime;
}
