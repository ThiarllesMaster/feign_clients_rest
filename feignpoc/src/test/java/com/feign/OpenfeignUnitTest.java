package com.feign;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.feign.data.Post;
import com.feign.service.JSONPlaceHolderService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OpenfeignUnitTest {

	@Autowired
	private JSONPlaceHolderService service;

	@Test
	public void whenGetPosts_thenListPostSizeGreaterThanZero() {

		List<Post> posts = service.getPosts();

		assertFalse(posts.isEmpty());
	}
	
	 @Test
	    public void whenGetPostWithId_thenPostExist() {

	        Post post = service.getPostById(1L);

	        assertNotNull(post);
	    }
}
