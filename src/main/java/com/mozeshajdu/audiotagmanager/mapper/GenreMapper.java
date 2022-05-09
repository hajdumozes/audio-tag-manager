package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.Genre;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    Genre of(String source) {
        Genre genre = new Genre();
        genre.setName(source);
        return genre;
    }
}
