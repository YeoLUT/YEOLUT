package CvLut.MediaProject.controller;

import CvLut.MediaProject.common.response.ApiCallResponse;
import CvLut.MediaProject.common.response.BaseResponse;
import CvLut.MediaProject.dto.FeatureDto;
import CvLut.MediaProject.repository.feature.FeatureQueryRepository;
import CvLut.MediaProject.service.FeatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseFeatureList.class)))
    public ResponseEntity<BaseResponse<List<FeatureDto.FeatureListRes>>> getFeatureList(@RequestParam(value = "featureIdx", required = false) Long featureIdx){
        List<FeatureDto.FeatureListRes> featureListRes = featureService.getFeatureList(featureIdx);
        BaseResponse baseResponse = BaseResponse.builder().message("Success").result(featureListRes).build();

        return ResponseEntity.ok(baseResponse);
    }

    @Operation(summary = "럿 부모 속성 조회 API", description = "Gamma, Style, Color")
    @GetMapping("parentFeature")
    @ApiResponse(responseCode = "200", description = "조회 성공")
    public ResponseEntity<BaseResponse<List<FeatureDto.ParentFeature>>> getParentFeatureList(@RequestParam(value = "featureIdx", required = false) Long featureIdx){
        List<FeatureDto.ParentFeature> parentFeatures = featureService.getParentFeatureList(featureIdx);
        BaseResponse baseResponse = BaseResponse.builder().message("Success").result(parentFeatures).build();
        return ResponseEntity.ok(baseResponse);
    }
}
