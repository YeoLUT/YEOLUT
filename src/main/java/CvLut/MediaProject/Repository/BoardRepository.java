package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.Board;
import CvLut.MediaProject.Dto.BoardListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query(value = "select  b.board_idx as board_idx, title, download_count, b.created_at as created_at, u.user_idx as user_idx,u.name as name, lut_url, pi.profile_image_url as profile_image_url, count(bl.board_like_idx) as likeCount  \n" +
            "            FROM Board b \n" +
            "            LEFT JOIN user u on u.user_idx = b.user_idx \n" +
            "            LEFT JOIN board_lut_image bli on bli.board_idx = b.board_idx \n" +
            "            LEFT JOIN user_profile_image upi on upi.user_idx = u.user_idx \n" +
            "            LEFT JOIN profile_image pi on pi.profile_image_idx = upi.profile_image_idx \n" +
            "            LEFT JOIN lut_image li on li.lut_image_idx = bli.lut_image_idx \n" +
            "            LEFT JOIN board_like bl on bl.board_idx = b.board_idx and bl.is_like = true \n" +
            "            GROUP BY b.board_idx " +
            "            ORDER BY b.created_at DESC ", nativeQuery = true)
    Page<BoardListDto[]> getMainPageBoardList(Pageable pageable);

}
