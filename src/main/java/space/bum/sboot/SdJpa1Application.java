package space.bum.sboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import space.bum.sboot.hello.CountPersonRepository;
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
      long delCount = cpRepository.deleteByName("전어");
      log.info("삭제 사람 수: {}", delCount);
      log.info("삭제 후 검색 결과: {}", repository.findById(1L).orElse(null));
    };
  }
}
