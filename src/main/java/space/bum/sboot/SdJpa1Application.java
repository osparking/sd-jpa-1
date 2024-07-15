package space.bum.sboot;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import space.bum.sboot.hello.CountPersonRepository;
import space.bum.sboot.hello.Person;
import space.bum.sboot.hello.PersonRepository;

@SpringBootApplication
@Slf4j

public class SdJpa1Application {

  public static void main(String[] args) {
    SpringApplication.run(SdJpa1Application.class, args);
  }

  @Bean
  CommandLineRunner runner(PersonRepository repository,
      CountPersonRepository cpRepository) {
    return args -> {
      List<Person> deletedPerson = cpRepository.removeByName("전어");
      log.info("삭제 사람 수: {}", deletedPerson.size());
      
      log.info("삭제된 사람 정보 - ");
      deletedPerson.forEach(p -> log.info(p.toString()));
    };
  }
}
