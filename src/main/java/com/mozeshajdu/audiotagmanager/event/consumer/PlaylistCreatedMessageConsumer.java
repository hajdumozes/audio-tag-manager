package com.mozeshajdu.audiotagmanager.event.consumer;

import com.mozeshajdu.audiotagmanager.event.entity.PlaylistCreatedMessage;
import com.mozeshajdu.audiotagmanager.mapper.PlaylistMapper;
import com.mozeshajdu.audiotagmanager.service.PlaylistService;
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
@Qualifier("consumePlaylistCreated")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PlaylistCreatedMessageConsumer implements Consumer<PlaylistCreatedMessage> {
    PlaylistService playlistService;
    PlaylistMapper playlistMapper;

    @Override
    @Transactional
    public void accept(PlaylistCreatedMessage playlistCreatedMessage) {
        log.info("Received playlistCreatedMessage: {}", playlistCreatedMessage.toString());
        playlistService.save(playlistMapper.of(playlistCreatedMessage));
    }
}
