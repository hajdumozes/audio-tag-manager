package com.mozeshajdu.audiotagmanager.web.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ArtistDto {
    String id;
    String name;
}
