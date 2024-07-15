package space.bum.sboot;

import java.util.NoSuchElementException;

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

      Person person = new Person();
      person.setName("전어");

      repository.save(person);
      Person saved = repository.findById(person.getId())
          .orElseThrow(NoSuchElementException::new);
      log.info("DB에서 읽은 사람 이름: {}", saved.getName());
      
      long personCount = cpRepository.countByName("전어");
      log.info("등록 사람 수: {}", personCount);
    };
  }
}
