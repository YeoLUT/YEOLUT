package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Domain.Feature;
import CvLut.MediaProject.Dto.FeatureDto;
import CvLut.MediaProject.Repository.FeatureQueryRepository;
import CvLut.MediaProject.Repository.FeatureRepositoy;
import CvLut.MediaProject.Service.FeatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feature")
@RequiredArgsConstructor
@Tag(name = "Feature", description = "속성 조회 API")
public class FeatureController {
    private final FeatureQueryRepository featureQueryRepository;
    private final FeatureService featureService;
    @Operation(summary = "럿 속성 조회 API", description = "Gamma, Style, Color에 해당하는 속성들은 children에 있다.")
    @GetMapping("list")
    public List<FeatureDto.FeatureListRes> getFeatureList(@RequestParam(value = "featureIdx", required = false) Long featureIdx){
        return featureService.getFeatureList(featureIdx);
    }
}
