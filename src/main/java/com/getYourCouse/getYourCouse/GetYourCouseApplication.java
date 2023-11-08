package com.getYourCouse.getYourCouse;

import com.getYourCouse.getYourCouse.sec.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class GetYourCouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetYourCouseApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(AccountService accountService) {
		return args -> {
			accountService.addNewUser("user1","1234","user1@gamil.com","1234");
			accountService.addNewUser("admin","1234","admin@gamil.com","1234");
			accountService.addNewRole("user");
			accountService.addNewRole("admin");
			accountService.addRoleToUser("user1","user");
			accountService.addRoleToUser("admin","user");
			accountService.addRoleToUser("admin","admin");

		};
	}*/
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
