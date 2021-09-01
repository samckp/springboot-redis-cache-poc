package info.redis.cache;

import info.redis.cache.dao.User;
import info.redis.cache.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired
	private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		this.userRepository.save(new User(1,"Raj", "Kumar", "raj@gmail.com"));
		this.userRepository.save(new User(2,"Peter", "Dao", "dao@gmail.com"));
		this.userRepository.save(new User(3,"anil", "Sagar", "anil@gmail.com"));
	}
}
