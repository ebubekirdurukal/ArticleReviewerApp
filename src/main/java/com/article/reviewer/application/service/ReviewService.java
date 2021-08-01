package com.article.reviewer.application.service;

import com.article.reviewer.application.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    ReviewDto createReview(ReviewDto reviewDto);

    ReviewDto updateReviewById(Long id, ReviewDto reviewDto);

    List<ReviewDto> getAllReviews();

    List<ReviewDto> getReviewsByParams(String reviewer,  Long articleId);

    ReviewDto getReviewById(Long id);

    ReviewDto deleteReviewById(Long id);

}
