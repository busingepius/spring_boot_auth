package org.example.lab2;

import org.example.lab2.entity.Comment;
import org.example.lab2.entity.Post;
import org.example.lab2.entity.Role;
import org.example.lab2.entity.User;
import org.example.lab2.repo.PostRepo;
import org.example.lab2.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Transactional
public class Lab2Application implements CommandLineRunner {
	/*@Autowired
	private PostRepo postRepo;*/

	@Autowired
	private UserRepo userRepo;
	public static void main(String[] args) {
		SpringApplication.run(Lab2Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		Comment comment1 = new Comment("Nice 1");
		Comment comment2 = new Comment("Nice 2");
		Comment comment3 = new Comment("Nice 3");
		Comment comment4 = new Comment("Nice 4");
		Comment comment5 = new Comment("Nice 5");


		Post post1 = new Post("Book 1", "Content of Book 1", "Author 1");
		Post post2 = new Post("Book 2", "Content of Book 2", "Author 2");
		Post post3 = new Post("Book 3", "Content of Book 3", "Author 3");
		Post post4 = new Post("Book 4", "Content of Book 4", "Author 4");
		Post post5 = new Post( "Book 4", "Content of Book 5", "Author 5");


		User user1 = new User("User 1","testing1@gmail.com" , "$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2");
		User user2 = new User("User 2", "testing2@gmail.com" , "$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2");
		User user3 = new User("User 3", "testing3@gmail.com" , "$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2");
		Role role1 = new Role("ADMIN");
		Role role2 = new Role("CLIENT");

		user1.addRole(role1);
		user2.addRole(role1);
		user3.addRole(role2);


		post1.addComment(comment1);
		post1.addComment(comment2);
		post2.addComment(comment3);
		post2.addComment(comment4);
		post1.addComment(comment5);

		user2.addPost(post1);
		user2.addPost(post3);
		user1.addPost(post2);
		user1.addPost(post4);
		user1.addPost(post5);

		userRepo.save(user1);
		userRepo.save(user2);
		userRepo.save(user3);

		/*System.out.println(userRepo.usersWithMoreThanPosts(3));
		System.out.println(userRepo.usersWithMoreThanPosts(2));

		System.out.println(postRepo.findPostsByTitle("Book 4"));
		System.out.println(postRepo.findPostsByTitle("Book 3"));

		System.out.println(userRepo.usersThatMadePostWith("Book 4"));
*/

	}
}
