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
public class BoardScrap {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardScrapIdx;

    private boolean isScrap;

    @ManyToOne
    @JoinColumn(name = "userIdx", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardIdx", nullable = false)
    private Board board;
}
