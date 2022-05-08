package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.BoardFeature;
import CvLut.MediaProject.Dto.BoardDetailResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardFeatureRepository extends JpaRepository<BoardFeature, Long> {
//    @Query(value = "SELECT f.feature_idx as featureIdx, parent_idx as parentIdx, feature_name as featureName" +
//            "FROM BoardFeature bf" +
//            "LEFT JOIN Feature f on f.feature_idx  = bf.feature_idx" +
//            "WHERE board_idx =: board_idx", nativeQuery = true)
//    BoardFeature[] boardFeatureList(@Param("board_idx") Long boardIdx);

    @Query(value = "" +
            "SELECT f.feature_idx as featureIdx, feature_name as featureName " +
            "FROM board_feature bf " +
            "LEFT JOIN feature f on f.feature_idx = bf.feature_idx " +
            "WHERE board_idx = :boardIdx ",nativeQuery = true)
    List<BoardDetailResponseDto.FeatureDto> findFeatureInfoByBoard(@Param("boardIdx") Long boardIdx);
}
