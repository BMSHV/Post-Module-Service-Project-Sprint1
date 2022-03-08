package com.springboot.sprint1module2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.sprint1.entity.PostEntity;
import com.springboot.sprint1.exception.PostNotFoundException;

import com.springboot.sprint1.model.Post;

import com.springboot.sprint1.repository.PostRepository;
import com.springboot.sprint1.service.PostService;
import com.springboot.sprint1.service.PostServiceImpl;

@SpringBootTest(classes = PostServiceTest.class)
public class PostServiceTest {

	@InjectMocks
	private PostService postService = new PostServiceImpl();

	@Mock
	private PostRepository postRepository;

	@Test
	void testGetPostDetails() {

		PostEntity post = new PostEntity();
		post.setCategoryName("Medical");
		post.setDonorId(1);
		post.setFundCollected(50000);
		post.setFundNeeded(60000);
		post.setPostDate(LocalDate.now());
		post.setPostId(1);
		post.setUserDescription("Cancer");
		post.setUserId(1);

		Optional<PostEntity> optionalPost = Optional.of(post);
		int postId = 1;

		when(postRepository.findById(1)).thenReturn(optionalPost);

		Post existingPost = postService.getPostDetails(postId);

		assertEquals(post.getCategoryName(), existingPost.getCategoryName());
		assertEquals(post.getDonorId(), existingPost.getDonorId());
		assertEquals(post.getFundCollected(), existingPost.getFundCollected());
		assertEquals(post.getFundNeeded(), existingPost.getFundNeeded());
		assertEquals(post.getPostDate(), existingPost.getPostDate());
		assertEquals(post.getUserDescription(), existingPost.getUserDescription());
		assertEquals(post.getUserId(), existingPost.getUserId());

	}

	@Test
	 void testGetPostByIdNotFound() {

		int postId = 200;

		when(postRepository.findById(postId)).thenThrow(PostNotFoundException.class);

		assertThrows(PostNotFoundException.class, () -> postService.getPostById(postId));

	}

	@Test
    void testDeletePost() {

		int postId = 1;
		PostEntity post = new PostEntity();

		post.setCategoryName("Medical");
		post.setDonorId(1);
		post.setFundCollected(50000);
		post.setFundNeeded(60000);
		post.setPostDate(LocalDate.now());
		post.setPostId(1);
		post.setUserDescription("Cancer");
		post.setUserId(1);

		Optional<PostEntity> optional = Optional.of(post);
		when(postRepository.findById(1)).thenReturn(optional);
		postService.deletePost(post.getPostId());
		verify(postRepository, times(1)).deleteById(postId);
	}

}