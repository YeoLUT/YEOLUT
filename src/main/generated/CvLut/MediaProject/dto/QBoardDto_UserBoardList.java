package CvLut.MediaProject.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.dto.QBoardDto_UserBoardList is a Querydsl Projection type for UserBoardList
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardDto_UserBoardList extends ConstructorExpression<BoardDto.UserBoardList> {

    private static final long serialVersionUID = -951781546L;

    public QBoardDto_UserBoardList(com.querydsl.core.types.Expression<Long> boardIdx, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<String> lutImage) {
        super(BoardDto.UserBoardList.class, new Class<?>[]{long.class, String.class, String.class}, boardIdx, title, lutImage);
    }

}

