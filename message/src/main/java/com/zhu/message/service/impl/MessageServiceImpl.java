/**
 * Copyright 2008-2009. Chongqing Communications Industry Services Co.,Ltd Information Technology Branch. All rights reserved.
 * <a>http://www.crunii.com</a>
 */
package com.zhu.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zhu.message.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 朱桂林 create 2020/11/7 17:07
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Override
	public boolean sendMessage(String phoneNumbers, String templateCode, Map<String, Object> code) {
		//连接阿里云
		DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4GABb7Zg9zmtKkNcwpv3", "T0ocBKpbZUrQX7s57nf6Vocplaw01D");
		IAcsClient client = new DefaultAcsClient(profile);

		//构建请求
		CommonRequest request = new CommonRequest();

		request.setSysMethod(MethodType.POST);
		request.setSysDomain("dysmsapi.aliyuncs.com");  //不能动
		request.setSysVersion("2017-05-25");  //不能动
		request.setSysAction("SendSms");

		//自定义参数（手机号，验证码，签名，模板）
		request.putQueryParameter("PhoneNumbers", phoneNumbers);
		request.putQueryParameter("SignName", "小朱JAVA学习网站");
		request.putQueryParameter("TemplateCode", templateCode);

//		构建一个短信验证码
//		Map map=new HashMap();
//		map.put("code",1212);
		request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
		try {
			CommonResponse response = client.getCommonResponse(request);
			return response.getHttpResponse().isSuccess();
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		return false;
	}
}
