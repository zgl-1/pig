/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.shiro.dao;

import com.zhu.shiro.entity.Role;
import com.zhu.shiro.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 朱桂林 create 2021/2/3 16:15
 */
public interface RoleDao extends JpaRepository<Role,Integer> {
}
