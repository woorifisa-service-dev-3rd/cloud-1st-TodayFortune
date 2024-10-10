package com.example.TodayFortune.service;

import com.google.auth.ApiKeyCredentials;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.TextToSpeechSettings;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

//@TestConfiguration
//public class TesttsConfig {
//
//    @Bean
//    public TextToSpeechClient textToSpeechClient() throws IOException {
//        // 실제 API 키를 여기에서 설정
//        ApiKeyCredentials credentials = ApiKeyCredentials.create("YOUR_API_KEY");
//        TextToSpeechSettings settings = TextToSpeechSettings.newBuilder()
//                .setCredentialsProvider(() -> credentials)
//                .build();
//        return TextToSpeechClient.create(settings);
//    }
//}
