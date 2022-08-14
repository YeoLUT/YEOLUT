package CvLut.MediaProject.dto;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * CvLut.MediaProject.Dto.QBoardDto_BoardDetailDto is a Querydsl Projection type for BoardDetailDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QBoardDto_BoardDetailDto extends ConstructorExpression<BoardDto.BoardDetailDto> {

    private static final long serialVersionUID = -352482101L;

    public QBoardDto_BoardDetailDto(com.querydsl.core.types.Expression<Long> boardIdx, com.querydsl.core.types.Expression<String> title, com.querydsl.core.types.Expression<Long> downloadCount, com.querydsl.core.types.Expression<? extends java.sql.Timestamp> createdAt, com.querydsl.core.types.Expression<String> description, com.querydsl.core.types.Expression<String> source, com.querydsl.core.types.Expression<Long> userIdx, com.querydsl.core.types.Expression<String> name, com.querydsl.core.types.Expression<String> lutUrl, com.querydsl.core.types.Expression<String> profileImageUrl, com.querydsl.core.types.Expression<Long> likeCount) {
        super(BoardDto.BoardDetailDto.class, new Class<?>[]{long.class, String.class, long.class, java.sql.Timestamp.class, String.class, String.class, long.class, String.class, String.class, String.class, long.class}, boardIdx, title, downloadCount, createdAt, description, source, userIdx, name, lutUrl, profileImageUrl, likeCount);
    }

}

