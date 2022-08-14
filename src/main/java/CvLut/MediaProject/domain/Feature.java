package CvLut.MediaProject.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Feature {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long featureIdx;

    @Column
    private String featureName;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentIdx")
    private Feature parentIdx;
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentIdx")
    private List<Feature> children;


    @OneToMany(mappedBy = "feature")
    private List<BoardFeature> boardFeatures = new ArrayList<>();

}
