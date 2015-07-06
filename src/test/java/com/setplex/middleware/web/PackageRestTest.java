package com.setplex.middleware.web;

import com.setplex.middleware.AbstractTestConfig;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Ruslan Yatsevich
 */
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring-web.xml")
public class PackageRestTest extends AbstractTestConfig {

    @Ignore
    @Test
    public void testChannel() {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer mockServer = MockRestServiceServer.createServer(restTemplate);

        mockServer.expect(requestTo("http://localhost:8080/cms/packages/1001"))
                .andExpect(method(HttpMethod.GET))
                .andExpect(jsonPath("$.packageId", is(1001)))
                .andRespond(withSuccess("{ \"packageId\" : \"1001\", \"name\" : \"ESPN\"}", MediaType.APPLICATION_JSON));

//        PackageTV pk = restTemplate.getForObject("/packages/{id}", PackageTV.class, 1001);
//        Assert.assertEquals("sport", pk.getName());
        mockServer.verify();

    }
}
