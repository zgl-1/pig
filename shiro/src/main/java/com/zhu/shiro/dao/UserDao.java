package com.zhu.shiro.dao;

import com.zhu.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 朱桂林 create 2021/2/3 15:30
 */
public interface UserDao extends JpaRepository<User,Integer> {
	User findByUsername(String userName);
}
