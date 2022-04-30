package CvLut.MediaProject.Service;

import CvLut.MediaProject.Domain.Feature;
import CvLut.MediaProject.Dto.FeatureListDto;
import CvLut.MediaProject.Repository.FeatureRepositoy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FeatureService {
    private final FeatureRepositoy featureRepositoy;
//    public ArrayList<FeatureListDto> featureListDto(){
//        List<Feature> featureList =  featureRepositoy.findByParentIdxNull();
//        List<Long> parentIdxList = featureList.ma
//        for(int i=0;i<featureList.size();i++){
//            List<Feature> childList = featureRepositoy.findByParentIdxIs(featureList.stream().m);
//        }
//
//    }
}
