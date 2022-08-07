package CvLut.MediaProject.Dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSignUpReqDto{
        @NotBlank
        @Size(min = 2, max = 4)
        private String name;
        @NotBlank
        @Email
        private String email;
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n" ,
        message = "'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용합니다." )
        private String password;
        @NotBlank
        private Long profileImageIdx;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSingInReqDto{
        @NotBlank
        @Email
        private String email;
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$\n" ,
                message = "'숫자', '문자', '특수문자' 무조건 1개 이상, 비밀번호 '최소 8자에서 최대 16자'까지 허용합니다." )
        private String password;
    }

    @Getter
    @Setter
    public static class UserRecommendedListDto {
        @QueryProjection
        public UserRecommendedListDto(Long userIdx, String name, String profileImageUrl, Long downloadCount, Long likeCount) {
            this.userIdx = userIdx;
            this.name = name;
            this.profileImageUrl = profileImageUrl;
            this.downloadCount = downloadCount;
            this.likeCount = likeCount;
        }

        Long userIdx;
        String name;
        String profileImageUrl;
        Long downloadCount;
        Long likeCount;

    }

}
