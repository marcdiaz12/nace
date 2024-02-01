package com.db.nace.nace;

import org.springframework.boot.SpringApplication;

public class TestNaceApplication {

	public static void main(String[] args) {
		SpringApplication.from(NaceApplication::main).with(TestNaceApplication.class).run(args);
	}

}
