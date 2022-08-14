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
    @JoinColumn(name = "userIdx")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardIdx")
    private Board board;
}
