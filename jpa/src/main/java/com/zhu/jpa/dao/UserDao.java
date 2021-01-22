/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.dao;

import com.zhu.jpa.pojo.UserDto;
import com.zhu.jpa.pojo.Users;
import com.zhu.jpa.viewinterface.UserOnlyUsername;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 朱桂林 create 2021/1/20 15:47
 */
@Repository
public interface UserDao extends JpaRepository<Users,Long> {
	Users findUsersByUsername(String username);

	Page<Users> findByUsername(String username, Pageable pageable);
	Slice<Users> findByAddress(String address, Pageable pageable);
	List<Users> findByUsername(String username, Sort sort);
	List<Users> findByAge(Integer age, Pageable pageable);

	UserDto findByUsername(String username);
	UserOnlyUsername findTopByUsername(String username);
}
