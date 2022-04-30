package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Dto.BoardListDto;
import CvLut.MediaProject.Repository.BoardRepository;
import CvLut.MediaProject.Service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
@Tag(name = "Board", description = "게시글 API")
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    @Operation(summary = "게시글 목록 조회", description = "메인 페이지 게시글 목록")
    @GetMapping("/list")
    public Page<BoardListDto[]> boardList(Pageable pageable){
        System.out.println(pageable);
        return boardRepository.getMainPageBoardList(pageable);
    }
}
