package com.example.TodayFortune.controller;

import com.example.TodayFortune.service.FortuneService;
import com.example.TodayFortune.service.TTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FortuneController {

    @Autowired
    private FortuneService fortuneService;

    @Autowired
    private TTSService ttsService;

    // /api/fortune API 엔드포인트 제공
    @GetMapping(value = "/api/fortune", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
    public byte[] getFortune() {
        // 서비스에서 운세 데이터를 가져와 반환
        return ttsService.converStringToSpeechMp3(fortuneService.getRendomTodayFortune());
    }
}
