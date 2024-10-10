package com.example.TodayFortune.service;

import com.google.cloud.texttospeech.v1.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TTSServiceImpl implements TTSService{

    private final TextToSpeechClient textToSpeechClient;

    @Override
    public byte[] converStringToSpeechMp3(String text) {

        log.info("Text는받았고"+text);

        SynthesisInput input = SynthesisInput.newBuilder()
                .setText(text)
                .build();

        VoiceSelectionParams voice = VoiceSelectionParams.newBuilder()
                .setLanguageCode("ko-KR")
                .setSsmlGender(SsmlVoiceGender.FEMALE)
                .build();

        AudioConfig audioConfig = AudioConfig.newBuilder()
                .setAudioEncoding(AudioEncoding.MP3)
                .build();

        SynthesizeSpeechRequest request = SynthesizeSpeechRequest.newBuilder()
                .setInput(input)
                .setVoice(voice)
                .setAudioConfig(audioConfig)
                .build();

        try {
            SynthesizeSpeechResponse response = textToSpeechClient.synthesizeSpeech(request);
            return response.getAudioContent().toByteArray();
        } catch (Exception e) {
            log.error("TTS 변환 중 오류 발생", e);
            throw new RuntimeException("TTS 변환 실패", e);
        }
    }

}
