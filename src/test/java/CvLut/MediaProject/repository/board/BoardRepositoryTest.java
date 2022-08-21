package CvLut.MediaProject.repository.board;

import CvLut.MediaProject.QueryDslTestConfig;
import CvLut.MediaProject.domain.*;
import CvLut.MediaProject.dto.BoardDto;
import CvLut.MediaProject.dto.FeatureDto;
import CvLut.MediaProject.repository.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Import(QueryDslTestConfig.class)
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp(){
        User user = testEntityManager.persist(User.builder().name("아이디").email("kyi9592@ajou.ac.kr").password("testtest123@").build());
        ProfileImage profileImage = testEntityManager.persist(ProfileImage.builder().profileImageUrl("http://xxxx.com").build());
        testEntityManager.persist(UserProfileImage.builder().user(user).profileImage(profileImage).build());
        for (int i = 1; i < 31; i++) {
            Board board = testEntityManager.persist(Board.builder().title(i + "번째 제목").downloadCount(Long.valueOf(i)).description(i + "번째 게시글").user(user)
                    .build());

            for (int j = 1; j < 6; j++) {
                Feature feature = testEntityManager.persist(Feature.builder().featureName("특성" + i * j).build());
                BoardFeature boardFeature = BoardFeature.builder().board(board).feature(feature).build();
                testEntityManager.persist(boardFeature);
            }

        }
    }

    @Test
    @DisplayName("특정 게시글 정보 조회")
    void testGetBoardInfo(){
        // when
        List<BoardDto.BoardDetailDto> boardDetailDtoList = boardRepository.boardInfo(boardRepository.findAll().get(0).getBoardIdx());

        //then
        Assertions.assertThat(boardDetailDtoList.get(0).getDescription()).isEqualTo("1번째 게시글");

    }

    @Test
    @DisplayName("게시글 목록 조회")
    void testGetBoardList(){
        // given
        Pageable pageable1 = PageRequest.of(0, 10);
        Pageable pageable2 = PageRequest.of(0, 30);
        List<Long> featureList = new ArrayList<>();

        // when
        Page<BoardDto.BoardListDto> boardListDtoList1 = boardRepository.boardSearch(pageable1, featureList, null);
        Page<BoardDto.BoardListDto> boardListDtoList2 = boardRepository.boardSearch(pageable2, featureList, null);

        // then
        Assertions.assertThat(boardListDtoList1.getSize()).isEqualTo(10);
        Assertions.assertThat(boardListDtoList2.getSize()).isEqualTo(30);

    }

    @Test
    @DisplayName("특정 유저 작성 게시글 조회")
    void testGetUserBoardList(){
        // when
        List<BoardDto.UserBoardList> userBoardLists = boardRepository.userBoardList(userRepository.findAll().get(0).getUserIdx());

        // then
        Assertions.assertThat(userBoardLists.size()).isEqualTo(30);
    }

    @Test
    @DisplayName("게시글 특성 조회")
    void testGetBoardFeatureList(){

        // when
        List<FeatureDto.DefaultFeature> FeatureList = boardRepository.boardFeatureList(boardRepository.findAll().get(1).getBoardIdx());

        // then
        Assertions.assertThat(FeatureList.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("좋아요한 게시글 조회")
    void testGetBoardLikeList(){

        // given
        User testUser = testEntityManager.persist(User.builder().name("유저1").email("asd@naver.com").password("asd@#sdd").build());
        int likeCount = 5;
        for (int i = 0; i < likeCount; i++) {
            testEntityManager.persist(BoardLike.builder().isLike(1).board(boardRepository.findAll().get(i)).user(testUser).build());
        }


        // when
        List<BoardDto.UserBoardList> userBoardLists = boardRepository.userLikeList(testUser.getUserIdx());

        // then
        Assertions.assertThat(userBoardLists.size()).isEqualTo(likeCount);
    }

}