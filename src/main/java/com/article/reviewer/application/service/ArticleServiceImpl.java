package com.article.reviewer.application.service;

import com.article.reviewer.application.dto.ArticleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.article.reviewer.application.dao.ArticleDao;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        return articleDao.createArticle(articleDto);
    }

    @Override
    public ArticleDto updateArticleById(Long id, ArticleDto articleDto) {
        return articleDao.updateArticleById(id, articleDto);
    }

    @Override
    public List<ArticleDto> getArticlesByParams(String title, Long starCount) {
        return articleDao.getArticlesByParams(title, starCount);
    }

    @Override
    public ArticleDto getArticleById(Long id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public ArticleDto deleteArticleById(Long id) {
        return articleDao.deleteArticleById(id);
    }
}
