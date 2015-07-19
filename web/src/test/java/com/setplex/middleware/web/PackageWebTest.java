package com.setplex.middleware.web;

import com.setplex.middleware.AbstractTestWeb;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Ruslan Yatsevich
 */
public class PackageWebTest extends AbstractTestWeb {

    @Test
    public void testPackage() throws Exception {
        mockMvc.perform(get("/packages/{id}", 1001))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.packageId").value(1001))
                .andExpect(jsonPath("$.name").value("sport"));
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/packages").param("packageId", "1111").param("name", "kids"))
                .andExpect(status().isCreated());
    }

}
