package com.mozeshajdu.audiotagmanager.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AudioTagMessage {

    String title;
    List<String> artists;
    List<String> albumArtists;
    String album;
    String year;
    String track;
    String composer;
    List<String> genres;
    String grouping;
}

