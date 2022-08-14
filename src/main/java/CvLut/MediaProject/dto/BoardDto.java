package CvLut.MediaProject.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

public class BoardDto {
    @Getter
    @Setter
    public static class BoardDetailDto{
        @QueryProjection
        public BoardDetailDto(Long boardIdx, String title, Long downloadCount, Timestamp createdAt,
                              String description, String source, Long userIdx, String name,
                              String lutUrl, String profileImageUrl, Long likeCount) {
            this.bordIdx = boardIdx;
            this.title = title;
            this.downloadCount = downloadCount;
            this.createdAt = createdAt;
            this.description = description;
            this.source = source;
            this.userIdx = userIdx;
            this.name = name;
            this.lutUrl = lutUrl;
            this.profileImageUrl = profileImageUrl;
            this.likeCount = likeCount;
        }
        private Long bordIdx;
        private String title;
        private Long downloadCount;
        private Timestamp createdAt;
        private String description;
        private String source;
        private Long userIdx;
        private String name;
        private String lutUrl;
        private String profileImageUrl;
        private Long likeCount;


    }
    @Getter
    @Setter
    public static class BoardListDto{
        @QueryProjection
        public BoardListDto(Long boardIdx, String title, Long downloadCount, Timestamp createdAt,
                            Long userIdx, String name, String lutUrl, String profileImageUrl,
                            Long likeCount) {
            this.boardIdx = boardIdx;
            this.title = title;
            this.downloadCount = downloadCount;
            this.createdAt = createdAt;
            this.userIdx = userIdx;
            this.name = name;
            this.lutUrl = lutUrl;
            this.profileImageUrl = profileImageUrl;
            this.likeCount = likeCount;
        }

        private Long boardIdx;
        private String title;
        private Long downloadCount;
        private Timestamp createdAt;
        private Long userIdx;
        private String name;
        private String lutUrl;
        private String profileImageUrl;
        private Long likeCount;
    }
    @Getter
    @Setter
    public static class BoardDetailResDto extends BoardDetailDto{
        private List<FeatureDto.DefaultFeature> featureList;
        @Builder
        public BoardDetailResDto(Long boardIdx, String title, Long downloadCount, Timestamp createdAt,
                                 String description, String source, Long userIdx, String name,
                                 String lutUrl, String profileImageUrl, Long likeCount, List<FeatureDto.DefaultFeature> featureList){
            super( boardIdx,  title,  downloadCount,  createdAt,
                     description,  source,  userIdx,  name,
                     lutUrl,  profileImageUrl,  likeCount);
            this.featureList = featureList;
        }
    }
//    @Getter
//    @Setter
//    @NoArgsConstructor
//    @AllArgsConstructor
//    public static class BoardDetailReq {
//        private List<Long> featureIdxList;
//        private String search;
//    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UploadBoardReqDto {
        private String title;
        private String description;
        private String source;
        private String lutFileUrl;
        private String originImageUrl;
        private String lutImageUrl;
        private List<Long> featureIdxList;
        private String search;
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @Builder
    public static class S3UploadFileResDto {
        public S3UploadFileResDto(String url) {
            this.url = url;
        }
        public static S3UploadFileResDto url(String url){
            return S3UploadFileResDto.builder()
                    .url(url)
                    .build();
        }
        private String url;
    }
    @Getter
    @Setter
    public static class UserBoardList{
        private Long boardIdx;

        @QueryProjection
        public UserBoardList(Long boardIdx, String title, String lutImage) {
            this.boardIdx = boardIdx;
            this.title = title;
            this.lutImage = lutImage;
        }

        private String title;
        private String lutImage;

    }

//    public static class uploadLutFileUrlRes{
//
//    }
//    public static class uploadLutImageUrlRes{
//
//    }
//    public static class uploadOriginImageUrlRes{
//
//    }
}
