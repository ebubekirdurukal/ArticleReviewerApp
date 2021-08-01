package com.article.reviewer.application.dao;

import com.article.reviewer.application.dto.ArticleDto;
import com.article.reviewer.application.exception.NoArticleFoundException;
import com.article.reviewer.application.mapper.ArticleMapper;
import com.article.reviewer.application.model.QArticle;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.article.reviewer.application.model.Article;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao {

    @Autowired
    ArticleMapper articleMapper;

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        em.persist(articleMapper.dto2Article(articleDto));
        return articleDto;
    }

    @Override
    public ArticleDto updateArticleById(Long id, ArticleDto articleDto) {
        QArticle article = QArticle.article;
        queryFactory.update(article)
                .set(article.articleContent, articleDto.getArticleContent())
                .set(article.starCount, articleDto.getStarCount())
                .set(article.title, articleDto.getTitle())
                .set(article.author, articleDto.getAuthor())
                .set(article.reviews, articleDto.getReviews())
                .set(article.publishDate, articleDto.getPublishDate())
                .where(article.id.eq(id))
                .execute();
        return articleDto;
    }

    @Override
    public List<ArticleDto> getArticlesByParams(String title, Long starCount) {
        QArticle article = QArticle.article;
        List<Article> c;
        if (title != null && starCount != null) {
            c = queryFactory.selectFrom(article)
                    .where(article.title.eq(title).and(article.starCount.eq(Math.toIntExact(starCount))))
                    .fetch();
        } else {
            c = queryFactory.selectFrom(article).fetch();
        }

        if (c != null) {
            return articleMapper.articleList2ArticleDtoList(c);
        } else {
            throw new NoArticleFoundException();
        }
    }

    @Override
    public ArticleDto getArticleById(Long id) {
        QArticle article = QArticle.article;
        Article c = queryFactory.selectFrom(article)
                .where(article.id.eq(id))
                .fetchOne();

        if (c != null) {
            return articleMapper.article2Dto(c);
        } else {
            throw new NoArticleFoundException();
        }
    }

    @Override
    public ArticleDto deleteArticleById(Long id) {
        QArticle article = QArticle.article;
        queryFactory.delete(article)
                .where(article.id.eq(id));
        return null;
    }
}
