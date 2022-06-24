package com.mozeshajdu.audiotagmanager.config;

import com.mozeshajdu.audiotagmanager.event.entity.AudioTagProcessedMessage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.function.Supplier;

@Configuration
public class EventProducerConfig {

    @Bean
    public Sinks.Many<AudioTagProcessedMessage> audioTagSink() {
        return Sinks.many().unicast().onBackpressureBuffer();
    }

    @Bean
    Supplier<Flux<AudioTagProcessedMessage>> produceAudioTagProcessed(Sinks.Many<AudioTagProcessedMessage> audioTagProcessedMessageMany) {
        return audioTagProcessedMessageMany::asFlux;
    }
}
