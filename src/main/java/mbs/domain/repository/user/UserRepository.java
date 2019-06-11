package mbs.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import mbs.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}