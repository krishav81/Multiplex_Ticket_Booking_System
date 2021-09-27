package com.Multiplex;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class MultiplexApplication {
	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(MultiplexApplication.class, args);
	}
}
