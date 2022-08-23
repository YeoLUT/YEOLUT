# YeoLut-BE

**크리에이터를 위한 무료 LUT공유 플랫폼 [YeoLUT](https://github.com/YeoLUT) 리팩토링  :+1:**

:orange_book::orange_book::orange_book: 진행중 :orange_book::orange_book::orange_book:

---
## 목적

- 전체적인 리팩토링
  - 중복되는 역할의 코드 제거 및 레거시 코드 제거
  - 인터페이스를 중심으로한 OOP설계
    - SOLID 원칙에 위배되는 코드 수정
  - 일부 Native Query를 QueryDSL로 변경
  - 테스트 코드 작성
  - 리팩토링을 통한 스프링 컨테이너와 스프링 빈의 올바른 이해
  - 추가적인 미구현 API구현
  - 응답
    - API 응답
    - 에러처리
  - 스프링 IOC위반하는 객체 수정
  - 로깅 프레임워크 적용 logback
  - 유효성 검사 추가
  - 
---
## 1차 리팩토링
디자인 패턴 적용보다는 기본적인 스프링 관련 기술들을 이해하고 적용하는데에 집중

---

### Domain
- 기존에 일괄적으로 지연로딩이 적용되어 있는 부분
  - 비즈니스 로직에 따른 엔티티별 즉시로딩, 지연로딩적용
- 모든 엔티티에 적용되어 있는 Setter
  - 변경되지 않는 인스턴스에 대해서도 setter로 접근이 가능하기 때문에 일관성, 안정성 보장을 위해 Setter 제거
- 양방향 단방향 관계
  - 현재 모든 관계가 양방향으로 되어있는데 단방향을 기본으로 하고 양방향이 쓰일 곳이 많은 엔티티들만 양방향 관계를 맺는다.
    - 양방향 관계의 경우 
    - 예를 들어, 게시글과 게시글 좋아요는 게시글을 호출할 때 왠만하면 게시글 좋아요도 같이 호출할 일이 많을 것이다.
    - 따라서 이러한 엔티티들을 구분하여 관계를 다시 정한다.
#### 주의사항
- Builder는 일부 필드 혹은 파라미터를 갖지 않는 생성자가 있으면 오류를 발생시킨다. AllArgsConstructor와 함께 이용
- 양방향 연관관계의 경우  연관관계 주인을 고려하고 주인이 아닌쪽은 읽기만 가능하다.

---
### Repository
- Native Query -> QueryDSL
  - Native Query는 특정 데이터베이스에 의존하는 SQL을 작성해야한다는 단점이 있어 특정 데이터베이스에서만 동작하는
  SQL을 작성해야하는 것이 아니라면 코드 기반이면서 단순하고 이식성이 좋은 QueryDSL이 좋다고 판단되어
  수정하였다.   
  페이징 처리를 위해 count를 세는 쿼리를 따로날려 코드가 길어졌다.
```swift
// Before
@Query(value = "SELECT u.user_idx as userIdx, name, profile_image_url as profileImgeUrl, sum(download_count) as downloadCount, count(is_like) as likeCount\n" +
            "FROM user u\n" +
            "left join user_profile_image upl on upl.user_idx = u.user_idx\n" +
            "left join profile_image pi on pi.profile_image_idx = upl.profile_image_idx\n" +
            "left join board b on b.user_idx = u.user_idx\n" +
            "left join board_like bl on bl.board_idx = b.board_idx and is_like = 1\n" +
            "group by b.user_idx\n" +
            "order by sum(download_count) desc", nativeQuery = true)
    Page<UserRecommendedListDto[]> recommendedUserList(Pageable pageable);
// After
public Page<UserDto.UserRecommendedListDto> recommendedUserList(Pageable pageable){
        List<UserDto.UserRecommendedListDto> results = queryFactory.select(new QUserDto_UserRecommendedListDto(user.userIdx, user.name, profileImage.profileImageUrl, board.downloadCount.sum(), boardLike.isLike.count()))
                .from(user)
                .leftJoin(user.userProfileImages, userProfileImage)
                .leftJoin(userProfileImage.profileImage, profileImage)
                .leftJoin(user.boards, board)
                .leftJoin(board.boardLikes, boardLike)
                .groupBy(board.user)
                .orderBy(board.downloadCount.sum().desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


        JPQLQuery<Long> count = queryFactory.select(user.userIdx.count())
                .from(user)
                .leftJoin(user.userProfileImages, userProfileImage)
                .leftJoin(userProfileImage.profileImage, profileImage)
                .leftJoin(user.boards, board)
                .leftJoin(board.boardLikes, boardLike)
                .groupBy(board.user);
        return PageableExecutionUtils.getPage(results, pageable , () -> count.fetchOne());
    }
```
- 상속, 구현 없는 Repository 적용
  - 기존 Repository들은 Spring Data JPA를 상속받은 인터페이스와 QueryDSL을 이용한 클래스로 이루어졌다. Service에서는 Repository역할에 따로 접근하는 것이 문제이기에 CustomRepository 인터페이스를 만들고 하나의 Repository를 이용한다.
  - Spring Data JPA가 사용되지 않는 도메인은 상속, 구현이 없는 오로지 QueryDSL을 이용하여 Repository를 이용하는 것으로 변경    
  -> 상황에 따른 적용 
---

### 예외처리

- 기존 BaseResponse를 ResponseEntity로 감싼다.   
- 빌더 패턴 적용  
- 기존에 상태 코드를 Body에 넣어 보냈는데 헤더에 있는 상태 코드를 안쓰게됨으로 헤더로 변경

- ControllerAdvice 모든 Controller 예외처리
- ExceptionHandler 특정 Controller 예외처리
- ControllerAdvice로 모든 컨트롤러에서 발생할 예외를 정의,
- ExceptionHandler를 통해 발생하는 예외 마다 처리할 메소드 정의

---

### 테스트 코드

단위 테스트를 시작으로 통합 테스트까지 구현 (통합 테스트 미구현)  

#### 단위 테스트

메소드 단위로 필요한 최소의 부분만 사용하여 테스트한다. 사용하고 있는 DB로 테스트를 할 시에 문제가 발생할 수 있으니 인메모리 DB(H2)를 사용하는 것으로 변경

- Repository Layer
  - @DataJpaTest
    - transactional을 포함하고 있어 실제 쿼리를 날리지 않고, 인메모리 DB(H2)를 사용한다. @AutoConfigureTestDatabase를 이용하여 설정 DB사용가능
    - 별도의 스프링 빈을 등록하지 않고, 레포지토리와 TestEntityManager 정도만 등록하여 테스트한다.
    - 테스트에 필요한 엔티티를 빌더패턴을 이용하여 생성하여 테스트 진행
- Service Layer 
  - @ExtendWith(MockitoExtension.class)
    - MockitoExtension을 추가하여 @Mock @InjectMocks과 같은 가짜 객체를 주입하여 테스트에 이용한다.
    - 임의의 객체를 만들고 Mockito의 정적 메소드를 사용하여 의존성이 필요한 결과값들을 설정한다.
    - assertThat, verify와 같은 메소드로 결과 값을 테스트

#### 유효성 검사

기존에 dto에서 유효성 검사를 하고있으나 다음과 같은 이유로 서비스 계층과 도메인에 추가하고자 한다.
- 컨트롤러에서 서비스로 정상값이 전달 될 것이라는 가정으로 코드를 작성하는 것은 좋지않다.
- 다른 개발자와 협업 시 문제발생 가능성
- 각 레이어는 유효성 검사의 책임을 갖는다.