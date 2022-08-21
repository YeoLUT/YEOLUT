package CvLut.MediaProject.repository.board;

import CvLut.MediaProject.dto.BoardDto;
import CvLut.MediaProject.dto.FeatureDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardCustomRepository {
    public Page<BoardDto.BoardListDto> boardSearch(Pageable pageable, List<Long> featureIdxList, String search);
    public List<BoardDto.BoardDetailDto> boardInfo(Long boardIdx);
    public List<BoardDto.UserBoardList> userBoardList(Long userIdx);
    public List<BoardDto.UserBoardList> userLikeList(Long userIdx);

    public List<FeatureDto.DefaultFeature> boardFeatureList(Long boardIdx);
}
