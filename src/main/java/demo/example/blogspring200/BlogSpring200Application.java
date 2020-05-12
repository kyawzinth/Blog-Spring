package demo.example.blogspring200;

import demo.example.blogspring200.model.Author;
import demo.example.blogspring200.model.Gender;
import demo.example.blogspring200.model.Post;
import demo.example.blogspring200.repository.AuthorRepository;
import demo.example.blogspring200.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@SpringBootApplication
public class BlogSpring200Application {

    private static Logger logger= LoggerFactory.getLogger(BlogSpring200Application.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogSpring200Application.class, args);

        System.out.println("Hello Git");
    }

    @Bean @Profile("dev")
    public CommandLineRunner runner(AuthorRepository authorRepository, PostRepository postRepository){

        return args -> {

            Author author1=new Author("Thaw Thaw", LocalDate.of(1999,3,21),"Horor", Gender.FEMALE);

            Post p1=new Post("the moment","falling in code",LocalDate.now());
            Post p2=new Post("one second","falling in music",LocalDate.now());
            Post p3=new Post("two second","falling in pubg",LocalDate.now());

            p1.setAuthor(author1);
            p2.setAuthor(author1);
            p3.setAuthor(author1);
            authorRepository.save(author1);
            postRepository.save(p1);
            postRepository.save(p2);
            postRepository.save(p3);

            logger.info("Successfully created");
        };
    }
}
