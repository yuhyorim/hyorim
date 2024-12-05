package com.hk.board.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hk.board.Dto.PlaceDto;

@Controller
public class PlaceController {

	@GetMapping("/med")
    public ResponseEntity<List<PlaceDto>> callApi() throws IOException {
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
        
        
        

        return ResponseEntity.ok(placeList);
    }
}
