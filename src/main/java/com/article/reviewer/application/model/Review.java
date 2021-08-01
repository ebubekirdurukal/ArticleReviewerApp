package com.article.reviewer.application.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String reviewer;

    @Column
    private String reviewContent;

    @JsonIgnore
    @JoinColumn(name = "article_id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Article article;


}
