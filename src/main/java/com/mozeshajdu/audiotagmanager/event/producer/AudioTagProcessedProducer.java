package com.mozeshajdu.audiotagmanager.event.producer;

import com.mozeshajdu.audiotagmanager.event.entity.AudioTagProcessedMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AudioTagProcessedProducer {
    Sinks.Many<AudioTagProcessedMessage> audioTagProcessedMessageMany;

    public void produce(AudioTagProcessedMessage audioTag) {
        audioTagProcessedMessageMany.tryEmitNext(audioTag);
    }
}
