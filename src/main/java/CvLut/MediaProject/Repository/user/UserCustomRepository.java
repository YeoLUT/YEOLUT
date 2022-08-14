package CvLut.MediaProject.repository.user;

import CvLut.MediaProject.Dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserCustomRepository {
    public Page<UserDto.UserRecommendedListDto> recommendedUserList(Pageable pageable);
}
