package CvLut.MediaProject.Domain;

import javax.persistence.*;

@Entity
public class BoardLike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardLikeIdx;
    @ManyToOne()
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "boardIdx")
    private Board board;
    @Column
    private int isLike;
}
