package CvLut.MediaProject.Domain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long userIdx;
    @Column(name= "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false)
    @Email()
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "isDeleted", nullable = false)
    private char isDeleted;
    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserProfileImage> userProfileImages = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<BoardLike> boardLikes = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<BoardScrap> boardScraps = new ArrayList<>();
}
