package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLutImage is a Querydsl query type for LutImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLutImage extends EntityPathBase<LutImage> {

    private static final long serialVersionUID = -1495648137L;

    public static final QLutImage lutImage = new QLutImage("lutImage");

    public final ListPath<BoardLutImage, QBoardLutImage> boardLutImages = this.<BoardLutImage, QBoardLutImage>createList("boardLutImages", BoardLutImage.class, QBoardLutImage.class, PathInits.DIRECT2);

    public final NumberPath<Long> LutImageIdx = createNumber("LutImageIdx", Long.class);

    public final StringPath lutUrl = createString("lutUrl");

    public QLutImage(String variable) {
        super(LutImage.class, forVariable(variable));
    }

    public QLutImage(Path<? extends LutImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLutImage(PathMetadata metadata) {
        super(LutImage.class, metadata);
    }

}

