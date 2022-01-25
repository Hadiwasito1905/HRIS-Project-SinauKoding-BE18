package projecthrissinauKodingBE18.projecthrisbe18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import projecthrissinauKodingBE18.projecthrisbe18.entity.User;

@SpringBootApplication
public class ProjectHrisBe18Application {

	public static void main(String[] args) {
		SpringApplication.run(ProjectHrisBe18Application.class, args);
	}

	public static User getCurrentUser() {
		try {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal != null && principal.getClass().equals(User.class)) {
				return (User) principal;
			}
		} catch (Exception ignore) {
		}
return null;
	}
}
