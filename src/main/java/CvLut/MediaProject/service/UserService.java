package CvLut.MediaProject.service;

import CvLut.MediaProject.domain.ProfileImage;
import CvLut.MediaProject.domain.User;
import CvLut.MediaProject.domain.UserProfileImage;
import CvLut.MediaProject.dto.UserDto;
import CvLut.MediaProject.repository.ProfileImageRepository;
import CvLut.MediaProject.repository.UserProfileImageRepository;
import CvLut.MediaProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class UserService {
    private final static char SIGNUP_STATUS = 'N';
    private final UserRepository userRepository;
    private final UserProfileImageRepository userProfileImageRepository;
    private final ProfileImageRepository profileImageRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public User userSingUp(UserDto.UserSignUpReqDto userSignUpReqDto){
        if(userRepository.existsUserByEmailAndStatus(userSignUpReqDto.getEmail(), 'N')){
            throw new RuntimeException();
        }

        String encodedPassword = passwordEncoder.encode(userSignUpReqDto.getPassword());
        User user = User.builder().name(userSignUpReqDto.getName()).email(userSignUpReqDto.getEmail()).password(encodedPassword).status(SIGNUP_STATUS)
                .build();
        ProfileImage profileImage = profileImageRepository.getById(userSignUpReqDto.getProfileImageIdx());
        User saveUser = userRepository.save(user);
        UserProfileImage userProfileImage = UserProfileImage.builder().profileImage(profileImage).user(saveUser).build();
        userProfileImageRepository.save(userProfileImage);
        return saveUser;
    }
}
