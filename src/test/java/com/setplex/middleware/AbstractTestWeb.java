package com.setplex.middleware;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author Ruslan Yatsevich
 */
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring-web.xml")
public abstract class AbstractTestWeb extends AbstractTestConfig {
    public static final MediaType APPLICATION_JSON_UTF8 = MediaType.parseMediaType("application/json;charset=UTF-8");
//            new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void initialize() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
}
