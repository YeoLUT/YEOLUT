package CvLut.MediaProject.Repository.Board;

import CvLut.MediaProject.Domain.Board;
import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Dto.QBoardDto_BoardDetailDto;
import CvLut.MediaProject.Dto.QBoardDto_BoardListDto;
import CvLut.MediaProject.Dto.QBoardDto_UserBoardList;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
// qclass
import static CvLut.MediaProject.Domain.QBoard.board;
import static CvLut.MediaProject.Domain.QFeature.feature;
import static CvLut.MediaProject.Domain.QUser.user;
import static CvLut.MediaProject.Domain.QUserProfileImage.userProfileImage;
import static CvLut.MediaProject.Domain.QProfileImage.profileImage;
import static CvLut.MediaProject.Domain.QBoardLutImage.boardLutImage;
import static CvLut.MediaProject.Domain.QLutImage.lutImage;
import static CvLut.MediaProject.Domain.QBoardLike.boardLike;
import static CvLut.MediaProject.Domain.QBoardFeature.boardFeature;
import static org.springframework.util.Assert.hasText;

@RequiredArgsConstructor
@Repository
public class BoardQueryRepository {
    private final JPAQueryFactory queryFactory;
    private BooleanExpression searchIn(String search){
        return search == null ? null : board.title.contains(search);
    }
    private BooleanExpression featureIdxListIn(List<Long> featureIdxList){
        return featureIdxList.isEmpty() ? null : boardFeature.feature.featureIdx.in(featureIdxList);
    }

    public Page<BoardDto.BoardListDto> BoardSearch(Pageable pageable, List<Long> featureIdxList, String search){

        List<BoardDto.BoardListDto> results = queryFactory.select(new QBoardDto_BoardListDto(board.boardIdx, board.title, board.downloadCount,
                        board.createdAt, user.userIdx
                        , user.name, lutImage.lutUrl,profileImage.profileImageUrl, boardLike.boardLikeIdx.count()))
                .from(board)
                .leftJoin(board.user, user)
                .leftJoin(user.userProfileImages,userProfileImage)
                .leftJoin(userProfileImage.profileImage, profileImage)
                .leftJoin(board.boardLutImages, boardLutImage)
                .leftJoin(boardLutImage.lutImage, lutImage)
                .leftJoin(board.boardLikes, boardLike).on(boardLike.isLike.eq(1))
                .leftJoin(board.boardFeatures, boardFeature)
                .where(featureIdxListIn(featureIdxList),
                        searchIn(search))
                .groupBy(board.boardIdx, boardLike.board.boardIdx, boardLutImage.board.boardIdx)
                .orderBy(board.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPQLQuery<Board> count = queryFactory.select(board)
                .from(board)
                .leftJoin(board.user, user)
                .leftJoin(user.userProfileImages,userProfileImage)
                .leftJoin(userProfileImage.profileImage, profileImage)
                .leftJoin(board.boardLutImages, boardLutImage)
                .leftJoin(boardLutImage.lutImage, lutImage)
                .leftJoin(board.boardLikes, boardLike).on(boardLike.isLike.eq(1))
                .where(featureIdxListIn(featureIdxList),
                        searchIn(search));

        System.out.println(PageableExecutionUtils.getPage(results, pageable, ()->count.fetchCount()));
        return  PageableExecutionUtils.getPage(results, pageable, ()->count.fetchCount());

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
    public List<BoardDto.UserBoardList> UserBoardList(Long userIdx){
        return queryFactory.select(new QBoardDto_UserBoardList(board.boardIdx, board.title, lutImage.lutUrl))
                .from(board)
                .leftJoin(board.boardLutImages, boardLutImage)
                .leftJoin(boardLutImage.lutImage, lutImage)
                .where(board.user.userIdx.eq(userIdx)).fetch()
                ;

    }
    public List<BoardDto.UserBoardList> UserLikeList(Long userIdx){
        return queryFactory
                .select(new QBoardDto_UserBoardList(board.boardIdx, board.title, lutImage.lutUrl))
                .from(board)
                .leftJoin( board.boardLikes, boardLike).on(boardLike.user.userIdx.eq(userIdx), boardLike.isLike.eq(1))
                .leftJoin(board.boardLutImages, boardLutImage)
                .leftJoin(boardLutImage.lutImage, lutImage)
                .fetch();
    }
}
