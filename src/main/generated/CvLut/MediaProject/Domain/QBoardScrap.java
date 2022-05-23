package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardScrap is a Querydsl query type for BoardScrap
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardScrap extends EntityPathBase<BoardScrap> {

    private static final long serialVersionUID = 129736498L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardScrap boardScrap = new QBoardScrap("boardScrap");

    public final QBoard board;

    public final NumberPath<Long> boardScrapIdx = createNumber("boardScrapIdx", Long.class);

    public final BooleanPath isScrap = createBoolean("isScrap");

    public final QUser user;

    public QBoardScrap(String variable) {
        this(BoardScrap.class, forVariable(variable), INITS);
    }

    public QBoardScrap(Path<? extends BoardScrap> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardScrap(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardScrap(PathMetadata metadata, PathInits inits) {
        this(BoardScrap.class, metadata, inits);
    }

    public QBoardScrap(Class<? extends BoardScrap> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

