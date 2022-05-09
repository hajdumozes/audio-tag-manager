package com.mozeshajdu.audiotagmanager.persistance;

import com.mozeshajdu.audiotagmanager.entity.AlbumArtist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumArtistRepository extends JpaRepository<AlbumArtist, Long> {
    Optional<AlbumArtist> findAlbumArtistByName(String name);
}
