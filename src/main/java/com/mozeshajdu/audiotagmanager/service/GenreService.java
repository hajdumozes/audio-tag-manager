package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.Genre;
import com.mozeshajdu.audiotagmanager.persistance.GenreRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GenreService {
    GenreRepository genreRepository;

    @Transactional
    public Genre of(String genre) {
        return genreRepository.findGenreByName(genre)
                .orElseGet(save(genre));
    }

    private Supplier<Genre> save(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return () -> genreRepository.save(genre);
    }
}
