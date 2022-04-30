package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Domain.Feature;
import CvLut.MediaProject.Repository.FeatureRepositoy;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feature")
@RequiredArgsConstructor
@Tag(name = "Feature", description = "속성 조회 API")
public class FeatureController {
    private final FeatureRepositoy featureRepositoy;
    @Operation(summary = "럿 속성 조회 API", description = "Gamma, Style, Color에 해당하는 속성들은 children에 있다.")
    @GetMapping("list")
    public List<Feature> getList(){
        return featureRepositoy.findByParentIdxNull();
    }
}
