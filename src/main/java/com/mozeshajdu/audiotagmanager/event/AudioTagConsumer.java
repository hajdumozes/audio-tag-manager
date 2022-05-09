package com.mozeshajdu.audiotagmanager.event;

import com.mozeshajdu.audiotagmanager.mapper.AudioTagMapper;
import com.mozeshajdu.audiotagmanager.service.AudioTagService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Qualifier("consumeAudioTags")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AudioTagConsumer implements Consumer<AudioTagMessage> {

    AudioTagMapper audioTagMapper;
    AudioTagService audioTagService;

    @Override
    public void accept(AudioTagMessage audioTagMessage) {
        log.info("Received audioTag: {}", audioTagMessage.toString());
        audioTagService.save(audioTagMapper.of(audioTagMessage));
    }
}
