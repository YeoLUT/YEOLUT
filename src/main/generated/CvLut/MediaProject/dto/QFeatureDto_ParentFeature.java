package CvLut.MediaProject.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.dto.QFeatureDto_ParentFeature is a Querydsl Projection type for ParentFeature
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFeatureDto_ParentFeature extends ConstructorExpression<FeatureDto.ParentFeature> {

    private static final long serialVersionUID = -87386471L;

    public QFeatureDto_ParentFeature(com.querydsl.core.types.Expression<Long> parentFeatureIdx, com.querydsl.core.types.Expression<String> parentFeatureName) {
        super(FeatureDto.ParentFeature.class, new Class<?>[]{long.class, String.class}, parentFeatureIdx, parentFeatureName);
    }

}

