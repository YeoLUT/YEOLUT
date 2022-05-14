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
public class ProfileImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileImageIdx;

    @Column
    private String profileImageUrl;

    @OneToMany(mappedBy = "profileImage")
    private List<UserProfileImage> userProfileImages = new ArrayList<>();
}
