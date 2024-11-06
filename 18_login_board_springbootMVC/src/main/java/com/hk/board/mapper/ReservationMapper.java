package com.hk.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.hk.board.dtos.BoardDto;
import com.hk.board.dtos.ReservationDto;

@Mapper
public interface ReservationMapper {

    // 예약 추가
    boolean insertReservation(@Param("boardSeq") int boardSeq, @Param("userId") String userId);

    // 특정 게시글에 대한 예약자 수 조회
    int getReservationCount(int boardSeq);

    // 특정 사용자가 예약한 게시글 목록 조회
    List<BoardDto> getReservedBoardsByUser(String userId);
}

