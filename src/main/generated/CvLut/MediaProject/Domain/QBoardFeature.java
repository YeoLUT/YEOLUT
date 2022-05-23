package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBoardFeature is a Querydsl query type for BoardFeature
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBoardFeature extends EntityPathBase<BoardFeature> {

    private static final long serialVersionUID = 1512209943L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBoardFeature boardFeature = new QBoardFeature("boardFeature");

    public final QBoard board;

    public final NumberPath<Long> boardFeatureIdx = createNumber("boardFeatureIdx", Long.class);

    public final QFeature feature;

    public QBoardFeature(String variable) {
        this(BoardFeature.class, forVariable(variable), INITS);
    }

    public QBoardFeature(Path<? extends BoardFeature> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBoardFeature(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBoardFeature(PathMetadata metadata, PathInits inits) {
        this(BoardFeature.class, metadata, inits);
    }

    public QBoardFeature(Class<? extends BoardFeature> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new QBoard(forProperty("board"), inits.get("board")) : null;
        this.feature = inits.isInitialized("feature") ? new QFeature(forProperty("feature"), inits.get("feature")) : null;
    }

}

