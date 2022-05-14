package CvLut.MediaProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
