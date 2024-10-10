//package com.example.TodayFortune.service;
//
//import com.google.cloud.texttospeech.v1.TextToSpeechClient;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class TTSServiceImplTest {
//
//    @Autowired
//    private TTSService ttsService;
//
//    @Autowired
//    private TextToSpeechClient textToSpeechClient;
//
//    @Test
//    public void String을_mp3로_받아보자() {
//        String mp3result = ttsService.converStringToSpeechMp3("테스트를 해볼게요");
//        assertNotNull(mp3result);
//        System.out.println("mp3결과는: " + mp3result);
//    }
//
//}