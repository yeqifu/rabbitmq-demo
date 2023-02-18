package com.yeqifu.mq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author: yeqifu
 * @date: 2023/2/18 10:14
 */
@Component
public class SpringRabbitListener {
    /*@RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String message) {
        System.out.println("spring 消费之接收到消息：【" + message + "】");
    }*/

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMessage1(String message) throws InterruptedException {
        System.out.println("spring 消费者1接收到消息：【" + message + "】" + LocalDateTime.now());
        // 处理一条消息睡20毫秒，处理50条消息，刚好花费1000毫秒也就是1秒
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueueMessage2(String message) throws InterruptedException {
        System.err.println("spring 消费者2接收到消息：【" + message + "】" + LocalDateTime.now());
        // 处理一条消息睡100毫秒，处理10条消息，刚好花费1000毫秒也就是1秒
        Thread.sleep(100);
    }

    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueueMessage1(String message) {
        System.out.println("spring 消费者1接收到Fanout消息：【" + message + "】" + LocalDateTime.now());
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueueMessage2(String message) {
        System.out.println("spring 消费者2接收到Fanout消息：【" + message + "】" + LocalDateTime.now());
    }
}
