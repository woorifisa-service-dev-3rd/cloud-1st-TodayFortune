package com.example.gpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HoroscopeController {

    @Autowired
    private HoroscopeService horoscopeService;

    @GetMapping("/")
    public String showHoroscopeForm() {
        return "index"; // 운세 입력 폼을 보여주는 템플릿
    }

    @PostMapping("/getHoroscope")
    public String getHoroscope(Model model) {
        String horoscope = horoscopeService.getRendomTodayFortune();
        model.addAttribute("horoscope", horoscope); // 결과를 모델에 추가하여 HTML 템플릿에 전달
        return "result"; // 결과를 보여주는 템플릿
    }
}