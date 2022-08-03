package CvLut.MediaProject.Domain;

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
public class UserProfileImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileImageIdx;
    @ManyToOne @JoinColumn(name="userIdx")
    private User user;
    @ManyToOne @JoinColumn(name = "profileImageIdx")
    private  ProfileImage profileImage;

}
