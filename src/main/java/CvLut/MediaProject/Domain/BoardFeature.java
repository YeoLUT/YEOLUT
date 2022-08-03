package CvLut.MediaProject.Domain;

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
    @JoinColumn(name = "boardIdx")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "featureIdx")
    private Feature feature;
}
