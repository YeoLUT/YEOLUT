package CvLut.MediaProject.Dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.Dto.QBoardDto_BoardListDto is a Querydsl Projection type for BoardListDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardDto_BoardListDto extends ConstructorExpression<BoardDto.BoardListDto> {

    private static final long serialVersionUID = 1877479582L;

    public QBoardDto_BoardListDto(com.querydsl.core.types.Expression<Long> boardIdx, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<Long> downloadCount, com.querydsl.core.types.Expression<? extends java.sql.Timestamp> createdAt, com.querydsl.core.types.Expression<Long> userIdx, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> lutUrl, com.querydsl.core.types.Expression<String> profileImageUrl, com.querydsl.core.types.Expression<Long> likeCount) {
        super(BoardDto.BoardListDto.class, new Class<?>[]{long.class, String.class, long.class, java.sql.Timestamp.class, long.class, String.class, String.class, String.class, long.class}, boardIdx, title, downloadCount, createdAt, userIdx, name, lutUrl, profileImageUrl, likeCount);
    }

}

