package CvLut.MediaProject.Domain;

import javax.persistence.*;

@Entity
public class BoardScrap {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardScrapIdx;

    private boolean isScrap;

    @ManyToOne
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardIdx")
    private Board board;
}
