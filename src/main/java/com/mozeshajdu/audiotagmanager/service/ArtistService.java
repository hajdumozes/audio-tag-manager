package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.Artist;
import com.mozeshajdu.audiotagmanager.persistance.ArtistRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ArtistService {
    ArtistRepository artistRepository;

    public Artist of(String artistName) {
        return artistRepository.findArtistByName(artistName)
                .orElseGet(save(artistName));
    }

    private Supplier<Artist> save(String name) {
        Artist artist = new Artist();
        artist.setName(name);
        return () -> artistRepository.save(artist);
    }
}
