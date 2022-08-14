package CvLut.MediaProject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
