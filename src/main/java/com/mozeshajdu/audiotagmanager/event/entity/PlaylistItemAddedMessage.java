package com.mozeshajdu.audiotagmanager.event.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistItemAddedMessage {
    String playlistSpotifyId;
    List<String> trackUris;
}
