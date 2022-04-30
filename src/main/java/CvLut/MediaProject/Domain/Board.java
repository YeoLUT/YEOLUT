package CvLut.MediaProject.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@NamedNativeQuery(name = "",
//query = "select  b.board_idx as board_idx, title, download_count, b.created_at as created_at, u.user_idx as user_idx,u.name as name, lut_url, pi.profile_image_url as profile_image_url, count(bl.board_like_idx) as likeCount  \n" +
//        "            FROM Board b \n" +
//        "            LEFT JOIN user u on u.user_idx = b.user_idx \n" +
//        "            LEFT JOIN board_lut_image bli on bli.board_idx = b.board_idx \n" +
//        "            LEFT JOIN user_profile_image upi on upi.user_idx = u.user_idx \n" +
//        "            LEFT JOIN profile_image pi on pi.profile_image_idx = upi.profile_image_idx \n" +
//        "            LEFT JOIN lut_image li on li.lut_image_idx = bli.lut_image_idx \n" +
//        "            LEFT JOIN board_like bl on bl.board_idx = b.board_idx and bl.is_like = true \n" +
//        "            GROUP BY b.board_idx " +
//        "            ORDER BY b.created_at DESC ",
//resultSetMapping = "Mapping.BoardListDto")
//@SqlResultSetMapping(name="Mapping.BoardListDto")
public class Board extends BaseEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardIdx;
    @Column
    private String title;
    @Column
    private Long downloadCount;
    @Column
    private char isDeleted;
    @Column
    private String lutFileUrl;
    @Column
    private String source;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "userIdx")
//    @JoinTable(
//            name = "User",
//            joinColumns = @JoinColumn(name = "boardIdx"),
//            inverseJoinColumns = @JoinColumn(name="userIdx")
//    )
    private User user;

    @OneToMany(mappedBy = "board")
    private List<BoardLike> boardLikes = new ArrayList<>();
    @OneToMany(mappedBy = "board")
    private List<BoardScrap> boardScraps = new ArrayList<>();
    @OneToMany(mappedBy = "board")
    private List<BoardLutImage> boardLutImages = new ArrayList<>();
    @OneToMany(mappedBy = "board")
    private List<BoardOriginImage> boardOriginImages = new ArrayList<>();
    @OneToMany(mappedBy = "board")
    private List<BoardFeature> boardFeatures = new ArrayList<>();
}
