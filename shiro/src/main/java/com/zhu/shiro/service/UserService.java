package com.zhu.shiro.service;

import com.zhu.shiro.dao.UserDao;
import com.zhu.shiro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 朱桂林 create 2021/2/3 15:31
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public void regist(User user){
		userDao.save(user);
	}

	public User findByUsername(String userName){
		return userDao.findByUsername(userName);
	}
}
