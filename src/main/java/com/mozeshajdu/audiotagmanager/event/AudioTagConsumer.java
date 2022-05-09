package com.mozeshajdu.audiotagmanager.event;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.mapper.AudioTagMapper;
import com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Qualifier("consumeAudioTags")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AudioTagConsumer implements Consumer<AudioTagMessage> {

    AudioTagRepository audioTagRepository;
    AudioTagMapper audioTagMapper;

    @Override
    public void accept(AudioTagMessage audioTagMessage) {
        log.info("Received audioTag: {}", audioTagMessage.toString());
        save(audioTagMapper.of(audioTagMessage));
    }

    private void save(AudioTag audioTag) {
        try {
            audioTagRepository.save(audioTag);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save tag (%s) due to constraint violation", audioTag.toString()));
        }
    }
}