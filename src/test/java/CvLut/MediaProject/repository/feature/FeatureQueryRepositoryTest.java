package CvLut.MediaProject.repository.feature;

import CvLut.MediaProject.QueryDslTestConfig;
import CvLut.MediaProject.domain.Board;
import CvLut.MediaProject.domain.BoardFeature;
import CvLut.MediaProject.domain.Feature;
import CvLut.MediaProject.dto.FeatureDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Import(QueryDslTestConfig.class)
class FeatureQueryRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    JPAQueryFactory jpaQueryFactory;
    // 의존성 주입받은 변수를 생성자 파라미터에 넣으면 생성자 호출이 안된다.
    // 호출시점의 문제인듯 하다
    FeatureQueryRepository featureQueryRepository;
    int childrenCount = 0;

    @BeforeEach
    void setUp(){
        featureQueryRepository = new FeatureQueryRepository(jpaQueryFactory);
       System.out.println("test3" + jpaQueryFactory  + "  "+  featureQueryRepository.getQueryFactory());
        Feature parentFeatureA = testEntityManager.persist(Feature.builder().featureName("A").build());
        Feature parentFeatureB = testEntityManager.persist(Feature.builder().featureName("B").build());

        for (int i = 0; i < childrenCount; i++) {
            testEntityManager.persist(Feature.builder().featureName("A의 자식"+ String.valueOf(i)).parentIdx(parentFeatureA).build());
        }

        for (int i = 0; i < childrenCount; i++) {
            testEntityManager.persist(Feature.builder().featureName("B의 자식"+ String.valueOf(i)).parentIdx(parentFeatureB).build());
        }
    }
    @Test
    @DisplayName("부모 특성 조회")
    void testGetParentsFeature(){
        // given
        Long featureIdx = null;

        // when
        List<FeatureDto.ParentFeature> parentFeatures = featureQueryRepository.getParentsFeature(featureIdx);

        // then
        Assertions.assertThat(parentFeatures.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("자식 특성 조회")
    void testGetChildrenFeature(){
        // given
        Long parentA = 1L;
        Long parentB = 2L;

        // when
        List<FeatureDto.ChildFeature> childrenA = featureQueryRepository.getChildrenFeature(parentA);
        List<FeatureDto.ChildFeature> childrenB = featureQueryRepository.getChildrenFeature(parentB);

        // then
        for (int i = 0; i < childrenCount; i++) {
            Assertions.assertThat(childrenA.get(i).getChildFeatureName()).isEqualTo("A의 자식" + i);
            Assertions.assertThat(childrenB.get(i).getChildFeatureName()).isEqualTo("B의 자식" + i);
        }
    }

//    @Test
//    @DisplayName("게시글과 맵핑된 특성 조회")
//    void testGetBoardFeatures(){
//        // given
//        Board board = Board.builder().title("테스트입니다.").build();
//        BoardFeature boardFeature = BoardFeature.builder().board(board)
//
//    }
}