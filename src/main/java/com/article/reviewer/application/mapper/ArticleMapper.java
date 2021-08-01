package com.article.reviewer.application.mapper;

import com.article.reviewer.application.dto.ArticleDto;
import com.article.reviewer.application.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleMapper {

    public ArticleDto article2Dto(Article article) {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleContent(article.getArticleContent());
        articleDto.setAuthor(article.getAuthor());
        articleDto.setPublishDate(article.getPublishDate());
        articleDto.setTitle(article.getTitle());
        articleDto.setStarCount(article.getStarCount());
        return articleDto;
    }

    public Article dto2Article(ArticleDto articleDto) {
        Article article = new Article();
        article.setArticleContent(articleDto.getArticleContent());
        article.setAuthor(articleDto.getAuthor());
        article.setPublishDate(articleDto.getPublishDate());
        article.setTitle(articleDto.getTitle());
        article.setStarCount(articleDto.getStarCount());

        return article;

    }

    public List<ArticleDto> articleList2ArticleDtoList(List<Article> articles) {
        List<ArticleDto> dtoList = new ArrayList<>();
        for (Article article : articles) {
            dtoList.add(article2Dto(article));
        }
        return dtoList;
    }

}
