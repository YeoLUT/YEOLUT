package CvLut.MediaProject.Service;

import CvLut.MediaProject.Domain.ProfileImage;
import CvLut.MediaProject.Domain.User;
import CvLut.MediaProject.Domain.UserProfileImage;
import CvLut.MediaProject.Dto.UserDto;
import CvLut.MediaProject.Repository.ProfileImageRepository;
import CvLut.MediaProject.Repository.UserProfileImageRepository;
import CvLut.MediaProject.Repository.UserRepository;
import com.amazonaws.services.ec2.model.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserProfileImageRepository userProfileImageRepository;
    private final ProfileImageRepository profileImageRepository;
    private final PasswordEncoder passwordEncoder;
    @Transactional
    public void userSingUp(UserDto.UserSignUpReqDto userSignUpReqDto){
        String encodedPassword = passwordEncoder.encode(userSignUpReqDto.getPassword());
        User user = User.builder().name(userSignUpReqDto.getName()).email(userSignUpReqDto.getEmail()).password(encodedPassword)
                .build();
        ProfileImage profileImage = profileImageRepository.getById(userSignUpReqDto.getProfileImageIdx());
        User saveUser = userRepository.save(user);
        UserProfileImage userProfileImage = UserProfileImage.builder().profileImage(profileImage).user(saveUser).build();
        userProfileImageRepository.save(userProfileImage);
    }
}
