package com.bookstore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookstore.config.SecurityUtility;
import com.bookstore.domain.Album;
import com.bookstore.domain.User;
import com.bookstore.domain.security.*;
import com.bookstore.service.AlbumService;
import com.bookstore.service.UserService;

@SpringBootApplication
public class BookstoreDosApplication implements CommandLineRunner{

	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreDosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		User user2 = new User();
		user2.setFirstName("Arturo");
		user2.setLastName("Latorre");
		user2.setUsername("admin");
		user2.setPassword(SecurityUtility.passwordEncoder().encode("admin"));
		user2.setEmail("arturola@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role2 = new Role();
		role2.setRoleId(0);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(user2, role2));
		
		userService.createUser(user2, userRoles);
		
//		Album nirvanasNevermind = new Album();
//		nirvanasNevermind.setAlbumId(0);
//		nirvanasNevermind.setArtist("Nirvana");
//		nirvanasNevermind.setName("Nevermind");
//		nirvanasNevermind.setCompany("Geffen");
//		nirvanasNevermind.setYear("1991");
//		
//		
//		albumService.createAlbum(nirvanasNevermind);
		
		
	}

}
