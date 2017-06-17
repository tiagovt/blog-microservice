package br.com.teixeira.blog.postservice.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Post implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private Date date;
}
