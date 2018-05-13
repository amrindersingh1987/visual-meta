package com.visualmeta.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.visualmeta.entity.UserInfo;
import com.visualmeta.entity.UserPost;
/**
 * This class is represent as Dao class. in this we are finally performing the CRUD operation with Databases
 * @author asi
 *
 */
@Transactional
@Repository
public class UserPostDaoImpl implements UserPostDao {
	private static final String qryUserPosts = "FROM UserPost as uPost WHERE uPost.userInfo.id = :id order by uPost.createdDate desc";
	private static final String qryUserInfo = "FROM UserInfo as uInfo WHERE uInfo.username = :username and uInfo.password = :password";
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * This method getting all user post on the bases of userid 
	 * @param: int, Pageable
	 * @return List<UserPost>
	 * @exception: Exception
	 */
	@Override
	public List<UserPost> getAllPost(int userId, Pageable pageable) throws Exception {
		Query createQuery = entityManager.createQuery(qryUserPosts);
		createQuery.setParameter("id", userId);
		createQuery.setFirstResult((int) pageable.getOffset());
		createQuery.setMaxResults(pageable.getPageSize());
		@SuppressWarnings("unchecked")
		List<UserPost> resultList = createQuery.getResultList();
		return resultList.size() > 0 ? resultList : null;
	}

	/**
	 * This method getting all user post count on the bases of userid 
	 * @param: int
	 * @return Long
	 * @exception: Exception
	 */
	@Override
	public long getAllPostCount(int userId) throws Exception {
		List<UserPost> resultList = entityManager.createQuery(qryUserPosts).setParameter("id", userId).getResultList();
		return resultList.size();
	}

	/**
	 * This method create new user post
	 * @param: UserPost
	 * @return void
	 * @exception: Exception
	 */
	
	@Override
	public void createNewPost(UserPost userPost) throws Exception {
		entityManager.persist(userPost);
	}
	

	/**
	 * This method check user exist in database or not
	 * @param: String
	 * @return UserInfo
	 * @exception: Exception
	 */

	@Override
	public UserInfo loginUser(String userName, String password) throws Exception {
		@SuppressWarnings("unchecked")
		List<UserInfo> list = entityManager.createQuery(qryUserInfo).setParameter("username", userName).setParameter("password", password).getResultList();
		UserInfo userInfo = null;
		if (list.size() == 1) {
			userInfo = list.get(0);
		}
		return userInfo;
	}

}
