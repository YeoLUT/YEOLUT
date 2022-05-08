package CvLut.MediaProject.Controller;

import CvLut.MediaProject.Domain.Board;
import CvLut.MediaProject.Dto.BoardDetailResponseDto;
import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Dto.BoardListDto;
import CvLut.MediaProject.Repository.Board.BoardQueryRepository;
import CvLut.MediaProject.Repository.Board.BoardRepository;
import CvLut.MediaProject.Repository.Board.BoardRepositoryImpl;
import CvLut.MediaProject.Service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("board")
@RequiredArgsConstructor
@Tag(name = "Board", description = "게시글 API")
public class BoardController {
    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final BoardRepositoryImpl boardRepositoryImpl;
    private final BoardQueryRepository boardQueryRepository;
    @Operation(summary = "게시글 목록 조회", description = "메인 페이지 게시글 목록")
    @GetMapping("/list")
    public Page<BoardDto.BoardListDto[]> boardList(Pageable pageable){
        return boardRepository.getMainPageBoardList(pageable);
    }
    @Operation(summary = "게시글 상세 조회", description = "특정 게시글 조회")
    @GetMapping("/{boardIdx}")
    public BoardDto.BoardDetailRes boardDetail(@PathVariable("boardIdx") Long boardIdx){
        return boardService.boardDetail(boardIdx);
    }

}
