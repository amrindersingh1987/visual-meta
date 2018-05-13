package com.visualmeta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visualmeta.entity.UserInfo;
import com.visualmeta.entity.UserPost;
import com.visualmeta.exception.CustomException;
import com.visualmeta.model.UserInfoModel;
import com.visualmeta.model.UserPostModel;
import com.visualmeta.service.UserPostService;


/**
 * This is main Controller for Rest API
 * @author Amrinder Singh
 *
 */
@RestController
@RequestMapping(value = "/api/")
public class UserPostController {

	@Autowired
	UserPostService userPostService;
	
	@GetMapping("/")
	public ResponseEntity<String> welcome() {
		return new ResponseEntity<String>("welcome post api", HttpStatus.OK);		
	}

	@PostMapping("/login")
	public ResponseEntity<UserInfoModel> loginUser(@RequestBody UserInfo user) {
		ResponseEntity<UserInfoModel> response = null;
		try {
			if (user != null) {
				response = new ResponseEntity<UserInfoModel>(userPostService.loginUser(user.getUsername(), user.getPassword()), HttpStatus.OK);
			}

		} catch (CustomException ex) {
			throw new RuntimeException(ex.getMessage());
		}
		return response;
	}

	@PostMapping("/create-post")
	public ResponseEntity<Void> createPost(@RequestBody UserPostModel userPost) {
		ResponseEntity<Void> response = null;
		try {
			if (userPost != null) {
				userPostService.createNewPost(userPost);
				response = new ResponseEntity<Void>(HttpStatus.CREATED);
			}
		} catch (CustomException ex) {
			throw new RuntimeException(ex.getMessage());
		}
		return response;
	}

	@GetMapping("/user-post/{id}")
	public ResponseEntity<List<UserPost>> getAllUserPost(@PathVariable("id") Integer id, Pageable pageable) {
		ResponseEntity<List<UserPost>> response = null;
		try {
			response = new ResponseEntity<List<UserPost>>(userPostService.getAllPost(id, pageable), HttpStatus.OK);
		} catch (CustomException e) {
			throw new RuntimeException(e.getMessage());
		}
		return response;
	}

	@GetMapping("/user-post-count/{id}")
	public ResponseEntity<Long> getUserPostCount(@PathVariable("id") Integer id) {
		ResponseEntity<Long> response = null;
		try {
			response = new ResponseEntity<Long>(userPostService.getAllPostCount(id), HttpStatus.OK);
		} catch (CustomException e) {
			throw new RuntimeException(e.getMessage());
		}
		return response;
	}

}
