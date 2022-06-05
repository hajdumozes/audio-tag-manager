package com.mozeshajdu.audiotagmanager.event.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpotifyTrackMessage {
    String spotifyId;
    String name;
    String album;
    String releaseDate;
    Set<String> artists;
    Integer popularity;
    String trackNumber;
    String url;
    String uri;
    Long audioTagId;
}
