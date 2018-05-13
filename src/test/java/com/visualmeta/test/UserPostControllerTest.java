package com.visualmeta.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.visualmeta.controller.UserPostController;
import com.visualmeta.model.UserInfoModel;
import com.visualmeta.service.UserPostService;

/**
 * The WebMVCTest Test Cases class for User Post Controller
 * @author asi
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = UserPostController.class, secure = false)
public class UserPostControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserPostService userPostService;

	private UserInfoModel mockUserInfo = new UserInfoModel(1, "root", "visual", "meta", "1526209671324");

	private String loginData = "{\"username\": \"root\", \"password\": \"root\"}";
	
	
	/**
	 * User login test case
	 * @return void
	 * @throws Exception 
	*/
	@Test
	public void loginDataTest() throws Exception {

		Mockito.when(userPostService.loginUser("root", "root")).thenReturn(mockUserInfo);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/login").param("username", "root").param("password", "root")
				.accept(MediaType.APPLICATION_JSON).content(loginData)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{\"id\":1,\"username\":\"root\",\"firstName\":\"visual\",\"lastName\":\"meta\",\"accessToken\":\"1526209671324\"}";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

	/**
	 * Get User Post Count 
	 * @return void
	 * @throws Exception 
	*/
	
	@Test
	public void getUserPostListTest() throws Exception {

		Mockito.when(userPostService.getAllPostCount(1)).thenReturn(10L);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/user-post-count/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "10";
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

}


