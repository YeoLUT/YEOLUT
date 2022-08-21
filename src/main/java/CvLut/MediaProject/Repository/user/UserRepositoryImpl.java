package CvLut.MediaProject.repository.user;

import CvLut.MediaProject.dto.QUserDto_UserRecommendedListDto;
import CvLut.MediaProject.dto.UserDto;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import static CvLut.MediaProject.domain.QUser.user;
import static CvLut.MediaProject.domain.QProfileImage.profileImage;
import static CvLut.MediaProject.domain.QUserProfileImage.userProfileImage;
import static CvLut.MediaProject.domain.QBoard.board;
import static CvLut.MediaProject.domain.QBoardLike.boardLike;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserCustomRepository {
    private final JPAQueryFactory queryFactory;
    public Page<UserDto.UserRecommendedListDto> recommendedUserList(Pageable pageable){
        List<UserDto.UserRecommendedListDto> results = queryFactory.select(new QUserDto_UserRecommendedListDto(user.userIdx, user.name, profileImage.profileImageUrl, board.downloadCount.sum(), boardLike.isLike.count()))
                .from(user)
                .leftJoin(userProfileImage).on(user.eq(userProfileImage.user))
                .leftJoin(profileImage).on(userProfileImage.profileImage.eq(profileImage))
                .leftJoin(board).on(board.user.eq(user))
                .leftJoin(boardLike).on(boardLike.board.eq(board))
                .groupBy(user.userIdx)
                .orderBy(board.downloadCount.sum().desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPQLQuery<Long> count = queryFactory.select(user.userIdx.count())
                .from(user)
                .leftJoin(userProfileImage).on(user.eq(userProfileImage.user))
                .leftJoin(profileImage).on(userProfileImage.profileImage.eq(profileImage))
                .leftJoin(board).on(board.user.eq(user))
                .leftJoin(boardLike).on(boardLike.board.eq(board))
                .groupBy(board.user);
        return PageableExecutionUtils.getPage(results, pageable , () -> count.fetchOne());
    }

}
