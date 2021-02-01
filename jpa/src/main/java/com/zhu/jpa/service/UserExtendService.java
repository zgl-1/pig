/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.service;

import com.zhu.jpa.dao.UsersExtendDao;
import com.zhu.jpa.pojo.UsersExtend;
import com.zhu.jpa.viewinterface.UsersDtoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 朱桂林 create 2021/1/25 14:37
 */
@Service
public class UserExtendService {
	@Autowired
	private UsersExtendDao usersExtendDao;

	public List<UsersExtend> findByCardAndAndWeight(String card, Double weight){
		return usersExtendDao.findByCardAndAndWeight(card,weight);
	}

	public List<UsersExtend> findByCardAndWeight(String card, Double weight){
		return usersExtendDao.findByCardAndWeight(card,weight);
	}
}
