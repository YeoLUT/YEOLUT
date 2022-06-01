package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Config.JwtTokenProvider;
import CvLut.MediaProject.Domain.User;
import CvLut.MediaProject.Dto.*;
import CvLut.MediaProject.Repository.Board.BoardQueryRepository;
import CvLut.MediaProject.Repository.UserRepository;
import CvLut.MediaProject.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 API")
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final BoardQueryRepository boardQueryRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
//    @PostMapping()
//    public ResponseEntity<User> saveUser(@Validated @RequestBody User user){
//        User savedUser = userRepository.save(user);
//        return ResponseEntity.ok(savedUser);
//    }
    @Operation(summary = "추천 작가 조회 API", description = "유저, 게시글 관련 데이터")
    @GetMapping("/recommend")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseUserRecommendList.class)))
    public BaseResponse<Page<UserRecommendedListDto[]>> recommendedUserList(Pageable pageable){
        return BaseResponse.res(true, HttpStatus.OK, "Success", userRepository.recommendedUserList(pageable));
    }

    @Operation(summary = "유저 작성 게시글 목록", description = "")
    @GetMapping("{userIdx}/boards")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseUserBoardList.class)))
    public BaseResponse<List<BoardDto.UserBoardList>> userBoardList(@PathVariable Long userIdx){
        return BaseResponse.res(true, HttpStatus.OK, "Success", boardQueryRepository.UserBoardList(userIdx));
    }

    @Operation(summary = "유저 좋아요 게시글 목록", description = "")
    @GetMapping("{userIdx}/likes")
    @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ApiCallResponse.ApiCallResponseUserBoardList.class)))
    public BaseResponse<List<BoardDto.UserBoardList>> userLikeList(@PathVariable Long userIdx){
        return BaseResponse.res(true, HttpStatus.OK, "Success", boardQueryRepository.UserLikeList(userIdx));
    }

    @Operation(summary = "회원 가입")
    @PostMapping("/signUp")
    public BaseResponse userSignUp(@RequestBody UserDto.UserSignUpReqDto userSignUpReqDto){
        userService.userSingUp(userSignUpReqDto);
        return BaseResponse.res(true, HttpStatus.OK, "Success");
    }
    public BaseResponse<String> userSignIn(@RequestBody UserDto.UserSingInReqDto userSingInReqDto){
        User user = userRepository.findByEmail(userSingInReqDto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 E-MAIL 입니다."));
        if(!passwordEncoder.matches(userSingInReqDto.getPassword(), user.getPassword())){
            throw new IllegalArgumentException("잘못된 비밀번호입니다. ");
        }
        return BaseResponse.res(true, HttpStatus.OK, "Success", jwtTokenProvider.createToken(user.getUsername(), user.getRoles()));
    }
}
