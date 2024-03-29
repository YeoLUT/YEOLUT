package CvLut.MediaProject.common.response;

import CvLut.MediaProject.dto.BoardDto;
import CvLut.MediaProject.dto.FeatureDto;
import CvLut.MediaProject.dto.UserRecommendedListDto;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;

import java.util.List;

public class ApiCallResponse {
    @Schema public class ApiCallResponseBoardList extends BaseResponse<Page<BoardDto.BoardListDto>> {}
    @Schema public class ApiCallResponseBoardDetail extends BaseResponse<BoardDto.BoardDetailResDto>{}
    @Schema public class ApiCallResponseS3Upload extends BaseResponse<BoardDto.S3UploadFileResDto>{}
    @Schema public class ApiCallResponseFeatureList extends BaseResponse<List<FeatureDto.FeatureListRes>>{}
    @Schema public class ApiCallResponseUserRecommendList extends  BaseResponse<Page<UserRecommendedListDto[]>>{}
    @Schema public class ApiCallResponseUserBoardList extends BaseResponse<List<BoardDto.UserBoardList>>{}

}
