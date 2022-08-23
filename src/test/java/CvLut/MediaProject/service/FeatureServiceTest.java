package CvLut.MediaProject.service;

import static org.mockito.Mockito.*;

import CvLut.MediaProject.dto.FeatureDto;
import CvLut.MediaProject.repository.feature.FeatureQueryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FeatureServiceTest {
    @InjectMocks
    private FeatureService featureService;

    @Mock
    private FeatureQueryRepository featureQueryRepository;
    @Test
    @DisplayName("특성 조회")
    void testGetFeatureList(){
        // given
        Long testFeatureIdx = 1L;
        List<FeatureDto.ParentFeature> testParentFeature = new ArrayList<FeatureDto.ParentFeature>();
        when(featureQueryRepository.getParentsFeature(testFeatureIdx)).thenReturn(testParentFeature);
        for (int i = 1; i < 6; i++) {
            List<FeatureDto.ChildFeature> testChildFeature = new ArrayList<FeatureDto.ChildFeature>();
            int parentIdx = i;
            testParentFeature.add(new FeatureDto.ParentFeature(Long.valueOf(parentIdx) ,parentIdx + "번째 특성"));
            for (int j = 1; j < 4; j++) {
                int childIndex = i*j;
                testChildFeature.add(new FeatureDto.ChildFeature(Long.valueOf(childIndex), childIndex + "번째 인덱스"));
                //System.out.println("parent  " + parentIdx + " child " + childIndex);
            }
            when(featureQueryRepository.getChildrenFeature(Long.valueOf(parentIdx))).thenReturn(testChildFeature);
        }

        // when
        List<FeatureDto.FeatureListRes> testFeatureList = featureService.getFeatureList(testFeatureIdx);
        Assertions.assertThat(testParentFeature.get(0).getParentFeatureName()).isEqualTo(testFeatureList.get(0).getParentFeature().getParentFeatureName());
        Assertions.assertThat(testFeatureList.get(0).getChildrenFeature().size()).isEqualTo(3);
        //testFeatureList.stream().forEach(s-> System.out.println("s = " + s.getParentFeature().getParentFeatureName() + " c = " + s.getChildrenFeature().get(1).getChildFeatureName()));
    }
}