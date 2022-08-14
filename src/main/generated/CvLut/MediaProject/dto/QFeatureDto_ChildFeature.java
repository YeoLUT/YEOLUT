package CvLut.MediaProject.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.dto.QFeatureDto_ChildFeature is a Querydsl Projection type for ChildFeature
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFeatureDto_ChildFeature extends ConstructorExpression<FeatureDto.ChildFeature> {

    private static final long serialVersionUID = 893484269L;

    public QFeatureDto_ChildFeature(com.querydsl.core.types.Expression<Long> childFeatureIdx, com.querydsl.core.types.Expression<String> childFeatureName) {
        super(FeatureDto.ChildFeature.class, new Class<?>[]{long.class, String.class}, childFeatureIdx, childFeatureName);
    }

}

