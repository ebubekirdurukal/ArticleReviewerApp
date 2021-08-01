package com.article.reviewer.application;


import com.article.reviewer.application.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Date;

import static com.article.reviewer.application.ReviewTests.asJsonString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ArticleTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    void shouldReturnSuccessOnProperArticle() throws Exception {

        Article article = new Article();
        article.setArticleContent("Test content");
        article.setAuthor("Test Author");
        article.setPublishDate(new Date(2021-07-31));
        article.setTitle("Test title");
        article.setStarCount(1);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/articles")
                .content(asJsonString(article))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
