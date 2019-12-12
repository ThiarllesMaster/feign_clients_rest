package com.feign.service;

import java.util.List;

import com.feign.data.Post;

public interface JSONPlaceHolderService {
	
	List<Post> getPosts();

    Post getPostById(Long id);

}
