package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Furniture;
import com.course.rabbitmq.producer.producer.FurnitureProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private FurnitureProducer producer;

	private final List<String> COLORS = List.of("white", "red", "green");

	private final List<String> MATERIALS = List.of("wood", "plastic", "steel");

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			var furniture = new Furniture();
			furniture.setName("Furniture " + i);
			furniture.setColor(COLORS.get(i % COLORS.size()));
			furniture.setMaterial(MATERIALS.get(i % MATERIALS.size()));
			furniture.setPrice(i);

			producer.sendMessage(furniture);
		}

	}
}
