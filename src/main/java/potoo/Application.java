package potoo;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import potoo.dao.repositories.UserRepository;
import potoo.dao.repositories.WowRepository;
import potoo.domain.User;
import potoo.domain.Wow;

@SpringBootApplication
@EnableWebMvc
public class Application implements CommandLineRunner {

	@Autowired UserRepository userRepository;
	
	@Autowired
	WowRepository wowRepository;

	public void run(String... args) throws Exception {
//		prepareDb();

	}

	private void prepareDb() {
		Wow firstWow = new Wow();
		firstWow.setWow("This is the first wow.");
		User andy = new User("Andy");
		firstWow.wowedBy(andy, new Date());
		
		Wow secondWow = new Wow();
		secondWow.setWow("This is the second wow.");
		User bob = new User("Bob");
		secondWow.wowedBy(bob, new Date());
		secondWow.reWows(firstWow);
		
		Wow thirdWow = new Wow();
		thirdWow.setWow("The third wow");
		User craig = new User("Craig");
		thirdWow.wowedBy(craig, new Date());
		thirdWow.reWows(secondWow);
		
		wowRepository.save(Arrays.asList(firstWow, secondWow, thirdWow));
		userRepository.save(Arrays.asList(andy, bob, craig));		
		
	}

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Application.class, args);
	}
}
