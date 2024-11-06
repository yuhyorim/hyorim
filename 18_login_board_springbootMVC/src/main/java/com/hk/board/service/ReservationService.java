import org.springframework.stereotype.Service;

import com.hk.board.dtos.BoardDto;
import com.hk.board.dtos.ReservationDto;
import com.hk.board.mapper.BoardMapper;
import com.hk.board.mapper.ReservationMapper;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private ReservationMapper reservationMapper;

    // 게시글 목록 조회
    public List<BoardDto> getAllBoards() {
        return boardMapper.getAllList();
    }

    // 게시글 예약
    public void reserveBoard(int boardSeq, String userId) {
        // 예약 추가
        boolean success = reservationMapper.insertReservation(boardSeq, userId);

        if (success) {
            // 예약이 성공하면 예약자 수를 증가
            int reservationCount = boardMapper.getReservationCount(boardSeq);
            boardMapper.updateReservationCount(boardSeq, reservationCount);
        }
    }

    // 사용자가 예약한 게시글 목록 조회 (마이페이지에서 사용)
    public List<BoardDto> getUserReservations(String userId) {
        return reservationMapper.getReservedBoardsByUser(userId);
    }
}
