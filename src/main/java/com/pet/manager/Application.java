package com.pet.manager;

import com.pet.manager.exception.DuplicatedPetException;
import com.pet.manager.model.Author;
import com.pet.manager.model.Pet;
import com.pet.manager.repository.AuthorRepository;
import com.pet.manager.repository.PetRepository;
import lombok.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

/*    @Bean
    public CommandLineRunner createMongoDbIndex(
            PetRepository repository,
            @Value("${spring.data.mongodb.uri}") String uri
    ) {
        return args -> {
            final Pet newpet = Pet.builder()
                    .type("DOG")
                    .name("Tommy")
                    .build();
            try {
                repository.insert(newpet);
            } catch (Exception exception) {
                throw  new DuplicatedPetException("Pet already exists");
            }
        };
    }*/
}
/*
* @Bean
public CommandLineRunner createMongoDbIndex() {
        return args -> {
//Create indexes
        };
        }*/
/*
-> Not unique index on type attribute which is not unique
-> Create A unique index on the Name field
-> CommandLineRunnerBean
-> Map the exception of having multiple names to a 409(CONFLICT statusCode)
/*
    try {
        insert
    } catch(IndexViolationException e){
        throw new DuplicatedPetException() -> Exception handler to 409
    }
 */


