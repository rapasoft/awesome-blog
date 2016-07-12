package no.itera.playground.controller;

import com.google.gson.Gson;
import no.itera.playground.AwesomeBlogApplication;
import no.itera.playground.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Pavol Rajzak, Itera
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AwesomeBlogApplication.class)
@WebIntegrationTest
public class PostControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getAll() throws Exception {
        mockMvc.perform(get("/post"))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }

    @Test
    public void createNewPost() throws Exception {
        Post post = new Post(null, "Test", "Test");

        mockMvc.perform(post("/post").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(post)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test"));
    }

}