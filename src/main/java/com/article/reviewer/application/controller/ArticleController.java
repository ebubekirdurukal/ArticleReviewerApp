package com.article.reviewer.application.controller;

import com.article.reviewer.application.dto.ArticleDto;
import com.article.reviewer.application.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("")
    public ResponseEntity<ArticleDto> createArticle(@RequestBody ArticleDto articleDto) {
        return new ResponseEntity<>(articleService.createArticle(articleDto), HttpStatus.OK);
    }

    @PutMapping("/{articleId}")
    public ResponseEntity<ArticleDto> updateArticleById(@PathVariable(value = "articleId") Long articleId, @RequestBody ArticleDto articleDto) {
        return new ResponseEntity<>(articleService.updateArticleById(articleId, articleDto), HttpStatus.OK);
    }

    @DeleteMapping("/{articleId}")
    public ResponseEntity<ArticleDto> deleteArticleById(@PathVariable(value = "articleId") Long articleId) {
        return new ResponseEntity<>(articleService.deleteArticleById(articleId), HttpStatus.OK);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleDto> getArticleById(@PathVariable(value = "articleId") Long articleId) {
        return new ResponseEntity<>(articleService.getArticleById(articleId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ArticleDto>> getArticlesByParams(@RequestParam(required = false) String title, @RequestParam(required = false) Long starCount) {
        return new ResponseEntity<>(articleService.getArticlesByParams(title, starCount), HttpStatus.OK);
    }
}
