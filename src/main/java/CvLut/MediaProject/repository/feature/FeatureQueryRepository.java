package CvLut.MediaProject.repository.feature;

import CvLut.MediaProject.dto.FeatureDto;
import CvLut.MediaProject.dto.QFeatureDto_DefaultFeature;
import CvLut.MediaProject.dto.QFeatureDto_ParentFeature;
import CvLut.MediaProject.dto.QFeatureDto_ChildFeature;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static CvLut.MediaProject.domain.QFeature.feature;
import static CvLut.MediaProject.domain.QBoardFeature.boardFeature;
@Repository
@Getter
@RequiredArgsConstructor
public class FeatureQueryRepository {



    private final JPAQueryFactory queryFactory;
    public List<FeatureDto.ParentFeature> getParentsFeature(Long featureIdx){
        BooleanBuilder builder = new BooleanBuilder();
        if (featureIdx != null){
            builder.and(feature.featureIdx.eq(featureIdx));
        }
        else {
            builder.and(feature.parentIdx.isNull());
        }
        return queryFactory
                .select(new QFeatureDto_ParentFeature(feature.featureIdx, feature.featureName))
                .from(feature)
                .where(builder)
                .fetch();
    }

    public List<FeatureDto.ChildFeature> getChildrenFeature(Long parentIdx){
        return queryFactory
                .select(new QFeatureDto_ChildFeature(feature.featureIdx, feature.featureName))
                .from(feature)
                .where(feature.parentIdx.featureIdx.eq(parentIdx))
                .fetch();
    }


}
