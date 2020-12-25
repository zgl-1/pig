package com.zhu.springrabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRabbitmqApplicationTests {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void helloWorldProvider(){
        rabbitTemplate.convertAndSend("hello","hhh");
    }

    @Test
    void workProvider(){
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("work","这里是work模型"+i);
        }
    }

	@Test
	void fanoutProvider() {
		rabbitTemplate.convertAndSend("fanout", "", "这里是fanout模型");
	}

	@Test
	void routingProvider() {
		rabbitTemplate.convertAndSend("routing", "blue", "这里是routing模型");
	}

	@Test
	void topicProvider() {
		rabbitTemplate.convertAndSend("topic", "green.blue", "这里是topic模型");
	}
}
