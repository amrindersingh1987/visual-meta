package com.visualmeta.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.visualmeta.entity.UserPost;
import com.visualmeta.exception.CustomException;
import com.visualmeta.model.UserInfoModel;
import com.visualmeta.model.UserPostModel;

public interface UserPostService {

	public List<UserPost> getAllPost(int userId, Pageable pageable) throws CustomException;

	public void createNewPost(UserPostModel userPostVo) throws CustomException;

	public UserInfoModel loginUser(String userName, String password) throws CustomException;

	public long getAllPostCount(int userId) throws CustomException;

}
