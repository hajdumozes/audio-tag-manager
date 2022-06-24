package com.mozeshajdu.audiotagmanager.event.consumer;

import com.mozeshajdu.audiotagmanager.event.entity.AudioTagCreatedMessage;
import com.mozeshajdu.audiotagmanager.event.producer.AudioTagProducer;
import com.mozeshajdu.audiotagmanager.mapper.AudioTagMapper;
import com.mozeshajdu.audiotagmanager.service.AudioTagService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.function.Consumer;

@Component
@Qualifier("consumeAudioTagCreated")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class AudioTagCreatedConsumer implements Consumer<AudioTagCreatedMessage> {

    AudioTagMapper audioTagMapper;
    AudioTagService audioTagService;
    AudioTagProducer audioTagProducer;

    @Override
    @Transactional
    public void accept(AudioTagCreatedMessage audioTagCreatedMessage) {
        log.info("Received audioTagCreatedMessage: {}", audioTagCreatedMessage.toString());
        boolean saved = audioTagService.save(audioTagMapper.of(audioTagCreatedMessage));
        audioTagProducer.produce(audioTagMapper.toProcessedMessage(audioTagCreatedMessage));
        if (saved) {
            audioTagProducer.produce(audioTagMapper.toAddedMessage(audioTagCreatedMessage));
        }
    }
}
