package CvLut.MediaProject.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class ProfileImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileImageIdx;

    @Column
    private String profileImageUrl;

    @OneToMany(mappedBy = "profileImage")
    private List<UserProfileImage> userProfileImages = new ArrayList<>();
}
