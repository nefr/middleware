package com.setplex.middleware.web;

import com.setplex.middleware.AbstractTestWeb;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
                .andExpect(jsonPath("$.packageId", is(1001)))
                .andExpect(jsonPath("$.name", is("sport")));
    }

}
