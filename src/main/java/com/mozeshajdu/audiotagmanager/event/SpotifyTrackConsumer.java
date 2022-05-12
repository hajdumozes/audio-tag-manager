package com.mozeshajdu.audiotagmanager.event;

import com.mozeshajdu.audiotagmanager.mapper.SpotifyTrackMapper;
import com.mozeshajdu.audiotagmanager.service.SpotifyTrackService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.function.Consumer;

@Component
@Qualifier("consumeSpotifyTracks")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class SpotifyTrackConsumer implements Consumer<SpotifyTrackMessage> {
    SpotifyTrackMapper spotifyTrackMapper;
    SpotifyTrackService spotifyTrackService;

    @Override
    @Transactional
    public void accept(SpotifyTrackMessage spotifyTrackMessage) {
        log.info("Received spotifyTrack: {}", spotifyTrackMessage.toString());
        spotifyTrackService.save(spotifyTrackMapper.of(spotifyTrackMessage));
    }
}
