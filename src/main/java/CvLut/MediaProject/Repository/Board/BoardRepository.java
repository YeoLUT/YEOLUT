package CvLut.MediaProject.Repository.Board;
import CvLut.MediaProject.Domain.Board;
import CvLut.MediaProject.Dto.BoardDetailResponseDto;
import CvLut.MediaProject.Dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
