package space.bum.sboot.repointer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

interface MyRepository extends JpaRepository<MyUser, Long> {
}

@NoRepositoryBean
interface MyBaseRepository<T, ID> extends JpaRepository<T, ID> {
}

interface UserRepository extends MyBaseRepository<MyUser, Long> {
}