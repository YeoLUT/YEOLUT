package CvLut.MediaProject.repository.user;

import CvLut.MediaProject.domain.*;
import CvLut.MediaProject.QueryDslTestConfig;
import CvLut.MediaProject.config.SpringSecurityConfig;
import CvLut.MediaProject.repository.ProfileImageRepository;
import CvLut.MediaProject.repository.UserProfileImageRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@Import({QueryDslTestConfig.class, SpringSecurityConfig.class})
class UserQueryRepositoryTest {
    // private SpringSecurityConfig springSecurityConfig = new SpringSecurityConfig();
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileImageRepository profileImageRepository;
    @Autowired
    UserProfileImageRepository userProfileImageRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp(){
        // datajpatest에 있는 transactional로 인해 첫번째 테스트 메소드를 제외하고 null값이 들어가는 문제 발생 -> 인덱스가 초기화될때마다 증가해서 그럼
        // given
        User user1 = User.builder().name("김일").email("kyi9592@ajou.ac.kr").password(passwordEncoder.encode("asdd@sad")).status('N').build();
        User user2 = User.builder().name("김이").email("kyi9592@naver.com").password(passwordEncoder.encode("asdd@sad")).status('N').build();

        testEntityManager.persist(user1);
        testEntityManager.persist(user2);


    }
    @AfterEach
    void setDown(){
        testEntityManager.clear();
    }
    @Test
    @DisplayName("이미 존재하는 유저 저장시 예외 발생")
    void testUserSaveException(){
        // given
        User userA = User.builder().name("김이").email("kyi9592@ajou.ac.kr").password(passwordEncoder.encode("asdd@sad")).status('N').build();

        // then
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, ()->{
            if(userRepository.existsUserByEmailAndStatus(userA.getEmail(), 'N')){
                throw new RuntimeException();
            }
        });
    }

    @Test
    @DisplayName("유저 DB 저장")
    void testUserSave(){
        // given
        User userB = User.builder().name("김삼").email("kyi9592@google.com").password(passwordEncoder.encode("asdd@sad")).status('N').build();

        // when
        User savedUser = userRepository.save(userB);
        // then
        Assertions.assertThat(savedUser.getName()).isEqualTo(userB.getName());
    }

    @Test
    @DisplayName("유저 프로필 이미지 저장")
    void testUserProfileImageSave(){
        // given
        ProfileImage profileImage = ProfileImage.builder().profileImageUrl("http://s3.asd.com").build();
        profileImageRepository.save(profileImage);
        UserProfileImage userProfileImage = UserProfileImage.builder().user(userRepository.findAll().get(0))
                .profileImage(profileImageRepository.getById(1L)).build();


        // when
        UserProfileImage userProfileImage1 =  userProfileImageRepository.save(userProfileImage);

        // then
        Assertions.assertThat(userProfileImageRepository.getById(1L).getUser().getName()).isEqualTo(userRepository.findAll().get(0).getName());
        Assertions.assertThat(userProfileImageRepository.getById(1L).getProfileImage().getProfileImageUrl()).isEqualTo(profileImage.getProfileImageUrl());
    }


    @Test
    @DisplayName("추천 유저 조회")
    void testRecommendedUser(){
        // given
        Pageable pageable = PageRequest.of(0, 10);

        // when
        Board board = Board.builder().title("테스트 게시글").description("게시글 내용").downloadCount(50L).user(userRepository.getById(2L)).build();

        // then
        Assertions.assertThat(userRepository.recommendedUserList(pageable).getContent().get(0).getName()).isEqualTo("김이");
    }

}