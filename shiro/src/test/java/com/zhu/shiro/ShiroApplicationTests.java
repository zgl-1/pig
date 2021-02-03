package com.zhu.shiro;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

	@Test
	void contextLoads() {
		/*Md5Hash md5Hash = new Md5Hash("123","salt",100);
		System.out.println(md5Hash.toHex());*/
	}

}
