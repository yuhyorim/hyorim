package com.hk.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.hk.board.dtos.BoardDto;

@Mapper
public interface BoardMapper {

    // 글 목록
    List<BoardDto> getAllList();

    // 글 상세 조회
    BoardDto getBoard(int board_seq);

    // 글 추가
    boolean insertBoard(BoardDto dto);

    // 글 수정
    boolean updateBoard(BoardDto dto);

    // 글 삭제
    boolean mulDel(String[] seqs);

    // 예약 추가
    boolean insertReservation(@Param("boardSeq") int boardSeq, @Param("userId") String userId);

    // 예약자 수 조회
    int getReservationCount(int boardSeq);

    // 사용자가 예약한 게시글 목록 조회 (마이페이지에서 사용)
    List<BoardDto> getReservedBoardsByUser(String userId);
    
    // 예약자 수 업데이트
    void updateReservationCount(@Param("boardSeq") int boardSeq, @Param("reservationCount") int reservationCount);

}








