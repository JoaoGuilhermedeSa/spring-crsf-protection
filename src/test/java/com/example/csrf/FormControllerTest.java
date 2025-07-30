package com.example.csrf;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.example.csrf.controller.FormController;

@WebMvcTest(FormController.class)
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void submitFormWithCsrfShouldSucceed() throws Exception {
        mockMvc.perform(post("/submit")
                .param("data", "test data")
                .with(csrf()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void submitFormWithoutCsrfShouldFail() throws Exception {
        mockMvc.perform(post("/submit")
                .param("data", "test data"))
                .andExpect(status().isForbidden());
    }
}
