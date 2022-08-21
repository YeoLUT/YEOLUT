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
public class ProfileImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileImageIdx;

    @Column( nullable = false)
    private String profileImageUrl;

//    @OneToMany(mappedBy = "profileImage")
//    private List<UserProfileImage> userProfileImages = new ArrayList<>();
}
