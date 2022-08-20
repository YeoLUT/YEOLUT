package CvLut.MediaProject.service;

import static org.mockito.Mockito.*;

import CvLut.MediaProject.domain.ProfileImage;
import CvLut.MediaProject.domain.User;
import CvLut.MediaProject.domain.UserProfileImage;
import CvLut.MediaProject.dto.UserDto;
import CvLut.MediaProject.repository.ProfileImageRepository;
import CvLut.MediaProject.repository.UserProfileImageRepository;
import CvLut.MediaProject.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @InjectMocks
    private UserService userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserProfileImageRepository userProfileImageRepository;
    @Mock
    private ProfileImageRepository profileImageRepository;
    @Mock
    private PasswordEncoder passwordEncoder;


    private final User testUser = User.builder().name("테스트").email("asd@assda.com").status('N').password("asd@dweq!").build();
    private final ProfileImage testProfileImage = ProfileImage.builder().profileImageUrl("TestURL").build();

    @Test
    @DisplayName("유저 회원가입 테스트")
    void testSignUp() {
        UserDto.UserSignUpReqDto userSignUpReqDto = UserDto.UserSignUpReqDto.builder().name(testUser.getName()).email(testUser.getEmail())
                .password(testUser.getPassword()).profileImageIdx(1L).build();
        // given
        when(userRepository.existsUserByEmailAndStatus(userSignUpReqDto.getEmail(), 'N')).thenReturn(false);
        when(passwordEncoder.encode(userSignUpReqDto.getPassword())).thenReturn("password pass");


        User user = User.builder().name(userSignUpReqDto.getName()).email(userSignUpReqDto.getEmail()).password("password pass").status('N')
                .build();
        ProfileImage profileImage = profileImageRepository.getById(userSignUpReqDto.getProfileImageIdx());
        when(profileImageRepository.getById(userSignUpReqDto.getProfileImageIdx())).thenReturn(testProfileImage);
        when(userRepository.save(any())).thenReturn(testUser);

        UserProfileImage userProfileImage = UserProfileImage.builder().profileImage(profileImage).user(testUser).build();
        when(userProfileImageRepository.save(any())).thenReturn(userProfileImage);

        // when
        User savedUser = userService.userSingUp(userSignUpReqDto);
        //System.out.println(savedUser.getName());
        // then
        Assertions.assertThat(savedUser.getName()).isEqualTo(testUser.getName());
        Assertions.assertThat(savedUser.getEmail()).isEqualTo(testUser.getEmail());

    }
}