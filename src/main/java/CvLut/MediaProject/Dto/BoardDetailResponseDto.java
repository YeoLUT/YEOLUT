package CvLut.MediaProject.Dto;

import lombok.Setter;

import java.util.List;

@Setter
public class BoardDetailResponseDto {

    private List <FeatureDto> features;





    public static interface FeatureDto {
        Long getFeatureIdx();
        String getFeatureName();
    }
}
