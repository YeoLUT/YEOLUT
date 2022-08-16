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
    @ManyToOne
    private User user;
    @ManyToOne
    private  ProfileImage profileImage;

}
