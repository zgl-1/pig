package com.zhu.thread;

import com.zhu.thread.service.ThreadService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadApplicationTests {

	@Autowired
	private ThreadService threadService;

	@Test
	void contextLoads() {
		threadService.test();
	}

}
