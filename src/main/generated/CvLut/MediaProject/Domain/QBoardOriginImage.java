package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardOriginImage is a Querydsl query type for BoardOriginImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardOriginImage extends EntityPathBase<BoardOriginImage<?>> {

    private static final long serialVersionUID = -428139402L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardOriginImage boardOriginImage = new QBoardOriginImage("boardOriginImage");

    public final QBoard board;

    public final NumberPath<Long> boardOriginImageIdx = createNumber("boardOriginImageIdx", Long.class);

    public final QOriginImage originImage;

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QBoardOriginImage(String variable) {
        this((Class) BoardOriginImage.class, forVariable(variable), INITS);
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QBoardOriginImage(Path<? extends BoardOriginImage> path) {
        this((Class) path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardOriginImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    @SuppressWarnings({"all", "rawtypes", "unchecked"})
    public QBoardOriginImage(PathMetadata metadata, PathInits inits) {
        this((Class) BoardOriginImage.class, metadata, inits);
    }

    public QBoardOriginImage(Class<? extends BoardOriginImage<?>> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
        this.originImage = inits.isInitialized("originImage") ? new QOriginImage(forProperty("originImage")) : null;
    }

}

