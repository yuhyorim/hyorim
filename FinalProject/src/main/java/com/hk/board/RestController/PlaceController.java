package com.hk.board.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hk.board.Dto.PlaceDto;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/map")
public class PlaceController {
   
   
    
    @GetMapping("/med")
    @ResponseBody
    public ResponseEntity<List<PlaceDto>> callApi(HttpServletRequest request) throws IOException {
    	System.out.println("지도요청");
        String latitude = "37.525452"; // 예시 위도
        String longitude = "126.888868"; // 예시 경도

        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyLcinfoInqire");
        urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=w88bHZL8YU8L4yw8aLk%2BPZUGsE1aEfBfZb57Jp%2BAK2o5HBfjUiLRyPa6QQQf6jG7GPFizsl1OyALzlniJaSp4g%3D%3D");
        urlBuilder.append("&" + URLEncoder.encode("WGS84_LON", "UTF-8") + "=" + URLEncoder.encode(longitude, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("WGS84_LAT", "UTF-8") + "=" + URLEncoder.encode(latitude, "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=1");
        urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=50");
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader rd;
        StringBuilder sb = new StringBuilder();
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }

        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();

        // XML을 JSON으로 변환
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(sb.toString());

        // 데이터 추출하여 List<PlaceDto>로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        List<PlaceDto> placeList = objectMapper.readValue(
            jsonNode.get("body").get("items").get("item").toString(),
            new TypeReference<List<PlaceDto>>() {}
        );
        request.getSession().setAttribute("place", placeList);
        
        
//        List<PlaceDto> list= (List<PlaceDto>)request.getSession().getAttribute("place");
//        System.out.println(list.toString());

        
        return ResponseEntity.ok(placeList);
    }
   
	/*
	 * @PostMapping("/sPName") public ResponseEntity<String>
	 * receivePharmacyName(@RequestBody Map<String, String> request) { String
	 * dutyName = request.get("dutyName");
	 * System.out.println("Received Pharmacy Name: " + dutyName);
	 * 
	 * // 처리 로직 (예: 데이터베이스 저장 또는 추가 작업) // yourService.savePharmacyName(dutyName);
	 * 
	 * return ResponseEntity.ok("약국 이름 전송 성공: " + dutyName); }
	 */
    
//    //오퍼레이션 3
//    @GetMapping("/egypt")
//    @ResponseBody
//    public ResponseEntity<List<PlaceDto>> egypt(@RequestParam("stage1") String stage1, 
//                      @RequestParam("stage2") String stage2,
//                      HttpServletRequest request,
//                      Model model) {
//        try {
//           System.out.println(stage1+stage2);
//             // 서비스에서 API 데이터 호출
//             List<PlaceDto> responseList = egyptService.fetchApiData(stage1, stage2);
//             request.getSession().setAttribute("egypt", responseList);
//            /* Map<String,List<EgyptDto>> map=new HashMap<String, List<EgyptDto>>(); */
//            /* map.put("egypt", responseList); */
//             // 모델에 데이터 추가
//             model.addAttribute("list", responseList);
//             return ResponseEntity.ok(responseList);
//             
//         } catch (Exception e) {
//             e.printStackTrace();
//             model.addAttribute("error", "API 호출 중 오류 발생");
//             return null;
//         }
//        
//    }
    
    @GetMapping("/sPName")
    public ResponseEntity<String> egypttt(@RequestParam("dutyName") String dutyName,
                     Model model,
                     HttpServletRequest requset) {
       
       
       List<PlaceDto> list = (List<PlaceDto>)requset.getSession().getAttribute("place");
          System.out.println(list.toString());
          
       List<PlaceDto> filterdList = list.stream()
                            .filter(PlaceDto -> PlaceDto.getDutyName().equals(dutyName))
                            .collect(Collectors.toList());
          System.out.println(filterdList.toString());
     
          return ResponseEntity.ok("약국 이름 전송 성공: " + filterdList);
       
       
    }
}

