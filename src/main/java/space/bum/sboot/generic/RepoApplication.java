package space.bum.sboot.generic;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j

public class RepoApplication {

  public static void main(String[] args) {
    SpringApplication.run(RepoApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(AmbiguousUserRepository userRepository) {
    return args -> {
      MyUser user = new MyUser(100L, "홍기");
      
//      var honGee = userRepository.save() // error
//      log.info("저장된 사용자: {}", honGee.toString());
    };
  }
}
