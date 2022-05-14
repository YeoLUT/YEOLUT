package CvLut.MediaProject.Repository.Board;
import CvLut.MediaProject.Domain.Board;
import CvLut.MediaProject.Dto.BoardDetailResponseDto;
import CvLut.MediaProject.Dto.BoardDto;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static CvLut.MediaProject.Domain.QBoard.board;
import static CvLut.MediaProject.Domain.QUser.user;
//@Repository
//public class BoardRepositoryImpl implements BoardCustomRepository {
//    private final JPAQueryFactory queryFactory;
//
//
//    public BoardRepositoryImpl(JPAQueryFactory queryFactory) {
//        this.queryFactory = queryFactory;
//    }
//
//    @Override
//    public Page<BoardDto.BoardListDto[]> getMainPageBoardList(Pageable pageable) {
//        //queryFactory.select().from(board).leftjoin(board.user, user).on(board.user)
//        return null;
////        return queryFactory.select().from();
//    }
//    @Override
//    public List<Board> getBoard(){
//        //return queryFactory.selectFrom(board).fetch();
//        return null;
//    }
//    @Override
//    public BoardDetailResponseDto getBoardDetail(Long boardIdx) {
//        return null;
//    }
//}
