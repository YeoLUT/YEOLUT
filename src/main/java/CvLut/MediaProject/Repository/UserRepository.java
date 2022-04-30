package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
