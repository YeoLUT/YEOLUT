package CvLut.MediaProject.Dto;

import CvLut.MediaProject.Domain.Feature;

import java.util.ArrayList;

public class FeatureListDto {
    private Long featureIdx;
    private String featureName;
    private ArrayList<Feature> childList;
}
