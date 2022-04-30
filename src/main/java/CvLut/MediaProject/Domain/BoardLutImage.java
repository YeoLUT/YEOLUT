package CvLut.MediaProject.Domain;

import javax.persistence.*;

@Entity
public class BoardLutImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardLutImageIdx;
    @ManyToOne
    @JoinColumn(name = "lutImageIdx")
    private LutImage lutImage;
    @ManyToOne
    @JoinColumn(name = "boardIdx")
    private Board board;
}
