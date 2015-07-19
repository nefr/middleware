package com.setplex.middleware.web;

import com.setplex.middleware.AbstractTestWeb;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class LoginWebTest extends AbstractTestWeb {
    @Test
    public void testSuccessLogin() throws Exception {
        MvcResult result = mockMvc.perform(post("/login/login").contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"user1\",\"password\":\"xxx\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("username").value("user1"))
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertFalse(content.isEmpty());
    }

    @Test
    public void testFailLogin() throws Exception {
        MvcResult result = mockMvc.perform(post("/login/login").contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"user2\",\"password\":\"xxx\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        Assert.assertTrue(content.isEmpty());
    }
}
