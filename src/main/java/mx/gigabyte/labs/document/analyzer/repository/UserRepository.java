package mx.gigabyte.labs.document.analyzer.repository;

import mx.gigabyte.labs.document.analyzer.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
