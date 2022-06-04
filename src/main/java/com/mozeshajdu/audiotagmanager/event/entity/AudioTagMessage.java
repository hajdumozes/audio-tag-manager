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
public class AudioTagMessage {

    String title;
    Set<String> artists;
    Set<String> albumArtists;
    String album;
    String year;
    String track;
    Set<String> genres;
    String grouping;
    String rating;
}

