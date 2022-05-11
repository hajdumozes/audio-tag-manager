package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.Genre;
import com.mozeshajdu.audiotagmanager.persistance.GenreRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GenreService {
    GenreRepository genreRepository;

    public Genre of(String genre) {
        return genreRepository.findGenreByName(genre)
                .orElseGet(create(genre));
    }

    private Supplier<Genre> create(String name) {
        Genre genre = new Genre();
        genre.setName(name);
        return () -> genre;
    }
}
