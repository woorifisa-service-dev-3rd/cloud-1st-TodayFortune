package com.example.TodayFortune.controller;

import com.example.TodayFortune.service.TTSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TTSController {

    private final TTSService ttsService;

    @GetMapping("/test")
    public ResponseEntity<byte[]> getMp3(@RequestParam("text") String text) {
        byte[] mp3Bytes = ttsService.converStringToSpeechMp3(text);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(mp3Bytes);
    }
}
