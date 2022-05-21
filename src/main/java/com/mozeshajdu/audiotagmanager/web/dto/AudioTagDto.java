package com.mozeshajdu.audiotagmanager.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AudioTagDto {

    Long id;
    String title;
    String album;
    Set<ArtistDto> artists;
    Set<AlbumArtistDto> albumArtists;
    String year;
    String track;
    Set<GenreDto> genres;
    String grouping;
    String rating;
    SpotifyTrackDto spotifyTrack;
}
