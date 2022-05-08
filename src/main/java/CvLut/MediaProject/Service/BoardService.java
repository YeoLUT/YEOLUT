package CvLut.MediaProject.Service;

import CvLut.MediaProject.Dto.BoardDetailResponseDto;
import CvLut.MediaProject.Dto.BoardDto;
import CvLut.MediaProject.Dto.FeatureDto;
import CvLut.MediaProject.Repository.Board.BoardQueryRepository;
import CvLut.MediaProject.Repository.BoardFeatureRepository;
import CvLut.MediaProject.Repository.Board.BoardRepository;
import CvLut.MediaProject.Repository.FeatureQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;
    private final FeatureQueryRepository featureQueryRepository;
//    public List<?> mainBoardList(Pageable pageable) {
//        List<Object[]> boardList = boardRepository.getMainPageBoardList(pageable);
//        BoardListDto boardListDto = null;
//        for (Object[] row : boardList) {
//
//            boardListDto = (BoardListDto) row[0];
//            System.out.println(boardListDto);
//
//        }
//        //List<BoardListDto[]> boardListDtos = new BoardListDto(boardList);
//        return (List<?>) boardListDto;
//    }

    public BoardDto.BoardDetailRes boardDetail(Long boardIdx){
        BoardDto.BoardDetailDto boardDetailDto = boardQueryRepository.BoardInfo(boardIdx).get(0);
        List<FeatureDto.DefaultFeature> boardFeatureList = featureQueryRepository.getBoardFeatureList(boardIdx);

        return BoardDto.BoardDetailRes.builder()
                .boardIdx(boardDetailDto.getBordIdx())
                .title(boardDetailDto.getTitle())
                .downloadCount(boardDetailDto.getDownloadCount())
                .createdAt(boardDetailDto.getCreatedAt())
                .description(boardDetailDto.getDescription())
                .source(boardDetailDto.getSource())
                .userIdx(boardDetailDto.getUserIdx()). name(boardDetailDto.getName())
                .lutUrl(boardDetailDto.getLutUrl()). profileImageUrl(boardDetailDto.getProfileImageUrl())
                .likeCount(boardDetailDto.getLikeCount()).featureList(boardFeatureList).build();
    }
}
