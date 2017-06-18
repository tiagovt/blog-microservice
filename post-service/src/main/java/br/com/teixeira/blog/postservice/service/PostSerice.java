package br.com.teixeira.blog.postservice.service;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.teixeira.blog.postservice.model.Post;

@Component
public class PostSerice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@HystrixCommand(fallbackMethod = "fallBack")
	public ResponseEntity<Post> post(String id) {
		System.out.println(id);
		Post post = new Post();
		post.setDate(new Date());
		post.setText("Testando microservices");
		return Optional.ofNullable(post)
		            .map(par -> new ResponseEntity<>(par,HttpStatus.OK))
		            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	
	public ResponseEntity<Post> fallBack(String id) {
		Post post = new Post();
		return Optional.ofNullable(post)
				.map(par -> new ResponseEntity<>(par,HttpStatus.OK))
	            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
