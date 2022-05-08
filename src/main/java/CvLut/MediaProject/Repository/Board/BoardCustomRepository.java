package CvLut.MediaProject.Repository.Board;

import CvLut.MediaProject.Domain.Board;
import CvLut.MediaProject.Dto.BoardDetailResponseDto;
import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Dto.BoardListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardCustomRepository {
    Page<BoardDto.BoardListDto[]> getMainPageBoardList(Pageable pageable);
    BoardDetailResponseDto getBoardDetail(@Param("boardIdx") Long boardIdx);
    List<Board> getBoard();
}
