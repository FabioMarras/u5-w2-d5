package fabiomarras.u5w2d5.repositories;

import fabiomarras.u5w2d5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
