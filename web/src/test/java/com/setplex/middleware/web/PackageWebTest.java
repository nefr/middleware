package com.setplex.middleware.web;

import com.setplex.middleware.AbstractTestWeb;
import com.setplex.middleware.domain.*;
import com.setplex.middleware.domain.Package;
import com.setplex.middleware.service.TVService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class PackageWebTest extends AbstractTestWeb {
    @Autowired
    TVService service;

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/packages").param("packageId", "1111").param("name", "kids"))
                .andExpect(status().isCreated());
//                .andReturn();

        List<Package> list = service.getPackagesWithChannels();
        for (Package aPackage : list) {
            System.out.println(aPackage.toString() + "  " + aPackage.getName());
        }


    }
    @Test
    public void testPackage() throws Exception {
        mockMvc.perform(get("/packages/{id}", 1002))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("id").value(1002))
                .andExpect(jsonPath("$.name").value("movie"));
    }

}
