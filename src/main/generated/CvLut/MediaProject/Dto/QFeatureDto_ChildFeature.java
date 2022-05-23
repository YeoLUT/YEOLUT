package CvLut.MediaProject.Dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.Dto.QFeatureDto_ChildFeature is a Querydsl Projection type for ChildFeature
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFeatureDto_ChildFeature extends ConstructorExpression<FeatureDto.ChildFeature> {

    private static final long serialVersionUID = 186606797L;

    public QFeatureDto_ChildFeature(com.querydsl.core.types.Expression<Long> childFeatureIdx, com.querydsl.core.types.Expression<String> childFeatureName) {
        super(FeatureDto.ChildFeature.class, new Class<?>[]{long.class, String.class}, childFeatureIdx, childFeatureName);
    }

}

