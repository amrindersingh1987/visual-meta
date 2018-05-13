package com.visualmeta.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.visualmeta.dao.UserPostDao;
import com.visualmeta.entity.UserInfo;
import com.visualmeta.entity.UserPost;
import com.visualmeta.exception.CustomException;
import com.visualmeta.model.UserInfoModel;
import com.visualmeta.model.UserPostModel;
/**
 * This is Service Layer,  we can user Dao Layer to to perform CRUD operation  on the Databases
 * @author Amrinder Singh
 *
 */

@Service
public class UserPostServiceImpl implements UserPostService {
	@Autowired
	private UserPostDao userPostDao;

	@Override
	public List<UserPost> getAllPost(int userId, Pageable pageable) throws CustomException {
		try {
			return userPostDao.getAllPost(userId, pageable);
		} catch (Exception e) {
			throw new CustomException("Error while getting user post");
		}
	}

	/**
	 * This method getting input from controller as UserPostModel and create new  UserPost entity with particular data , finally transfer to dao layer 
	 * @param: UserPostModel
	 * @return void
	 * @exception: CustomException
	 */
	@Override
	public void createNewPost(UserPostModel userPostVo) throws CustomException {
		try {
			UserPost userPost = new UserPost();
			userPost.setText(userPostVo.getText());
			userPost.setTitle(userPostVo.getTitle());
			userPost.setDescription(userPostVo.getDescription());
			userPost.setUserInfo(new UserInfo(userPostVo.getUserId()));
			userPost.setCreatedDate(new Date());
			userPostDao.createNewPost(userPost);
		} catch (Exception e) {
			throw new CustomException("Error Whilw creationg new post");
		}

	}
	
	/**
	 * This method getting input from controller as String parameter and return UserInfoModel object with access token 
	 * @param: String
	 * @return UserInfoModel
	 * @exception: CustomException
	 */

	@Override
	public UserInfoModel loginUser(String userName, String password) throws CustomException {
		try {
			UserInfo userInfo = userPostDao.loginUser(userName, password);
			UserInfoModel model = new UserInfoModel(userInfo.getId(), userInfo.getUsername(), userInfo.getFirstName(),
					userInfo.getLastName(), new Date().getTime() + "");
			return model;
		} catch (Exception e) {
			throw new CustomException("Invalid Username and password");
		}
	}

	@Override
	public long getAllPostCount(int userId) throws CustomException {
		try {
			return userPostDao.getAllPostCount(userId);
		} catch (Exception e) {
			throw new CustomException("Error while getting count");
		}
	}

}
