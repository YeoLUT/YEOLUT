package CvLut.MediaProject.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSignUpReqDto{
        private String name;
        private String email;
        private String password;
        private String profileImageUrl;
    }
}
