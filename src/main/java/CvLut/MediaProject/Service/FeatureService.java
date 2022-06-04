package CvLut.MediaProject.Service;

import CvLut.MediaProject.Repository.FeatureQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import CvLut.MediaProject.Dto.FeatureDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeatureService {

    private final FeatureQueryRepository featureQueryRepository;

    public List<FeatureDto.FeatureListRes> getFeatureList(Long featureIdx){
        List<FeatureDto.FeatureListRes> featureListResList = new ArrayList<>();
        List<FeatureDto.ParentFeature> parentFeatureList = featureQueryRepository.getParentsFeature(featureIdx);
        for(FeatureDto.ParentFeature parentFeature : parentFeatureList){
            List<FeatureDto.ChildFeature> childFeatureList = featureQueryRepository.getChildrenFeature(parentFeature.getParentFeatureIdx());
            featureListResList.add(new FeatureDto.FeatureListRes(parentFeature, childFeatureList));
        }
        return featureListResList;
    }
}
