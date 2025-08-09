package com.course.rabbitmq.producer;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.RetryEmployeeJsonProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private RetryEmployeeJsonProducer producer;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			var emp = new Employee("Employee-" + i, null, LocalDate.now());

			producer.sendMessage(emp);
		}
	}
}
