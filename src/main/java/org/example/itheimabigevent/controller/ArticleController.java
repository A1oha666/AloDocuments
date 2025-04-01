package org.example.itheimabigevent.controller;


import org.example.itheimabigevent.pojo.Article;
import org.example.itheimabigevent.pojo.PageBean;
import org.example.itheimabigevent.pojo.Result;
import org.example.itheimabigevent.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
       PageBean<Article> pb =  articleService.list(pageNum,pageSize,categoryId,state);
       return Result.success(pb);
    }
}
