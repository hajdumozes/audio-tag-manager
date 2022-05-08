package com.mozeshajdu.audiotagmanager.event;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository;
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

    AudioTagRepository audioTagRepository;

    @Override
    public void accept(AudioTagMessage audioTagMessage) {
        log.info("Received audioTag: {}", audioTagMessage.toString());
        AudioTag audioTag = AudioTag.builder().title(audioTagMessage.getTitle()).build();
        audioTagRepository.save(audioTag);
    }
}
