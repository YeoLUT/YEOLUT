package CvLut.MediaProject.Repository.Board;

import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Dto.QBoardDto_BoardDetailDto;
import CvLut.MediaProject.Dto.QBoardDto_BoardListDto;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
// qclass
import static CvLut.MediaProject.Domain.QBoard.board;
import static CvLut.MediaProject.Domain.QUser.user;
import static CvLut.MediaProject.Domain.QUserProfileImage.userProfileImage;
import static CvLut.MediaProject.Domain.QProfileImage.profileImage;
import static CvLut.MediaProject.Domain.QBoardLutImage.boardLutImage;
import static CvLut.MediaProject.Domain.QLutImage.lutImage;
import static CvLut.MediaProject.Domain.QBoardLike.boardLike;
@RequiredArgsConstructor
@Repository
public class BoardQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<BoardDto.BoardListDto> BoardSearch(){
        //Path<String> likeCount = Expressions.path();
        return queryFactory.select(new QBoardDto_BoardListDto(board.boardIdx, board.title, board.downloadCount, board.createdAt, user.userIdx
                        , user.name, lutImage.lutUrl,profileImage.profileImageUrl, boardLike.boardLikeIdx.count()))
                .from(board)
                .leftJoin(board.user, user)
                .leftJoin(user.userProfileImages,userProfileImage)
                .leftJoin(userProfileImage.profileImage, profileImage)
                .leftJoin(board.boardLutImages, boardLutImage)
                .leftJoin(boardLutImage.lutImage, lutImage)
                .leftJoin(board.boardLikes, boardLike).on(boardLike.isLike.eq(1))
                .groupBy(board.boardIdx)
                .orderBy(board.createdAt.desc())
                .fetch();
    }
    public List<BoardDto.BoardDetailDto> BoardInfo(Long boardIdx){
        return queryFactory.select(new QBoardDto_BoardDetailDto(board.boardIdx, board.title, board.downloadCount, board.createdAt
                        , board.description, board.source, user.userIdx, user.name, lutImage.lutUrl,
                        profileImage.profileImageUrl,  boardLike.boardLikeIdx.count()))
                .from(board)
                .leftJoin(board.user, user)
                .leftJoin(user.userProfileImages,userProfileImage)
                .leftJoin(userProfileImage.profileImage, profileImage)
                .leftJoin(board.boardLutImages, boardLutImage)
                .leftJoin(boardLutImage.lutImage, lutImage)
                .leftJoin(board.boardLikes, boardLike).on(boardLike.isLike.eq(1))
                .where(board.boardIdx.eq(boardIdx))
                .fetch();
    }
}
