package com.lk.hdlazy_blog.service;


import com.lk.hdlazy_blog.mapper.ArticleMapper;
import com.lk.hdlazy_blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

/**
 * ClassName:ArticleService
 * Package:com.lk.demo.service
 * Description:
 *
 * @date:2022/8/20 15:15
 * @author:LiaoKe
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    public List<Article> ListArticles(){
        List<Article> articles = articleMapper.selectArticles();
        return articles;
    }

    public Article getArticle(Integer id){
        Article article = articleMapper.selectArticle(id);
        return article;
    }

    public int addArticle(Article article){
        article.setCreateTime(new Timestamp(System.currentTimeMillis()));
        int i = articleMapper.insertArticle(article);
        return i;
    }

}
