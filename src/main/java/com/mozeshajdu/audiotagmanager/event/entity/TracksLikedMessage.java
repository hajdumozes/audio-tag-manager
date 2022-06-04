package com.mozeshajdu.audiotagmanager.event.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TracksLikedMessage {
    List<String> spotifyIds;
    SpotifyAction spotifyAction;
}