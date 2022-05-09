package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    Artist of(String source) {
        Artist artist = new Artist();
        artist.setName(source);
        return artist;
    }
}
