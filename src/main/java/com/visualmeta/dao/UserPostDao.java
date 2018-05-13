package com.visualmeta.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.visualmeta.entity.UserInfo;
import com.visualmeta.entity.UserPost;

public interface UserPostDao {

	public List<UserPost> getAllPost(int userId, Pageable pageable) throws Exception;

	public void createNewPost(UserPost userPost) throws Exception;

	public UserInfo loginUser(String userName, String password) throws Exception;

	public long getAllPostCount(int userId) throws Exception;

}
