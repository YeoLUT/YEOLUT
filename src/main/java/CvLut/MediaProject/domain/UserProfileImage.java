package CvLut.MediaProject.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserProfileImage {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userProfileImageIdx;
    @ManyToOne @JoinColumn(name="userIdx")
    private User user;
    @ManyToOne @JoinColumn(name = "profileImageIdx")
    private  ProfileImage profileImage;

}
