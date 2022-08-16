package CvLut.MediaProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 변경되지 않는 인스턴스에 대해서도 setter로 접근이 가능하기 때문에 일관성, 안정성 보장을 위해 Setter 제거
// Builder는 일부 필드 혹은 파라미터를 갖지 않는 생성자가 있으면 오류를 발생시킨다. AllArgsConstructor와 함께 이용
// 양방향 연관관계의 경우  연관관계 주인을 고려하고 주인이 아닌쪽은 읽기만 가능하다.
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
    private User user;

//    @OneToMany(mappedBy = "board")
//    private List<BoardLike> boardLikes = new ArrayList<>();
//    @OneToMany(mappedBy = "board")
//    private List<BoardScrap> boardScraps = new ArrayList<>();
//    @OneToMany(mappedBy = "board")
//    private List<BoardLutImage> boardLutImages = new ArrayList<>();
//    @OneToMany(mappedBy = "board")
//    private List<BoardOriginImage> boardOriginImages = new ArrayList<>();
//    @OneToMany(mappedBy = "board")
//    private List<BoardFeature> boardFeatures = new ArrayList<>();
}
