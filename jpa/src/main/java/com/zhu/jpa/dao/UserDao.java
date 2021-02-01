/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.dao;

import com.zhu.jpa.pojo.UserDto;
import com.zhu.jpa.pojo.Users;
import com.zhu.jpa.pojo.UsersDto;
import com.zhu.jpa.repository.CustomizedUserRepository;
import com.zhu.jpa.repository.CustomizedUserRepositoryImpl;
import com.zhu.jpa.viewinterface.UserOnlyUsername;
import com.zhu.jpa.viewinterface.UsersDtoView;
import org.hibernate.sql.Select;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 朱桂林 create 2021/1/20 15:47
 */
@Repository
public interface UserDao extends JpaRepository<Users,Long>,CustomizedUserRepository  {
	/*Users findUsersByUsername(String username);

	Page<Users> findByUsername(String username, Pageable pageable);
	Slice<Users> findByAddress(String address, Pageable pageable);
	List<Users> findByUsername(String username, Sort sort);
	List<Users> findByAge(Integer age, Pageable pageable);

	UserDto findByUsername(String username);
	UserOnlyUsername findTopByUsername(String username);*/

	/***
	 * query查询
	 */
//	@Query(value = "from Users where username=:username")
//	@Query(value = "select * from users where username = :username", nativeQuery = true)
//	Users findByUsername(@Param("username") String  username,Sort sort);
	@Query(value = "select * from users where username = :username order by :sort", nativeQuery = true)
	Users findByUsername(@Param("username") String  username,String sort);

	@Query(value = "select u from Users u where u.username like concat('%',?1,'%')")
	List<Users> findByUsernameLike(String username);

	//@Query(value = "select u.username,u.address,e.card from Users u ,UsersExtend e where u.userid = e.userid and u.username = :username" )
	//List<Object> findUsersByUsername(@Param("username")String username);


	//@Query(value = "select new com.zhu.jpa.pojo.UsersDto(u.username,u.address,e.card) from Users u ,UsersExtend e where u.userid = e.userid and u.username = :username")
	//List<UsersDto> findUsersByUsernameByUsersDto(@Param("username")String username);
	@Query(value = "select u.username as username,u.address as address,e.card as card from Users u ,UsersExtend e where u.userid = e.userid and u.username = :username")
	List<UsersDtoView> findUsersByUsernameByUsersDtoView(@Param("username")String username);
}
