package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.NamedQuery;
import java.util.List;

public interface FeatureRepositoy extends JpaRepository<Feature, Long> {
    List<Feature> findByParentIdxNull();
    List<Feature> findByParentIdxIs(@Param("parentIdx")Long parentIdx);

}
