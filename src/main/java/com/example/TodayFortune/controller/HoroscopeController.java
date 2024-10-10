package com.example.TodayFortune.controller;

import com.example.TodayFortune.service.HoroscopeService;
import com.example.TodayFortune.service.TTSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoroscopeController {

    @Autowired
    private HoroscopeService horoscopeService;

    @Autowired
    private TTSService ttsService;

//    @GetMapping("/")
//    public String showHoroscopeForm() {
//        return "index"; // 운세 입력 폼을 보여주는 템플릿
//    }

    @GetMapping(value = "/api/fortune2", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
    public byte[] getFortune() {
        // 운세 데이터를 텍스트로 반환
        System.out.println("heello");
        return ttsService.converStringToSpeechMp3(horoscopeService.getRendomTodayFortune());
    }
//
//    @PostMapping("/getHoroscope")
//    public String getHoroscope(Model model) {
//        String horoscope = horoscopeService.getRendomTodayFortune();
//        model.addAttribute("horoscope", horoscope); // 결과를 모델에 추가하여 HTML 템플릿에 전달
//        return "result"; // 결과를 보여주는 템플릿
//    }
}