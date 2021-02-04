package com.zhu.shiro;

import com.zhu.shiro.util.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShiroApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(ShiroApplication.class, args);
		Utils.setApplicationContext(run);
	}

}
