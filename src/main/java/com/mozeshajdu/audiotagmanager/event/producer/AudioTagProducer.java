package com.mozeshajdu.audiotagmanager.event.producer;

import com.mozeshajdu.audiotagmanager.event.entity.AudioTagAddedMessage;
import com.mozeshajdu.audiotagmanager.event.entity.AudioTagProcessedMessage;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AudioTagProducer {
    Sinks.Many<AudioTagProcessedMessage> audioTagProcessedMessageMany;
    Sinks.Many<AudioTagAddedMessage> audioTagAddedMessageMany;

    public void produce(AudioTagProcessedMessage audioTagProcessedMessage) {
        audioTagProcessedMessageMany.tryEmitNext(audioTagProcessedMessage);
    }

    public void produce(AudioTagAddedMessage audioTagAddedMessage) {
        audioTagAddedMessageMany.tryEmitNext(audioTagAddedMessage);
    }
}
