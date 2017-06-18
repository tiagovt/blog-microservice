package br.com.teixeira.blog.postservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import br.com.teixeira.blog.postservice.model.Post;
import br.com.teixeira.blog.postservice.service.PostSerice;

@RestController
public class PostController {
	@Value("${teste}")
	String url;
	
    //private static final Logger LOG = LoggerFactory.getLogger(PostService.class);
    
    @Autowired
    PostSerice teste;
    
	@RequestMapping({ "" })
	public String hello() {
		return "Hello " + this.url + "\n";
	}
    
	
	@RequestMapping("{id}")
	public ResponseEntity<Post> post(@PathVariable String id) {
		System.out.println(id);
		return teste.post(id);
	}
	
	
}
