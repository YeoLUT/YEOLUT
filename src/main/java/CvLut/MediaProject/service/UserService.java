package CvLut.MediaProject.service;

import static CvLut.MediaProject.common.ErrorCode.*;

import CvLut.MediaProject.Domain.ProfileImage;
import CvLut.MediaProject.Domain.User;
import CvLut.MediaProject.Domain.UserProfileImage;
import CvLut.MediaProject.Dto.UserDto;
import CvLut.MediaProject.repository.ProfileImageRepository;
import CvLut.MediaProject.repository.UserProfileImageRepository;
import CvLut.MediaProject.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
