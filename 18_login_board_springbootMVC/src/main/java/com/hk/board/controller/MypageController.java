package com.hk.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hk.board.dtos.BoardDto;
import com.hk.board.service.ReservationService;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/mypage")
public class MypageController {
	
	 @Autowired
	    private ReservationService reservationService;

	    @GetMapping("/myReservations")
	    public String getMyReservations(HttpSession session, Model model) {
	        // 세션에서 로그인한 사용자 정보 확인
	        String userId = (String) session.getAttribute("userId");

	        // 예약한 게시글 목록을 가져오기
	        List<BoardDto> reservedBoards = reservationService.getUserReservations(userId);

	        // 마이페이지로 이동하면서 예약된 게시글 목록과 예약자 수를 전달
	        model.addAttribute("reservedBoards", reservedBoards);
	        return "mypage/mypage";
	    }

}
