package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.PictureProducerTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private PictureProducerTwo producer;

	//valid sources
	private final List<String> SOURCES = List.of("mobile", "web");

	//valid types
	private final List<String> TYPES = List.of("jpg", "png", "svg");

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			var p = new Picture();
			p.setName("Picture" + i);

			//random size
			p.setSize(ThreadLocalRandom.current().nextLong(1, 10000));

			//source and type from list
			p.setSource(SOURCES.get(i % SOURCES.size()));
			p.setType(TYPES.get(i % TYPES.size()));

			producer.sendMessage(p);
		}
	}
}
