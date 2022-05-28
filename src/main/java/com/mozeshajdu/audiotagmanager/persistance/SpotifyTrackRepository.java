package com.mozeshajdu.audiotagmanager.persistance;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpotifyTrackRepository extends JpaRepository<SpotifyTrack, Long> {
    List<SpotifyTrack> findAllBySpotifyIdIn(List<String> ids);

}
