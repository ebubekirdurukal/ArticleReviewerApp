package com.article.reviewer.application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "article_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String articleContent;

    @Column
    private Date publishDate;

    @Column
    private int starCount;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();


}
