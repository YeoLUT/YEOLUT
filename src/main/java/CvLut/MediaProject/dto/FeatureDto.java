package CvLut.MediaProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class FeatureDto {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class ParentFeature{
        @QueryProjection
        public ParentFeature(Long parentFeatureIdx, String parentFeatureName) {
            this.parentFeatureIdx = parentFeatureIdx;
            this.parentFeatureName = parentFeatureName;
        }
        private Long parentFeatureIdx;
        private String parentFeatureName;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class ChildFeature{
        @QueryProjection
        public ChildFeature(Long childFeatureIdx, String childFeatureName) {
            this.childFeatureIdx = childFeatureIdx;
            this.childFeatureName = childFeatureName;
        }

        private Long childFeatureIdx;
        private String childFeatureName;

    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class FeatureListRes {
        ParentFeature parentFeature;
        List<ChildFeature> childrenFeature;
        @QueryProjection
        public FeatureListRes(ParentFeature parentFeature, List<ChildFeature> childrenFeature){
            this.parentFeature = parentFeature;
            this.childrenFeature = childrenFeature;
        }
    }
    @Getter
    @Setter
    @NoArgsConstructor
    public static class DefaultFeature{
        @QueryProjection
        public DefaultFeature(Long featureIdx, String featureName) {
            this.featureIdx = featureIdx;
            this.featureName = featureName;
        }

        private Long featureIdx;
        private String featureName;

    }
}
