package com.lk.hdlazy_blog.controller;

import com.lk.hdlazy_blog.pojo.Article;
import com.lk.hdlazy_blog.pojo.User;
import com.lk.hdlazy_blog.service.ArticleService;
import com.lk.hdlazy_blog.util.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName:ArticleController
 * Package:com.lk.demo.controller
 * Description:
 *
 * @date:2022/8/20 15:16
 * @author:LiaoKe
 */
@RestController
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private WebUtil webUtil;

    //获取文章列表
    @RequestMapping("/list")
    public Object list(){
        List<Article> articles = articleService.ListArticles();
        log.debug("{}",articles);
        return articles;
    }

    //获取文章详情
    @RequestMapping("/detail")
    public Object blog(String id){
        Article article = articleService.getArticle(Integer.parseInt(id));
        return article;
    }

    //添加文章
    @PostMapping("add")
    public Object addBlog(@RequestBody Article article, HttpServletRequest request, HttpServletResponse response){
        User user = webUtil.validateLogin(request);
        if(user==null){
            response.setStatus(401);
            return null;
        }
        article.setUserId(user.getId());
        int i = articleService.addArticle(article);
        Map<String, Object> map = new HashMap<>();
        map.put("ok", true);
        return map;
    }
}
