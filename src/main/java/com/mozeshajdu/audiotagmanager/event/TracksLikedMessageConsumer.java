package com.mozeshajdu.audiotagmanager.event;

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
@Qualifier("consumeTracksLikedMessage")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class TracksLikedMessageConsumer implements Consumer<TracksLikedMessage> {
    SpotifyTrackService spotifyTrackService;

    @Override
    @Transactional
    public void accept(TracksLikedMessage tracksLikedMessage) {
        log.info("Received tracksLikedMessage: {}", tracksLikedMessage.toString());
        boolean liked = tracksLikedMessage.getSpotifyAction() == SpotifyAction.ADDED;
        spotifyTrackService.setLiked(tracksLikedMessage.getSpotifyIds(), liked);
    }
}
