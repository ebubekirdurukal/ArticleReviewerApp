package com.article.reviewer.application.dto;

import com.article.reviewer.application.model.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {

    private String title;
    private String author;
    private String articleContent;
    private Date publishDate;
    private int starCount;
    private List<Review> reviews;

}
