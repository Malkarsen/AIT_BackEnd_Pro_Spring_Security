package de.ait.training.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PersonalControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Test@DisplayName("Public API is available for all")
    void testPublicEndpointShouldBeOpenForAll() throws Exception {
        mockMvc.perform(get("/api/public/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("public")));
    }

    @Test@DisplayName("Access attempt without login for User")
    void testUserEndpointWithoutAuth() throws Exception {
        mockMvc.perform(get("/api/user/hello"))
                .andExpect(status().isUnauthorized());
    }

    @Test@DisplayName("Access with login for User")
    void testUserEndpointWithAuth() throws Exception {
        mockMvc.perform(get("/api/user/hello")
                .with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("USER")));
    }
}
