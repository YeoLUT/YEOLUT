package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFeature is a Querydsl query type for Feature
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFeature extends EntityPathBase<Feature> {

    private static final long serialVersionUID = 2049605039L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFeature feature = new QFeature("feature");

    public final ListPath<BoardFeature, QBoardFeature> boardFeatures = this.<BoardFeature, QBoardFeature>createList("boardFeatures", BoardFeature.class, QBoardFeature.class, PathInits.DIRECT2);

    public final ListPath<Feature, QFeature> children = this.<Feature, QFeature>createList("children", Feature.class, QFeature.class, PathInits.DIRECT2);

    public final NumberPath<Long> featureIdx = createNumber("featureIdx", Long.class);

    public final StringPath featureName = createString("featureName");

    public final QFeature parentIdx;

    public QFeature(String variable) {
        this(Feature.class, forVariable(variable), INITS);
    }

    public QFeature(Path<? extends Feature> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFeature(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFeature(PathMetadata metadata, PathInits inits) {
        this(Feature.class, metadata, inits);
    }

    public QFeature(Class<? extends Feature> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parentIdx = inits.isInitialized("parentIdx") ? new QFeature(forProperty("parentIdx"), inits.get("parentIdx")) : null;
    }

}

