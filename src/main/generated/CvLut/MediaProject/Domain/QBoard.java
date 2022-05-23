package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoard is a Querydsl query type for Board
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoard extends EntityPathBase<Board> {

    private static final long serialVersionUID = -2021372961L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoard board = new QBoard("board");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<BoardFeature, QBoardFeature> boardFeatures = this.<BoardFeature, QBoardFeature>createList("boardFeatures", BoardFeature.class, QBoardFeature.class, PathInits.DIRECT2);

    public final NumberPath<Long> boardIdx = createNumber("boardIdx", Long.class);

    public final ListPath<BoardLike, QBoardLike> boardLikes = this.<BoardLike, QBoardLike>createList("boardLikes", BoardLike.class, QBoardLike.class, PathInits.DIRECT2);

    public final ListPath<BoardLutImage, QBoardLutImage> boardLutImages = this.<BoardLutImage, QBoardLutImage>createList("boardLutImages", BoardLutImage.class, QBoardLutImage.class, PathInits.DIRECT2);

    public final ListPath<BoardOriginImage<?>, QBoardOriginImage> boardOriginImages = this.<BoardOriginImage<?>, QBoardOriginImage>createList("boardOriginImages", BoardOriginImage.class, QBoardOriginImage.class, PathInits.DIRECT2);

    public final ListPath<BoardScrap, QBoardScrap> boardScraps = this.<BoardScrap, QBoardScrap>createList("boardScraps", BoardScrap.class, QBoardScrap.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    public final StringPath description = createString("description");

    public final NumberPath<Long> downloadCount = createNumber("downloadCount", Long.class);

    public final ComparablePath<Character> isDeleted = createComparable("isDeleted", Character.class);

    public final StringPath lutFileUrl = createString("lutFileUrl");

    public final StringPath source = createString("source");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public final QUser user;

    public QBoard(String variable) {
        this(Board.class, forVariable(variable), INITS);
    }

    public QBoard(Path<? extends Board> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoard(PathMetadata metadata, PathInits inits) {
        this(Board.class, metadata, inits);
    }

    public QBoard(Class<? extends Board> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

