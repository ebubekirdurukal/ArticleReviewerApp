package com.article.reviewer.application.service;

import com.article.reviewer.application.dto.ReviewDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        return null;
    }

    @Override
    public ReviewDto updateReviewById(Long id, ReviewDto reviewDto) {
        return null;
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return null;
    }

    @Override
    public List<ReviewDto> getReviewsByParams(String reviewer,Long articleId) {
        return null;
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        return null;
    }

    @Override
    public ReviewDto deleteReviewById(Long id) {
        return null;
    }
}
