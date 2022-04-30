package CvLut.MediaProject.Service;

import CvLut.MediaProject.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

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
}
