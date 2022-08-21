package CvLut.MediaProject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardFeature {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardFeatureIdx;

    @ManyToOne
    @JoinColumn(name = "boardIdx", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "featureIdx", nullable = false)
    private Feature feature;
}
