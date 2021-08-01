package com.article.reviewer.application.dto;

import com.article.reviewer.application.model.Article;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

    private String reviewer;
    private String reviewContent;
    private Article article;

}
