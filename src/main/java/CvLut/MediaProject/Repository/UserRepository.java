package CvLut.MediaProject.Repository;

import CvLut.MediaProject.Domain.User;
import CvLut.MediaProject.Dto.UserRecommendedListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u.user_idx as userIdx, name, profile_image_url as profileImgeUrl, sum(download_count) as downloadCount, count(is_like) as likeCount\n" +
            "FROM user u\n" +
            "left join user_profile_image upl on upl.user_idx = u.user_idx\n" +
            "left join profile_image pi on pi.profile_image_idx = upl.profile_image_idx\n" +
            "left join board b on b.user_idx = u.user_idx\n" +
            "left join board_like bl on bl.board_idx = b.board_idx and is_like = 1\n" +
            "group by b.user_idx\n" +
            "order by sum(download_count) desc", nativeQuery = true)
    Page<UserRecommendedListDto[]> recommendedUserList(Pageable pageable);
}
