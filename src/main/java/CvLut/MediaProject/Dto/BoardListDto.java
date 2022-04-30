package CvLut.MediaProject.Dto;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;


public class BoardListDto {
    private BigInteger board_idx;
    private String title;
    private Long download_count;
    private String created_at;
    private BigInteger user_idx;
    private String name;
    private String lut_url;
    private String profile_image_url;
    private String likeCount;


    public BoardListDto(BigInteger board_idx, String title, Long download_count, String created_at, BigInteger user_idx, String name, String lut_url, String profile_image_url, String likeCount) {
        this.board_idx = board_idx;
        this.title = title;
        this.download_count = download_count;
        this.created_at = created_at;
        this.user_idx = user_idx;
        this.name = name;
        this.lut_url = lut_url;
        this.profile_image_url = profile_image_url;
        this.likeCount = likeCount;
    }


}
