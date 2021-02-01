/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.controller;

import com.zhu.jpa.pojo.UserDto;
import com.zhu.jpa.pojo.Users;
import com.zhu.jpa.pojo.UsersDto;
import com.zhu.jpa.service.UserService;
import com.zhu.jpa.viewinterface.UserOnlyUsername;
import com.zhu.jpa.viewinterface.UsersDtoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author 朱桂林 create 2021/1/20 16:05
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/createUser")
	public void createUser(){
		Users user = new Users();
		user.setUsername("xiaohuang");
		user.setAddress("ds332fds");
		user.setAge(22);
		userService.createUser(user);
	}


	/*@RequestMapping("/find")
	public Users finduserByUsername(){
		return userService.finduserByUsername("xiaozhu");
	}

	@RequestMapping("/findByUsername")
	public Page<Users> findByUsername(){
		return userService.findByUsername("xiaozhu");
	}

	@RequestMapping("/findByAddress")
	public Slice<Users> findByAddress(){
		return userService.findByAddress("bfbfbbf");
	}

	@RequestMapping("/finduserByUsernameBySortUsername")
	public List<Users> finduserByUsernameBySortUsername(){
		return userService.finduserByUsernameBySortUsername("xiaozhu");
	}

	@RequestMapping("/findByAge")
	public List<Users> findByAge(){
		return userService.findByAge("xiaozhu");
	}

	@RequestMapping("/findByUsername1")
	public UserDto findByUsername1(){
		return userService.findByUsername1("xiaozhu");
	}

	@RequestMapping("/findTopByUsername")
	public UserOnlyUsername findTopByUsername(){
		UserOnlyUsername xiaozhu = userService.findTopByUsername("xiaozhu");
		System.out.println(xiaozhu.getUsername());
		return xiaozhu;
	}*/

	@RequestMapping("/findByUsername")
	public Users findByUsername(){
		return userService.findByUsername("xiaozhu");
	}

	@RequestMapping("/findByUsernameLike")
	public List<Users> findByUsernameLike(String username){
		return userService.findByUsernameLike(username);
	}

	/*@RequestMapping("/findUsersByUsername")
	public List<Object> findUsersByUsername(String username){
		return userService.findUsersByUsername(username);
	}*/

	@RequestMapping("/findUsersByUsernameByUsersDtoView")
	public List<UsersDtoView> findUsersByUsernameByUsersDtoView(String username){
		return userService.findUsersByUsernameByUsersDtoView(username);
	}

	@RequestMapping("/findUsersByExample")
	public List<Users> findUsersByExample(String username){
		return userService.findUsersByExample(username);
	}

	@RequestMapping("/deleteUsers")
	public void deleteUsers(String username){
		userService.deleteUsers(username);
	}

	@RequestMapping("/delete")
	public void delete(String username){
		userService.delete(username);
	}

	@RequestMapping("/finduser/{id}")
	public Users finduserById(@PathVariable("id") Users users) {
		return users;
	}

	@RequestMapping("/finduser")
	public Users finduser(@RequestParam("id") Users users) {
		return users;
	}
}
