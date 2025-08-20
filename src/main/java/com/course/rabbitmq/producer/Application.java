package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.SpringPictureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private SpringPictureProducer producer;

	@Override
	public void run(String... args) throws Exception {
		var p = new Picture();
		p.setName("Spring picture");
		p.setSize(9500);
		p.setSource("web");
		p.setType("jpg");

		producer.sendMessage(p);
	}
}
