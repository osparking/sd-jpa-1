package space.bum.sboot.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import space.bum.sboot.repointer.MyUser;

interface AmbiguousRepository extends Repository<MyUser, Long> {
}

@NoRepositoryBean
interface MyBaseRepository<T, ID> extends CrudRepository<T, ID> {
}

interface AmbiguousUserRepository extends MyBaseRepository<MyUser, Long> {
}