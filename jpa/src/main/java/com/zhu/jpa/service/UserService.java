/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.service;

import com.zhu.jpa.dao.UserDao;
import com.zhu.jpa.pojo.UserDto;
import com.zhu.jpa.pojo.Users;
import com.zhu.jpa.viewinterface.UserOnlyUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱桂林 create 2021/1/20 16:03
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void createUser(Users user){
		userDao.save(user);
	}

	public Users finduserByUsername(String username){
		return userDao.findUsersByUsername(username);
	}

	public Page<Users> findByUsername(String username){
		return userDao.findByUsername(username, PageRequest.of(0,10));
	}

	public Slice<Users> findByAddress(String address){
		return userDao.findByAddress(address,PageRequest.of(0,10));
	}

	public List<Users> finduserByUsernameBySortUsername(String username){
		return userDao.findByUsername(username, Sort.by("username"));
	}

	public List<Users> findByAge(String username){
		return userDao.findByAge(22,PageRequest.of(0,10));
	}

	public UserDto findByUsername1(String username){
		return userDao.findByUsername(username);
	}

	public UserOnlyUsername findTopByUsername(String username){
		return userDao.findTopByUsername(username);
	}
}
