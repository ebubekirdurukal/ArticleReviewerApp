package com.article.reviewer.application.mapper;

import com.article.reviewer.application.dto.ReviewDto;
import com.article.reviewer.application.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewMapper {

    public ReviewDto review2Dto(Review review) {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setReviewer(review.getReviewer());
        reviewDto.setReviewContent(review.getReviewContent());
        reviewDto.setArticle(review.getArticle());
        return reviewDto;
    }

    public Review dto2Review(ReviewDto reviewDto) {
        Review review = new Review();
        review.setReviewer(review.getReviewer());
        review.setReviewContent(reviewDto.getReviewContent());
        review.setArticle(reviewDto.getArticle());
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
