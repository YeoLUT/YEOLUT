package CvLut.MediaProject.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
