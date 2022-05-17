package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Domain.User;
import CvLut.MediaProject.Dto.BaseResponse;
import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Dto.UserRecommendedListDto;
import CvLut.MediaProject.Repository.Board.BoardQueryRepository;
import CvLut.MediaProject.Repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 API")
public class UserController {
    private final UserRepository userRepository;
    private final BoardQueryRepository boardQueryRepository;
//    @PostMapping()
//    public ResponseEntity<User> saveUser(@Validated @RequestBody User user){
//        User savedUser = userRepository.save(user);
//        return ResponseEntity.ok(savedUser);
//    }
    @Operation(summary = "추천 작가 조회 API", description = "유저, 게시글 관련 데이터")
    @GetMapping("/recommend")
    public BaseResponse<Page<UserRecommendedListDto[]>> recommendedUserList(Pageable pageable){
        return BaseResponse.res(true, HttpStatus.OK, "Success", userRepository.recommendedUserList(pageable));
    }

    @Operation(summary = "유저 작성 게시글 목록", description = "")
    @GetMapping("{userIdx}/boards")
    public BaseResponse<List<BoardDto.UserBoardList>> userBoardList(@PathVariable Long userIdx){
        return BaseResponse.res(true, HttpStatus.OK, "Success", boardQueryRepository.UserBoardList(userIdx));
    }

    @Operation(summary = "유저 좋아요 게시글 목록", description = "")
    @GetMapping("{userIdx}/likes")
    public BaseResponse<List<BoardDto.UserBoardList>> userLikeList(@PathVariable Long userIdx){
        return BaseResponse.res(true, HttpStatus.OK, "Success", boardQueryRepository.UserLikeList(userIdx));
    }
}
