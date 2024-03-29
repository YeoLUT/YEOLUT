package CvLut.MediaProject.repository.board;

import CvLut.MediaProject.dto.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
// qclass
import static CvLut.MediaProject.domain.QBoard.board;
import static CvLut.MediaProject.domain.QFeature.feature;
import static CvLut.MediaProject.domain.QUser.user;
import static CvLut.MediaProject.domain.QUserProfileImage.userProfileImage;
import static CvLut.MediaProject.domain.QProfileImage.profileImage;
import static CvLut.MediaProject.domain.QBoardLutImage.boardLutImage;
import static CvLut.MediaProject.domain.QLutImage.lutImage;
import static CvLut.MediaProject.domain.QBoardLike.boardLike;
import static CvLut.MediaProject.domain.QBoardFeature.boardFeature;
import static org.springframework.util.Assert.hasText;
@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardCustomRepository {
    private final JPAQueryFactory queryFactory;
//    public BoardRepositoryImpl(EntityManager em){
//        this.queryFactory = new JPAQueryFactory(em);
//    }
    private BooleanExpression searchIn(String search){
        return search == null ? null : board.title.contains(search);
    }
    private BooleanExpression featureIdxListIn(List<Long> featureIdxList){
        return featureIdxList.isEmpty() ? null : boardFeature.feature.featureIdx.in(featureIdxList);
    }

    public Page<BoardDto.BoardListDto> boardSearch(Pageable pageable, List<Long> featureIdxList, String search){

        List<BoardDto.BoardListDto> results = queryFactory.select(new QBoardDto_BoardListDto(board.boardIdx, board.title, board.downloadCount,
                        board.createdAt, user.userIdx
                        , user.name, lutImage.lutUrl,profileImage.profileImageUrl, boardLike.boardLikeIdx.count()))
                .from(board)
                .leftJoin(user).on(board.user.eq(user))
                .leftJoin(userProfileImage).on(userProfileImage.user.eq(user))
                .leftJoin(profileImage).on(userProfileImage.profileImage.eq(profileImage))
                .leftJoin(boardLutImage).on(boardLutImage.board.eq(board))
                .leftJoin(lutImage).on(boardLutImage.lutImage.eq(lutImage))
                .leftJoin(boardLike).on(boardLike.isLike.eq(1), boardLike.board.eq(board))
                .leftJoin(boardFeature).on(boardFeature.board.eq(board))
                .where(featureIdxListIn(featureIdxList),
                        searchIn(search))
                .groupBy(board.boardIdx, boardLike.board.boardIdx, boardLutImage.board.boardIdx)
                .orderBy(board.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        JPQLQuery<Long> count = queryFactory.select(board.count())
                .from(board)
                .leftJoin(user).on(board.user.eq(user))
                .leftJoin(userProfileImage).on(userProfileImage.user.eq(user))
                .leftJoin(profileImage).on(userProfileImage.profileImage.eq(profileImage))
                .leftJoin(boardLutImage).on(boardLutImage.board.eq(board))
                .leftJoin(lutImage).on(boardLutImage.lutImage.eq(lutImage))
                .leftJoin(boardLike).on(boardLike.isLike.eq(1), boardLike.board.eq(board))
                .leftJoin(boardFeature).on(boardFeature.board.eq(board))
                .where(featureIdxListIn(featureIdxList),
                        searchIn(search));

        // System.out.println(PageableExecutionUtils.getPage(results, pageable, ()->count.fetchCount()));
        return  PageableExecutionUtils.getPage(results, pageable, ()->count.fetchCount());

    }
    public List<BoardDto.BoardDetailDto> boardInfo(Long boardIdx){
        return queryFactory.select(new QBoardDto_BoardDetailDto(board.boardIdx, board.title, board.downloadCount, board.createdAt
                        , board.description, board.source, user.userIdx, user.name, lutImage.lutUrl,
                        profileImage.profileImageUrl,  boardLike.boardLikeIdx.count()))
                .from(board)
                .leftJoin(user).on(board.user.eq(user))
                .leftJoin(userProfileImage).on(userProfileImage.user.eq(user))
                .leftJoin(profileImage).on(userProfileImage.profileImage.eq(profileImage))
                .leftJoin(boardLutImage).on(boardLutImage.board.eq(board))
                .leftJoin(lutImage).on(boardLutImage.lutImage.eq(lutImage))
                .leftJoin(boardLike).on(boardLike.isLike.eq(1), boardLike.board.eq(board))
                .where(board.boardIdx.eq(boardIdx))
                .fetch();
    }

    public List<BoardDto.UserBoardList> userBoardList(Long userIdx){
        return queryFactory.select(new QBoardDto_UserBoardList(board.boardIdx, board.title, lutImage.lutUrl))
                .from(board)
                .leftJoin(boardLutImage).on(boardLutImage.board.eq(board))
                .leftJoin(lutImage).on(lutImage.eq(boardLutImage.lutImage))
                .where(board.user.userIdx.eq(userIdx)).fetch()
                ;
    }

    // query 수정
    public List<BoardDto.UserBoardList> userLikeList(Long userIdx){
        return queryFactory
                .select(new QBoardDto_UserBoardList(board.boardIdx, board.title, lutImage.lutUrl))
                .from(boardLike)
                .leftJoin(board).on(board.eq(boardLike.board))
                .leftJoin(boardLutImage).on(boardLutImage.board.eq(board))
                .leftJoin(lutImage).on(boardLutImage.lutImage.eq(lutImage))
                .where(boardLike.user.userIdx.eq(userIdx), boardLike.isLike.eq(1))
                .fetch();
    }

    public List<FeatureDto.DefaultFeature> boardFeatureList(Long boardIdx){
        return queryFactory
                .select(new QFeatureDto_DefaultFeature(feature.featureIdx, feature.featureName))
                .from(boardFeature)
                .leftJoin(feature).on(feature.eq(boardFeature.feature))
                .where(boardFeature.board.boardIdx.eq(boardIdx))
                .fetch();
    }
}
