package CvLut.MediaProject.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LutImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long LutImageIdx;

    @Column
    private String lutUrl;
    @OneToMany(mappedBy = "lutImage")
    private List<BoardLutImage> boardLutImages = new ArrayList<>();
}
