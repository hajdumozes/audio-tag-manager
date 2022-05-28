package com.mozeshajdu.audiotagmanager.event;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TracksLikedMessage {
    List<String> spotifyIds;
    SpotifyAction spotifyAction;
}