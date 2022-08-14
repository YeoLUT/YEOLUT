package CvLut.MediaProject.repository.user;

import CvLut.MediaProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
    boolean existsUserByEmailAndStatus(@Param("email") String email, @Param("status") char status);
}
