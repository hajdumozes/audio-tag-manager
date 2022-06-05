package com.mozeshajdu.audiotagmanager.event.consumer;

import com.mozeshajdu.audiotagmanager.event.entity.PlaylistItemAddedMessage;
import com.mozeshajdu.audiotagmanager.service.PlaylistService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.function.Consumer;

@Component
@Qualifier("consumePlaylistItemAdded")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Slf4j
public class PlaylistItemAddedMessageConsumer implements Consumer<PlaylistItemAddedMessage> {
    PlaylistService playlistService;

    @Override
    @Transactional
    public void accept(PlaylistItemAddedMessage playlistItemAddedMessage) {
        log.info("Received playlistItemAddedMessage: {}", playlistItemAddedMessage.toString());
        playlistService.addItems(playlistItemAddedMessage.getPlaylistSpotifyId(), playlistItemAddedMessage.getTrackUris());
    }
}
