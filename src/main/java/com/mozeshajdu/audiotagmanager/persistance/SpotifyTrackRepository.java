package com.mozeshajdu.audiotagmanager.persistance;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpotifyTrackRepository extends JpaRepository<SpotifyTrack, Long> {
    Optional<SpotifyTrack> findBySpotifyId(String spotifyId);

    List<SpotifyTrack> findAllBySpotifyIdIn(List<String> ids);

    List<SpotifyTrack> findAllByUriIn(List<String> uris);

}
