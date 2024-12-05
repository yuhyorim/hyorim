package com.hk.board.RestController;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.hk.board.Dto.ResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;

import ch.qos.logback.classic.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Encoder;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;


//웹에서 API를 호출하면 그 요청을 처리
//@RestController //데이터 자체만 보내주고 클라이언트로 보내준다 클라이언트에서 처리할 수 있도록 함 
@Controller //자바 객체로 만들어서 보내주는 것
public class HospitalController {

    @GetMapping("/api")
    public String callApi(Model model) throws IOException {
        StringBuilder result = new StringBuilder();

        // 외부 API의 URL
        String urlStr = "http://apis.data.go.kr/B552657/ErmctInsttInfoInqireService/getParmacyListInfoInqire?" +
            "serviceKey=w88bHZL8YU8L4yw8aLk%2BPZUGsE1aEfBfZb57Jp%2BAK2o5HBfjUiLRyPa6QQQf6jG7GPFizsl1OyALzlniJaSp4g%3D%3D"+
              // 환경 변수 또는 properties 파일로 관리
            "&STAGE1="+(URLEncoder.encode("서울특별시", "utf-8"))+
            "&STAGE2="+(URLEncoder.encode("종로구","utf-8"))+
            "&pageNo=1"+
            "&numOfRows=10";
            
            
   

        URL url = new URL(urlStr);
        //서버와 연결
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        // 응답 데이터를 읽어들임
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        
        String returnLine;
        //한줄씩 읽어 데이터 result에 저장
        while ((returnLine = br.readLine()) != null) {
            result.append(returnLine);
        }
        //연결 끊기
        urlConnection.disconnect();
        
        // XML을 JSON으로 변환 (만약 XML 응답일 경우)
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode jsonNode = xmlMapper.readTree(result.toString()); // XML을 JSON으로 변환
        
        System.out.println(jsonNode.get("body").get("items").get("item").toString());
        ObjectMapper objectMapper = new ObjectMapper();
        
        List<ResponseDto> responseList = objectMapper.readValue(
              jsonNode.get("body").get("items").get("item").toString(), // JsonNode를 문자열로 변환하여 처리
                new TypeReference<List<ResponseDto>>() {} // List<ResponseDto>로 변환
            ); 
             
        
        String resultt = responseList.toString();
        System.out.println(resultt);
//      return resultt;
        
        model.addAttribute("list", responseList);
        return "test";

    
    
        }
    }