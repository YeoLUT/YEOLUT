package CvLut.MediaProject.Domain;

import javax.persistence.*;

@Entity
public class UserProfileImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileImageIdx;
    @ManyToOne @JoinColumn(name="userIdx")
    private User user;
    @ManyToOne @JoinColumn(name = "profileImageIdx")
    private  ProfileImage profileImage;

}
