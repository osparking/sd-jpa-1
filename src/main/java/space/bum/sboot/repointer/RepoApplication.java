package space.bum.sboot.repointer;

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
  CommandLineRunner runner(MyRepository myRepository) {
    return args -> {
      MyUser user = new MyUser(100L, "홍기");
      
      MyUser honGee= myRepository.save(user);
      log.info("저장된 사용자: {}", honGee.toString());
    };
  }
}
