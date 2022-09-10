package com.java.login.jwt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.login.jwt.bo.BlogData;
import com.java.login.jwt.service.ReadService;

@RestController
public class BlogController {

	@Autowired
	ReadService blogService;

	/*
	 * This method is for publish or insert a new post .
	 */
	@PostMapping(path = "/publish", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> publish(@RequestBody BlogData data) {
		System.out.println(data);
		Boolean status = blogService.publish(data);
		System.out.println(status);
		if (status)
			return new ResponseEntity<>("Blog Posted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Error while publishing new Blog", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * This method is for read all posts from current db.
	 */
	@GetMapping(path = "/readblog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> readblog() {
		List<BlogData> data = blogService.readblog();

		return new ResponseEntity<>(data, HttpStatus.OK);
	}

	/*
	 * This method will delete blog on the basis of post id.
	 */
	@DeleteMapping(path = "/deleteblog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteblog(@RequestParam int id) {
		Boolean data = blogService.deleteblog(id);
		if (data)
			return new ResponseEntity<>("Blog Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Error while deleting current blog", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/*
	 * This method will update the post on the basis of post id.
	 */
	@PostMapping(path = "/updateblog", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateblog(@RequestBody BlogData data, @RequestParam int id) {
		System.out.println(data);
		Boolean status = blogService.updateblog(data, id);
		if (status)
			return new ResponseEntity<>("Blog Updated Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<>("Error while updating current blog", HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
