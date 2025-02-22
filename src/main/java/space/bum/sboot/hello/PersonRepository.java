package space.bum.sboot.hello;

import java.util.Optional;

import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, Long> {
  Person save(Person person);

  Optional<Person> findById(long id);
}