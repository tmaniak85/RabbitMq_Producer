package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.producer.HelloRabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private HelloRabbitProducer helloRabbitProducer;

	@Override
	public void run(String... args) throws Exception {
		helloRabbitProducer.sendHello("MyName " + ThreadLocalRandom.current().nextInt());
	}
}
