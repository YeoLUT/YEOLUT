package CvLut.MediaProject.domain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long userIdx;
    @NotBlank
    @Size(min = 2, max = 4)
    @Column(name= "name", nullable = false)
    private String name;
    @NotBlank
    @Column(name = "email", nullable = false)
    @Email()
    private String email;
    @NotBlank
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "status")

    private char status;
//    @OneToMany(mappedBy = "user")
//    private List<Board> boards = new ArrayList<>();
//    @OneToMany(mappedBy = "user")
//    private List<UserProfileImage> userProfileImages = new ArrayList<>();
//    @OneToMany(mappedBy = "user")
//    private List<BoardLike> boardLikes = new ArrayList<>();
//    @OneToMany(mappedBy = "user")
//    private List<BoardScrap> boardScraps = new ArrayList<>();

}
