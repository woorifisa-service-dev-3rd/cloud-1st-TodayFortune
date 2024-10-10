package com.example.gpt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HoroscopeService {

    @Value("${openai.api.key}")
    private String apiKey;

    private final String apiUrl = "https://api.openai.com/v1/chat/completions";

    public String getRendomTodayFortune() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("max_tokens", 500);
        requestBody.put("temperature", 0.9);

        Map<String, String> systemMessage = new HashMap<>();
        systemMessage.put("role", "system");
        systemMessage.put("content", "당신은 한국어로 운세를 알려주는 점성술 전문가입니다.");

        Map<String, String> userMessage = new HashMap<>();
        userMessage.put("role", "user");
        userMessage.put("content", "오늘의 운세를 알려주세요. 맨앞의 알겠습니다.는 하지말아주세요.");

        requestBody.put("messages", new Object[]{systemMessage, userMessage});

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                Map<String, Object> responseBody = response.getBody();
                if (responseBody != null && responseBody.containsKey("choices")) {
                    List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
                    Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                    return (String) message.get("content");
                }
            } else {
                throw new RuntimeException("API 호출 실패: " + response.getStatusCode());
            }
        } catch (RestClientException e) {
            e.printStackTrace();  // 오류 로그를 출력하여 문제 파악에 도움
            return "운세를 가져오는 중 오류가 발생했습니다. 다시 시도해 주세요.";
        }

        throw new RuntimeException("API 응답에서 'choices'를 찾을 수 없습니다.");
    }
}