package com.lk.hdlazy_blog.mapper;

import com.lk.hdlazy_blog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName:ArticleMapper
 * Package:com.lk.demo.mapper
 * Description:
 *
 * @date:2022/8/20 15:09
 * @author:LiaoKe
 */
@Mapper
public interface ArticleMapper {


    //获取我的文章列表
    List<Article> selectArticles();

    //根据文章ID获取文章详情
    Article selectArticle(Integer id);

    //添加文章
    int insertArticle(Article article);

}
