package CvLut.MediaProject.dto;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.Dto.QFeatureDto_DefaultFeature is a Querydsl Projection type for DefaultFeature
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QFeatureDto_DefaultFeature extends ConstructorExpression<FeatureDto.DefaultFeature> {

    private static final long serialVersionUID = -58292408L;

    public QFeatureDto_DefaultFeature(com.querydsl.core.types.Expression<Long> featureIdx, com.querydsl.core.types.Expression<String> featureName) {
        super(FeatureDto.DefaultFeature.class, new Class<?>[]{long.class, String.class}, featureIdx, featureName);
    }

}

