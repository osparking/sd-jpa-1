package space.bum.sboot.hello;

import org.springframework.data.repository.CrudRepository;

public interface CountPersonRepository extends CrudRepository<Person, Long>{
  long countByName(String name);
}
