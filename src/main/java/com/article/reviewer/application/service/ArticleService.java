package com.article.reviewer.application.service;

import com.article.reviewer.application.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto createArticle(ArticleDto articleDto);

    ArticleDto updateArticleById(Long id, ArticleDto articleDto);

    List<ArticleDto> getArticlesByParams(String title, Long starCount);

    ArticleDto getArticleById(Long id);

    ArticleDto deleteArticleById(Long id);


}
