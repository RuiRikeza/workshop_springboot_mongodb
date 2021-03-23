package com.ruimagalhaes.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruimagalhaes.workshopmongo.domain.Post;
import com.ruimagalhaes.workshopmongo.domain.User;
import com.ruimagalhaes.workshopmongo.repository.PostRepository;
import com.ruimagalhaes.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		Post post1 = new Post(null, sdf.parse("2018/03/2018"),  "Partiu viagem",  "Vou viajar para São Paulo. Abraços!", alex );
		Post post2 = new Post(null, sdf.parse("2018/03/2020"),  "Nova viagem",  "Vou viajar para Berlim. Abraços!", alex );

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
