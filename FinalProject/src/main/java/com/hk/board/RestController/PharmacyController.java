package com.hk.board.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hk.board.Dto.PlaceDto;

import java.util.List;

import javax.servlet.http.HttpSession;

@RestController
public class PharmacyController {

    @PostMapping("/map/compare")
    public ResponseEntity<PlaceDto> compareMarker(@RequestBody PlaceDto clickedPlace, HttpSession session) {
        List<PlaceDto> pharmacyList = (List<PlaceDto>) session.getAttribute("pharmacyList");
        
        if (pharmacyList != null) {
            for (PlaceDto pharmacy : pharmacyList) {
                if (clickedPlace.getDutyName().equals(pharmacy.getDutyName())) {
                    return ResponseEntity.ok(pharmacy); // 약국 정보 반환
                }
            }
        }
        return ResponseEntity.notFound().build(); // 일치하는 약국이 없을 경우
    }
}