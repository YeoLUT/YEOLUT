package CvLut.MediaProject.controller;

//import CvLut.MediaProject.Config.JwtTokenProvider;
import CvLut.MediaProject.common.response.ApiCallResponse;
import CvLut.MediaProject.common.response.BaseResponse;
import CvLut.MediaProject.domain.User;
import CvLut.MediaProject.repository.board.BoardRepository;
import CvLut.MediaProject.repository.user.UserRepository;
import CvLut.MediaProject.service.UserService;
import CvLut.MediaProject.dto.BoardDto;
import CvLut.MediaProject.dto.UserDto;
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
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 API")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final BoardRepository boardRepository;
//    private final JwtTokenProvider jwtTokenProvider;
//    @PostMapping()
//    public ResponseEntity<User> saveUser(@Validated @RequestBody User user){
//        User savedUser = userRepository.save(user);
//        return ResponseEntity.ok(savedUser);
//    }

    @Operation(summary = "추천 작가 조회 API", description = "유저, 게시글 관련 데이터")
    @GetMapping("/recommend")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseUserRecommendList.class)))
    public ResponseEntity<BaseResponse<Page<UserDto.UserRecommendedListDto>>> recommendedUserList(@PageableDefault(size = 12, sort = "createdAt", direction = Sort.Direction.DESC)Pageable pageable){
        BaseResponse baseResponse = BaseResponse.builder().message("Success").result(userRepository.recommendedUserList(pageable)).build();
        return ResponseEntity.ok(baseResponse);
    }

    @Operation(summary = "유저 작성 게시글 목록", description = "")
    @GetMapping("{userIdx}/boards")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseUserBoardList.class)))
    public ResponseEntity<BaseResponse<List<BoardDto.UserBoardList>>> userBoardList(@PathVariable Long userIdx){
        BaseResponse baseResponse = BaseResponse.builder().message("Success").result(boardRepository.userBoardList(userIdx)).build();
        return ResponseEntity.ok(baseResponse);
    }

    @Operation(summary = "유저 좋아요 게시글 목록", description = "")
    @GetMapping("{userIdx}/likes")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseUserBoardList.class)))
    public ResponseEntity<BaseResponse<List<BoardDto.UserBoardList>>> userLikeList(@PathVariable Long userIdx){
        BaseResponse baseResponse = BaseResponse.builder().message("Success").result(boardRepository.userLikeList(userIdx)).build();
        return ResponseEntity.ok(baseResponse);
    }

    @Operation(summary = "회원 가입")
    @PostMapping("/signUp")
    public ResponseEntity<BaseResponse> userSignUp(@RequestBody UserDto.UserSignUpReqDto userSignUpReqDto){
        User user = userService.userSingUp(userSignUpReqDto);
        BaseResponse baseResponse = BaseResponse.builder().message("Success").build();
        return ResponseEntity.ok(baseResponse);
    }
//    @Operation(summary = "로그인")
//    @PostMapping("/signIn")
//    public BaseResponse<String> userSignIn(@RequestBody UserDto.UserSingInReqDto userSingInReqDto){
//        User user = userRepository.findByEmail(userSingInReqDto.getEmail())
//                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
//        if(!passwordEncoder.matches(userSingInReqDto.getPassword(), user.getPassword())){
//            throw new IllegalArgumentException("잘못된 비밀번호입니다. ");
//        }
//        return BaseResponse.res(true, HttpStatus.OK, "Success", jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
//    }
}
