package com.emsi.anas;

import com.emsi.anas.entities.AppRole;
import com.emsi.anas.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class AnasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnasApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

    /*
    @Bean
    CommandLineRunner start(AccountService accountService){
        return args->{
            accountService.save( new AppRole(1,"USER"));
            accountService.save( new AppRole(2,"ADMIN"));
            accountService.save( new AppRole(3,"RESPONSABLE"));
            //mesureService.savemesure();
            //mesureService.savemesure(new Mesure("Temperature","nombre"));
            Stream.of("user1","user2","user3","admin").forEach(un -> {
                accountService.saveUser(un ,"1234","1234");
            });
            accountService.addRoleToUser("admin","ADMIN");
        };
    }*/

}
