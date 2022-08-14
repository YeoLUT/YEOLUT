package CvLut.MediaProject.repository.board;

import CvLut.MediaProject.Domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long>, BoardCustomRepository {
}
