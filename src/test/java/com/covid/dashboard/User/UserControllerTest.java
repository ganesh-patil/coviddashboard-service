package com.covid.dashboard.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void userCreationTest() throws Exception {
        String uri = "/api/user";
        String jsonData = "{\n" +
                "\t\"name\": \"tyhggh\",\n" +
                "\t\"email\": \"test@test.com\",\n" +
                "\t\"username\" : \"test\",\n" +
                "\t\"password\" :\"test\"\n" +
                "}";
        MockMvc mvc;
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE).characterEncoding("utf-8").content(jsonData)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void userCreationInvalidNameTest() throws Exception {
        String uri = "/api/user";
        String jsonData = "{\n" +
                "\t\"name\": \"\",\n" +
                "\t\"email\": \"test@test.com\",\n" +
                "\t\"username\" : \"test\",\n" +
                "\t\"password\" :\"test\"\n" +
                "}";
        MockMvc mvc;
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON_VALUE).characterEncoding("utf-8").content(jsonData)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);
    }

}
