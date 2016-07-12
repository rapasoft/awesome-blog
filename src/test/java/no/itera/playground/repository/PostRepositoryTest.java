package no.itera.playground.repository;

import no.itera.playground.AwesomeBlogApplication;
import no.itera.playground.model.Author;
import no.itera.playground.model.Category;
import no.itera.playground.model.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Pavol Rajzak, Itera
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AwesomeBlogApplication.class)
@WebIntegrationTest
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    public void savePostToDatabase() {
        Post post = new Post();

        post.setAuthor(Author.builder().firstName("Pavol").lastName("Rajzak").build());
        post.setCategories(Arrays.asList(new Category(null, "Test"), new Category(null, "Test some more")));
        post.setTitle("The test has landed...");
        post.setContent("This is a test!");

        postRepository.save(post);

        assertEquals(1, postRepository.findAll().size());
    }

}