package CvLut.MediaProject.Domain;

import javax.persistence.*;

@Entity
public class BoardOriginImage<boardOriginImageIdx> {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardOriginImageIdx;

    @ManyToOne
    @JoinColumn(name = "boardIdx")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "originImageIdx")
    private OriginImage originImage;
}
