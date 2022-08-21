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
public class BoardLike {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardLikeIdx;
    @ManyToOne()
    @JoinColumn(name = "userIdx", nullable = false)
    private User user;

    @ManyToOne()
    @JoinColumn(name = "boardIdx", nullable = false)
    private Board board;
    @Column
    private Integer isLike;
}
