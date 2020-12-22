/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.message.controller;

import com.zhu.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 朱桂林 create 2020/11/7 17:11
 */
@RestController
public class SendMessageController {
	@Autowired
	private MessageService messageService;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@GetMapping("/sendMessage/{phoneNumbers}")
	public String sendMessage(@PathVariable("phoneNumbers") String phoneNumbers) {
		//判断手机号验证码是否过期
		String code = redisTemplate.opsForValue().get(phoneNumbers);
		if (!StringUtils.isEmpty(code)) {
			return phoneNumbers + ":" + code + "已存在，还没有过期";
		}

		//生成验证码
		code = UUID.randomUUID().toString().substring(0, 4);
		Map<String, Object> map = new HashMap();
		map.put("code", code);

		boolean isSend = messageService.sendMessage(phoneNumbers, "SMS_205431604", map);
		if (isSend) {
			redisTemplate.opsForValue().set(phoneNumbers, code, 5, TimeUnit.MINUTES);
			return phoneNumbers + ":" + code + "发送成功";
		} else {
			return phoneNumbers + ":" + code + "发送失败";
		}
	}

	@GetMapping("/getMessage/{phoneNumbers}")
	public String getMessage(@PathVariable("phoneNumbers") String phoneNumbers) {
		//判断手机号验证码是否过期

		String code="1555";
		redisTemplate.opsForValue().set(phoneNumbers, code, 1L, TimeUnit.MINUTES);

		return null;
	}
}
