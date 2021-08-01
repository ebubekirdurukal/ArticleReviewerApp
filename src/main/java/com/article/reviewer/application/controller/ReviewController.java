package com.article.reviewer.application.controller;


import com.article.reviewer.application.dto.ReviewDto;
import com.article.reviewer.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("")
    public ResponseEntity<ReviewDto> createReview(@RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.createReview(reviewDto), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> updateReviewById(@PathVariable(value = "reviewId") Long reviewId, @RequestBody ReviewDto reviewDto) {
        return new ResponseEntity<>(reviewService.updateReviewById(reviewId, reviewDto), HttpStatus.OK);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> deleteReviewById(@PathVariable(value = "reviewId") Long reviewId) {
        return new ResponseEntity<>(reviewService.deleteReviewById(reviewId), HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> getReviewById(@PathVariable(value = "reviewId") Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(reviewId), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<ReviewDto>> getReviewsByParams(@RequestParam(required = false) String reviewer, @RequestParam(required = false) Long articleId) {
        return new ResponseEntity<>(reviewService.getReviewsByParams(reviewer, articleId), HttpStatus.OK);
    }
}
