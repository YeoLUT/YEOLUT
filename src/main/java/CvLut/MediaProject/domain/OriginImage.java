package CvLut.MediaProject.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OriginImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long originImageIdx;

    @Column( nullable = false)
    private String originImageUrl;

//    @OneToMany(mappedBy = "originImage")
//    private List<BoardOriginImage> boardOriginImages = new ArrayList<>();
}
