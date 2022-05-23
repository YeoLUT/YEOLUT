package CvLut.MediaProject.Domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -480277582L;

    public static final QUser user = new QUser("user");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final ListPath<BoardLike, QBoardLike> boardLikes = this.<BoardLike, QBoardLike>createList("boardLikes", BoardLike.class, QBoardLike.class, PathInits.DIRECT2);

    public final ListPath<Board, QBoard> boards = this.<Board, QBoard>createList("boards", Board.class, QBoard.class, PathInits.DIRECT2);

    public final ListPath<BoardScrap, QBoardScrap> boardScraps = this.<BoardScrap, QBoardScrap>createList("boardScraps", BoardScrap.class, QBoardScrap.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final ComparablePath<Character> isDeleted = createComparable("isDeleted", Character.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userIdx = createNumber("userIdx", Long.class);

    public final ListPath<UserProfileImage, QUserProfileImage> userProfileImages = this.<UserProfileImage, QUserProfileImage>createList("userProfileImages", UserProfileImage.class, QUserProfileImage.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

