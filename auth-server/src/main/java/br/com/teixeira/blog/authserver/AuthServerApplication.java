package br.com.teixeira.blog.authserver;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class AuthServerApplication {
	
	@Autowired
	private ConsumerTokenServices consumerTokenServices;

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	
//	@RequestMapping("/logout")
//	public HttpStatus logout(@RequestHeader(value="Authorization") String authorization) {
//		consumerTokenServices.revokeToken(authorization);
//		return HttpStatus.OK;
//	}
	
	
	@RequestMapping("/teste")
	public String logout(String authorization) {
		consumerTokenServices.revokeToken(authorization);
		return HttpStatus.OK.toString();
	}
	
	
}
