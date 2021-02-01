/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.service;

import com.zhu.jpa.dao.UserDao;
import com.zhu.jpa.pojo.UserDto;
import com.zhu.jpa.pojo.Users;
import com.zhu.jpa.pojo.UsersDto;
import com.zhu.jpa.viewinterface.UserOnlyUsername;
import com.zhu.jpa.viewinterface.UsersDtoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 朱桂林 create 2021/1/20 16:03
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void createUser(Users user){
		Optional<Users> op = userDao.findById(1L);
		Users users = op.get();
		users.setAddress("jdnfksjdnfsk");
		userDao.save(users);
	}


	/*public Users finduserByUsername(String username){
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
	}*/
	/*public Users findByUsername(String username){
		return userDao.findByUsername(username);
	}*/
	public Users findByUsername(String username){
		return userDao.findByUsername(username,"username");
	}

	public List<Users> findByUsernameLike(String username){
		return userDao.findByUsernameLike(username);
	}

	/*public List<Object> findUsersByUsername(String username){
		return userDao.findUsersByUsername(username);
	}*/
	/*public List<UsersDto> findUsersByUsernameByUsersDto(String username){
		return userDao.findUsersByUsernameByUsersDto(username);
	}*/
	public List<UsersDtoView> findUsersByUsernameByUsersDtoView(String username){
		return userDao.findUsersByUsernameByUsersDtoView(username);
	}

	public List<Users> findUsersByExample(String username){
		Users probe = new Users();
//		probe.setUserid(1L);
		probe.setUsername("xiao");
		ExampleMatcher matcher =ExampleMatcher.matchingAll().withMatcher("username",ExampleMatcher.GenericPropertyMatchers.startsWith());
		Example example =Example.of(probe,matcher);
		List<Users> all = userDao.findAll(example);
		return all;
	}

	public void deleteUsers(String username){
		Optional<Users> optional = userDao.findById(1L);
		Users users = optional.get();
		System.out.println(users);
		userDao.deleteUsers(users);
	}

	public void delete(String username){
		Optional<Users> optional = userDao.findById(1L);
		Users users = optional.get();
		userDao.delete(users);
	}
}
