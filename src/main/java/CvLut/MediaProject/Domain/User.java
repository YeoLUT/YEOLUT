package CvLut.MediaProject.Domain;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
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
    @Column(name = "status", nullable = false)
    private char status;
    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<UserProfileImage> userProfileImages = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<BoardLike> boardLikes = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<BoardScrap> boardScraps = new ArrayList<>();

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Builder.Default
//    private List<String> roles = new ArrayList<>();
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return this.roles.stream()
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
