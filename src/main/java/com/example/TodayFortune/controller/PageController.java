package com.example.TodayFortune.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;

@Controller
public class PageController {

    @GetMapping("/tts-player")
    public String getTtsPlayerPage() {
        return "tts-player";
    }
}
