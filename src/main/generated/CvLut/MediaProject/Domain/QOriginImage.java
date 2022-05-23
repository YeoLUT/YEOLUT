package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOriginImage is a Querydsl query type for OriginImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOriginImage extends EntityPathBase<OriginImage> {

    private static final long serialVersionUID = -1127641074L;

    public static final QOriginImage originImage = new QOriginImage("originImage");

    public final ListPath<BoardOriginImage<?>, QBoardOriginImage> boardOriginImages = this.<BoardOriginImage<?>, QBoardOriginImage>createList("boardOriginImages", BoardOriginImage.class, QBoardOriginImage.class, PathInits.DIRECT2);

    public final NumberPath<Long> originImageIdx = createNumber("originImageIdx", Long.class);

    public final StringPath originImageUrl = createString("originImageUrl");

    public QOriginImage(String variable) {
        super(OriginImage.class, forVariable(variable));
    }

    public QOriginImage(Path<? extends OriginImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOriginImage(PathMetadata metadata) {
        super(OriginImage.class, metadata);
    }

}

