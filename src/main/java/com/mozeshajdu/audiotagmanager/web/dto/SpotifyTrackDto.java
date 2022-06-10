package com.mozeshajdu.audiotagmanager.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpotifyTrackDto {
    Long id;

    String spotifyId;

    String name;

    String album;

    String releaseDate;

    List<ArtistDto> artists;

    Integer popularity;

    String trackNumber;

    String url;

    String uri;

    Long audioTagId;
}
