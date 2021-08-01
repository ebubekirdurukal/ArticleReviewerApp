package com.article.reviewer.application.dao;

import com.article.reviewer.application.dto.ReviewDto;
import com.article.reviewer.application.exception.NoReviewFoundException;
import com.article.reviewer.application.mapper.ReviewMapper;
import com.article.reviewer.application.model.QReview;
import com.article.reviewer.application.model.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    ReviewMapper reviewMapper;

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        em.persist(reviewMapper.dto2Review(reviewDto));
        return reviewDto;
    }

    @Override
    public ReviewDto updateReviewById(Long id, ReviewDto reviewDto) {
        QReview review = QReview.review;
        queryFactory.update(review)
                .set(review.reviewer, reviewDto.getReviewer())
                .set(review.reviewContent, reviewDto.getReviewContent())
                .set(review.article, review.article)
                .where(review.id.eq(id))
                .execute();
        return reviewDto;
    }

    @Override
    public List<ReviewDto> getReviewsByParams(String reviewer, Long articleId) {
        QReview review = QReview.review;
        List<Review> c;
        if (reviewer != null && articleId != null) {
            c = queryFactory.selectFrom(review)
                    .where(review.reviewer.eq(reviewer).and(review.article.id.eq(articleId)))
                    .fetch();
        } else {
            c = queryFactory.selectFrom(review).fetch();
        }
        if (c != null) {
            return reviewMapper.reviewList2DtoList(c);
        } else {
            throw new NoReviewFoundException();
        }
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        QReview review = QReview.review;
        Review c = queryFactory.selectFrom(review)
                .where(review.id.eq(id))
                .fetchOne();
        if (c != null) {
            return reviewMapper.review2Dto(c);
        } else {
            throw new NoReviewFoundException();
        }
    }

    @Override
    public ReviewDto deleteReviewById(Long id) {
        QReview review = QReview.review;
        queryFactory.delete(review)
                .where(review.id.eq(id));
        return null;
    }
}
