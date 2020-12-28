package com.example.auth;

import com.example.auth.models.MyRole;
import com.example.auth.models.MyUser;
import com.example.auth.services.AccountServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AuthApplication implements CommandLineRunner {

	@Autowired
	AccountServicesImp accountServicesImp;
	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@GetMapping("/test")
	public String test(){
		return "hicha benhachem m";
	}


	@Override
	public void run(String... args) throws Exception {
		accountServicesImp.createUser(new MyUser(null,"hicham benhachem","admin","admin",null,null));
		accountServicesImp.createUser(new MyUser(null,"yassine benhachem","admin1","admin1",null,null));
		accountServicesImp.createUser(new MyUser(null,"driss benhachem","user","user",null,null));

		accountServicesImp.createRole(new MyRole(null,"Admin"));
		accountServicesImp.createRole(new MyRole(null,"User"));

		accountServicesImp.addRoleToUser("Admin","admin");
		accountServicesImp.addRoleToUser("Admin","admin1");
		accountServicesImp.addRoleToUser("User","user");

		accountServicesImp.getUser().forEach((u)->{
			System.out.println(u.toString());
		});
	}
}
