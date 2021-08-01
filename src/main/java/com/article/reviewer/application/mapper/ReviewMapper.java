package com.article.reviewer.application.mapper;

import com.article.reviewer.application.dto.ReviewDto;
import com.article.reviewer.application.model.Article;
import com.article.reviewer.application.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReviewMapper {

    public ReviewDto review2Dto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setReviewer(review.getReviewer());
        reviewDto.setReviewContent(review.getReviewContent());
        reviewDto.setArticleId(review.getArticle().getId());
        return reviewDto;
    }

    public Review dto2Review(ReviewDto reviewDto) {
        Article article = new Article();
        article.setId(reviewDto.getArticleId());
        Review review = new Review();
        review.setReviewer(reviewDto.getReviewer());
        review.setReviewContent(reviewDto.getReviewContent());
        review.setArticle(article);
        return review;
    }

    public List<ReviewDto> reviewList2DtoList(List<Review> reviews) {
        List<ReviewDto> dtoList = new ArrayList<>();
        for (Review review : reviews) {
            dtoList.add(review2Dto(review));
        }
        return dtoList;
    }
}
