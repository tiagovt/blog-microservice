package br.com.teixeira.blog.postservice.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teixeira.blog.postservice.model.Post;

@RestController
public class PostService {
	@Value("${teste}")
	String url;

	@RequestMapping({ "" })
	String hello() {
		return "Hello " + this.url + "\n";
	}

	@RequestMapping(path = { "{id}" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public Post post(@PathVariable String id) {
		System.out.println(id);
		Post post = new Post();
		post.setDate(new Date());
		post.setText("Testando microservices");
		return post;
	}
}
