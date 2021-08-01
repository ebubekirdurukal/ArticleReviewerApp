package com.article.reviewer.application.service;

import com.article.reviewer.application.dao.ReviewDao;
import com.article.reviewer.application.dto.ReviewDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private ReviewDao reviewDao;

    @Override
    public ReviewDto createReview(ReviewDto reviewDto) {
        return reviewDao.createReview(reviewDto);
    }

    @Override
    public ReviewDto updateReviewById(Long id, ReviewDto reviewDto) {
        return reviewDao.updateReviewById(id, reviewDto);
    }

    @Override
    public List<ReviewDto> getReviewsByParams(String reviewer, Long articleId) {
        return reviewDao.getReviewsByParams(reviewer, articleId);
    }

    @Override
    public ReviewDto getReviewById(Long id) {
        return reviewDao.getReviewById(id);
    }

    @Override
    public ReviewDto deleteReviewById(Long id) {
        return reviewDao.deleteReviewById(id);
    }
}
