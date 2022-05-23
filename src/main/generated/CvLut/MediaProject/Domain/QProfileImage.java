package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfileImage is a Querydsl query type for ProfileImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfileImage extends EntityPathBase<ProfileImage> {

    private static final long serialVersionUID = -845964775L;

    public static final QProfileImage profileImage = new QProfileImage("profileImage");

    public final NumberPath<Long> profileImageIdx = createNumber("profileImageIdx", Long.class);

    public final StringPath profileImageUrl = createString("profileImageUrl");

    public final ListPath<UserProfileImage, QUserProfileImage> userProfileImages = this.<UserProfileImage, QUserProfileImage>createList("userProfileImages", UserProfileImage.class, QUserProfileImage.class, PathInits.DIRECT2);

    public QProfileImage(String variable) {
        super(ProfileImage.class, forVariable(variable));
    }

    public QProfileImage(Path<? extends ProfileImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProfileImage(PathMetadata metadata) {
        super(ProfileImage.class, metadata);
    }

}

