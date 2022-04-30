package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Domain.User;
import CvLut.MediaProject.Dto.UserRecommendedListDto;
import CvLut.MediaProject.Repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User", description = "유저 API")
public class UserController {
    private final UserRepository userRepository;
//    @PostMapping()
//    public ResponseEntity<User> saveUser(@Validated @RequestBody User user){
//        User savedUser = userRepository.save(user);
//        return ResponseEntity.ok(savedUser);
//    }
    @Operation(summary = "추천 작가 조회 API", description = "유저, 게시글 관련 데이터")
    @GetMapping("/recommend")
    public Page<UserRecommendedListDto[]> recommendedUserList(Pageable pageable){
        return userRepository.recommendedUserList(pageable);
    }
}
