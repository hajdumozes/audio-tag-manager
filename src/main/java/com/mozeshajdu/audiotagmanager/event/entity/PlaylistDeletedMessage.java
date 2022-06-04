package com.mozeshajdu.audiotagmanager.event.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlaylistDeletedMessage {
    String spotifyId;
}
