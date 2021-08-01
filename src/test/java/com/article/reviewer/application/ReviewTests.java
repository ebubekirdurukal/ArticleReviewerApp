package com.article.reviewer.application;


import com.article.reviewer.application.model.Article;
import com.article.reviewer.application.model.Review;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReviewTests {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @WithMockUser(username = "user", password = "password", roles = "USER")
    void shouldReturnSuccessOnProperReview() throws Exception {

        Review  review = new Review();
        review.setReviewer("Test Reviewer");
        review.setReviewContent("Test Review Content");
        review.setArticle(new Article());

        mockMvc.perform(MockMvcRequestBuilders
                .post("/articles")
                .content(asJsonString(review))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
