package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.AlbumArtist;
import org.springframework.stereotype.Component;

@Component
public class AlbumArtistMapper {

    AlbumArtist of(String source) {
        AlbumArtist albumArtist = new AlbumArtist();
        albumArtist.setName(source);
        return albumArtist;
    }
}
