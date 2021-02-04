package com.zhu.shiro.dao;

import com.zhu.shiro.entity.Role;
import com.zhu.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 朱桂林 create 2021/2/3 16:15
 */
public interface RoleDao extends JpaRepository<Role,Integer> {
}
