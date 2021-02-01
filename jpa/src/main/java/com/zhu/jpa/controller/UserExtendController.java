/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.jpa.controller;

import com.zhu.jpa.pojo.UsersExtend;
import com.zhu.jpa.service.UserExtendService;
import com.zhu.jpa.viewinterface.UsersDtoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 朱桂林 create 2021/1/25 14:39
 */
@RestController
public class UserExtendController {
	@Autowired
	private UserExtendService userExtendService;

	@RequestMapping("/findByCardAndAndWeight")
	public List<UsersExtend> findByCardAndAndWeight(String card,Double weight){
		return userExtendService.findByCardAndAndWeight(card,weight);
	}

	@RequestMapping("/findByCardAndWeight")
	public List<UsersExtend> findByCardAndWeight(String card,Double weight){
		return userExtendService.findByCardAndWeight(card,weight);
	}
}
