package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.LutImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LutImageRepository extends JpaRepository<LutImage, Long> {
}
