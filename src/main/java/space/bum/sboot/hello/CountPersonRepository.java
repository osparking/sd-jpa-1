package space.bum.sboot.hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.transaction.Transactional;

public interface CountPersonRepository extends CrudRepository<Person, Long>{
  long countByName(String name);
  
  @Transactional
  long deleteByName(String name);

  @Transactional
  List<Person> removeByName(String name);
}
