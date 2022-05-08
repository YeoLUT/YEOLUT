package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.Feature;
import CvLut.MediaProject.Dto.FeatureDto;
import CvLut.MediaProject.Dto.QFeatureDto_DefaultFeature;
import CvLut.MediaProject.Dto.QFeatureDto_ParentFeature;
import CvLut.MediaProject.Dto.QFeatureDto_ChildFeature;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static CvLut.MediaProject.Domain.QFeature.feature;
import static CvLut.MediaProject.Domain.QBoardFeature.boardFeature;
@RequiredArgsConstructor
@Repository
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

    public List<FeatureDto.DefaultFeature> getBoardFeatureList(Long boardIdx){
        return queryFactory
                .select(new QFeatureDto_DefaultFeature(feature.featureIdx, feature.featureName))
                .from(boardFeature)
                .leftJoin(boardFeature.feature, feature).on(boardFeature.board.boardIdx.eq(boardIdx))
                .fetch();
    }
}
