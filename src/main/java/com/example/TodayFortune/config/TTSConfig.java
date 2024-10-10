package com.example.TodayFortune.config;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.texttospeech.v1.TextToSpeechClient;
import com.google.cloud.texttospeech.v1.TextToSpeechSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTSConfig {

    @Value("${google.cloud.api.key}")
    private String apiKey;

    @Bean
    public TextToSpeechClient textToSpeechClient() throws IOException {
        // ApiKeyCredentials 객체 생성
        ApiKeyCredentials credentials = ApiKeyCredentials.create(apiKey);

        TextToSpeechSettings settings = TextToSpeechSettings.newBuilder()
                .setCredentialsProvider(() -> credentials)
                .build();

        return TextToSpeechClient.create(settings);
    }
}
