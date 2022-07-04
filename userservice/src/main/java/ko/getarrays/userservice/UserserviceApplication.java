package ko.getarrays.userservice;

import ko.getarrays.userservice.Service.UserService;
import ko.getarrays.userservice.domain.Role;
import ko.getarrays.userservice.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "John Travolta", "john", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>()));

			userService.adddRoleToUser("john", "ROLE_USER");
			userService.adddRoleToUser("john", "ROLE_MANAGER");
			userService.adddRoleToUser("will", "ROLE_MANAGER");
			userService.adddRoleToUser("jim", "ROLE_ADMIN");
			userService.adddRoleToUser("arnold", "ROLE_SUPER_ADMIN");
			userService.adddRoleToUser("arnold", "ROLE_ADMIN");
			userService.adddRoleToUser("arnold", "ROLE_USER");
		};
	}
}
