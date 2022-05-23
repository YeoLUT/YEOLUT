package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserProfileImage is a Querydsl query type for UserProfileImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserProfileImage extends EntityPathBase<UserProfileImage> {

    private static final long serialVersionUID = 436647428L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserProfileImage userProfileImage = new QUserProfileImage("userProfileImage");

    public final QProfileImage profileImage;

    public final QUser user;

    public final NumberPath<Long> userProfileImageIdx = createNumber("userProfileImageIdx", Long.class);

    public QUserProfileImage(String variable) {
        this(UserProfileImage.class, forVariable(variable), INITS);
    }

    public QUserProfileImage(Path<? extends UserProfileImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserProfileImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserProfileImage(PathMetadata metadata, PathInits inits) {
        this(UserProfileImage.class, metadata, inits);
    }

    public QUserProfileImage(Class<? extends UserProfileImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.profileImage = inits.isInitialized("profileImage") ? new QProfileImage(forProperty("profileImage")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

