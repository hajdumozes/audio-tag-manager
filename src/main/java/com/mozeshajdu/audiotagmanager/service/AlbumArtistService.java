package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.AlbumArtist;
import com.mozeshajdu.audiotagmanager.persistance.AlbumArtistRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AlbumArtistService {
    AlbumArtistRepository albumArtistRepository;

    @Transactional
    public AlbumArtist of(String artistName) {
        return albumArtistRepository.findAlbumArtistByName(artistName)
                .orElseGet(save(artistName));
    }

    private Supplier<AlbumArtist> save(String name) {
        AlbumArtist albumArtist = new AlbumArtist();
        albumArtist.setName(name);
        return () -> albumArtistRepository.save(albumArtist);
    }
}
