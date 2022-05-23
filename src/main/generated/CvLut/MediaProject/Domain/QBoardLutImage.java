package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardLutImage is a Querydsl query type for BoardLutImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardLutImage extends EntityPathBase<BoardLutImage> {

    private static final long serialVersionUID = -975026929L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardLutImage boardLutImage = new QBoardLutImage("boardLutImage");

    public final QBoard board;

    public final NumberPath<Long> boardLutImageIdx = createNumber("boardLutImageIdx", Long.class);

    public final QLutImage lutImage;

    public QBoardLutImage(String variable) {
        this(BoardLutImage.class, forVariable(variable), INITS);
    }

    public QBoardLutImage(Path<? extends BoardLutImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardLutImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardLutImage(PathMetadata metadata, PathInits inits) {
        this(BoardLutImage.class, metadata, inits);
    }

    public QBoardLutImage(Class<? extends BoardLutImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
        this.lutImage = inits.isInitialized("lutImage") ? new QLutImage(forProperty("lutImage")) : null;
    }

}

