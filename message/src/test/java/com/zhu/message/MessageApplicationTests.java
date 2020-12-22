package com.zhu.message;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MessageApplicationTests {

	@Test
	void contextLoads() {
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
		request.putQueryParameter("PhoneNumbers", "15223795290");
		request.putQueryParameter("SignName", "大富大贵杂货店");
		request.putQueryParameter("TemplateCode", "SMS_205431604");

		//构建一个短信验证码
		Map map=new HashMap();
		map.put("code",1212);
		request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map));
		try {
			CommonResponse response = client.getCommonResponse(request);
			System.out.println(response.getData());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
