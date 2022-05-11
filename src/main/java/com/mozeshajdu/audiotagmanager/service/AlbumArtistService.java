package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.AlbumArtist;
import com.mozeshajdu.audiotagmanager.persistance.AlbumArtistRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlbumArtistService {
    AlbumArtistRepository albumArtistRepository;

    public AlbumArtist of(String artistName) {
        return albumArtistRepository.findAlbumArtistByName(artistName)
                .orElseGet(create(artistName));
    }

    private Supplier<AlbumArtist> create(String name) {
        AlbumArtist albumArtist = new AlbumArtist();
        albumArtist.setName(name);
        return () -> albumArtist;
    }
}
