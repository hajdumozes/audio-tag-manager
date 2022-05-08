package com.mozeshajdu.audiotagmanager.event;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Qualifier("consumeAudioTags")
@Slf4j
public class AudioTagConsumer implements Consumer<AudioTag> {

    @Override
    public void accept(AudioTag audioTag) {
        log.info("Received audioTag: {}", audioTag.toString());
    }
}
