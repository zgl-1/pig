package com.zhu.shiro.dao;

import com.zhu.shiro.entity.Userrole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 朱桂林 create 2021/2/3 16:16
 */
public interface UserroleDao extends JpaRepository<Userrole,Integer> {
	@Query(value = "select r.name from Userrole ur ,Role r where ur.roleid = r.id and ur.userid=:userid")
	List<String> findByUserid(Integer userid);
}
