package com.hk.board.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/map")
public class MapController {
   
   public String getFullRegionName(String region1) {
       Map<String, String> regionMap = new HashMap<>();
       regionMap.put("서울", "서울특별시");
       regionMap.put("부산", "부산광역시");
       regionMap.put("대구", "대구광역시");
       regionMap.put("인천", "인천광역시");
       regionMap.put("광주", "광주광역시");
       regionMap.put("대전", "대전광역시");
       regionMap.put("울산", "울산광역시");
       regionMap.put("세종", "세종특별자치시");
       regionMap.put("경기", "경기도");
       regionMap.put("강원", "강원도");
       regionMap.put("충북", "충청북도");
       regionMap.put("충남", "충청남도");
       regionMap.put("전북", "전라북도");
       regionMap.put("전남", "전라남도");
       regionMap.put("경북", "경상북도");
       regionMap.put("경남", "경상남도");
       regionMap.put("제주", "제주특별자치도");

       return regionMap.getOrDefault(region1, region1);
   }
   
    @PostMapping("/region")
       public ResponseEntity<Map<String, String>> handleRegionRequest(@RequestBody Map<String, String> request) {
           String region1 = request.get("region1");
           String region2 = request.get("region2");

           // 비즈니스 로직 실행
           String fullRegion1 = getFullRegionName(region1);

           // 응답 데이터 구성
           Map<String, String> response = new HashMap<>();
           response.put("region1", fullRegion1);
           response.put("region2", region2);

           return ResponseEntity.ok(response);
       }
    
    
   
}

