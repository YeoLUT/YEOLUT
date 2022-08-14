package CvLut.MediaProject.dto;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.Dto.QFeatureDto_FeatureListRes is a Querydsl Projection type for FeatureListRes
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFeatureDto_FeatureListRes extends ConstructorExpression<FeatureDto.FeatureListRes> {

    private static final long serialVersionUID = 1331823903L;

    public QFeatureDto_FeatureListRes(com.querydsl.core.types.Expression<? extends FeatureDto.ParentFeature> parentFeature, com.querydsl.core.types.Expression<? extends java.util.List<FeatureDto.ChildFeature>> childrenFeature) {
        super(FeatureDto.FeatureListRes.class, new Class<?>[]{FeatureDto.ParentFeature.class, java.util.List.class}, parentFeature, childrenFeature);
    }

}

