package CvLut.MediaProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private Integer isLike;
}
