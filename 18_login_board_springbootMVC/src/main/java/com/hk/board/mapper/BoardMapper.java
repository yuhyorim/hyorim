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

    // 좋아요 수 조회
    int getLikeCount(int boardSeq);

    // 좋아요 수 증가
    void incrementLikeCount(int boardSeq);
}








