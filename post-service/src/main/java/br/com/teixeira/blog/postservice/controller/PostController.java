package br.com.teixeira.blog.postservice.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.teixeira.blog.postservice.model.Post;
import br.com.teixeira.blog.postservice.service.PostSerice;

@RestController
public class PostController {

//	@Value("${teste}")
	String url;
	
    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
    
    @Autowired
    PostSerice teste;
    
	@RequestMapping({ "" })
	public String hello() {
		return "Hello " + this.url + "\n";
	}
    
	
	@RequestMapping("{id}")
	public ResponseEntity<Post> post(@PathVariable String id, 
			@RequestHeader(value="Authorization") String authorization,
			Principal user) {
		LOG.info("ID : {}, user name : {}, tokem : {}", id, user.getName(), authorization);
		return teste.post(id);
	}
	
	
}
