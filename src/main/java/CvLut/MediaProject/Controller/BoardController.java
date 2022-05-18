package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Config.S3Upload;
import CvLut.MediaProject.Dto.ApiCallResponse;
import CvLut.MediaProject.Dto.BaseResponse;
import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Repository.Board.BoardQueryRepository;
import CvLut.MediaProject.Repository.Board.BoardRepository;
import CvLut.MediaProject.Service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
@Tag(name = "Board", description = "게시글 API")
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final BoardQueryRepository boardQueryRepository;
    private final S3Upload s3Upload;
   // private final BaseResponse baseResponse;
    @Operation(summary = "게시글 목록 조회", description = "메인 페이지 게시글 목록")
    @GetMapping("/list")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseBoardList.class)))
    public BaseResponse<Page<BoardDto.BoardListDto>> boardList(
            @PageableDefault(size = 12, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            @RequestParam(required = false) String search,
    @RequestParam(required = false) List<Long> featureIdxList){
        if (featureIdxList==null){
            featureIdxList = new ArrayList<>();
        }

        return BaseResponse.res(true, HttpStatus.OK, "Success", boardQueryRepository.BoardSearch(pageable, featureIdxList, search));
    }
    @Operation(summary = "게시글 상세 조회", description = "특정 게시글 조회")
    @GetMapping("/{boardIdx}")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseBoardDetail.class)))
    public BaseResponse<BoardDto.BoardDetailResDto> boardDetail(@PathVariable("boardIdx") Long boardIdx){
        return BaseResponse.res(true, HttpStatus.OK, "Success", boardService.boardDetail(boardIdx));
    }
    @Operation(summary = "s3 파일 업로드", description = "sort = 'originImage' or 'lutImage' or 'lutFile'")
    @PostMapping("/upload/file/{sort}") // 이미지 Url 반환
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseS3Upload.class)))
    public BaseResponse<BoardDto.S3UploadFileResDto> s3Upload(@PathVariable("sort") String sort, @RequestParam("file") MultipartFile multipartFile) throws IOException{
        // sort == lutFile or lutImage or originImage or profileImage
        String url = s3Upload.upload(multipartFile, sort);

        return BaseResponse.res(true, HttpStatus.OK,"Success", BoardDto.S3UploadFileResDto.url(url));
    }
    @Operation(summary = "게시글 업로드", description = "회원가입 미완료시 body에 userIdx 추가")
    @PostMapping("/upload")
    public BaseResponse boardUpload(@RequestBody BoardDto.UploadBoardReqDto uploadBoardReqDto){
        boardService.insertBoard(uploadBoardReqDto);
        return BaseResponse.res(true, HttpStatus.OK, "Success");
    }


}
