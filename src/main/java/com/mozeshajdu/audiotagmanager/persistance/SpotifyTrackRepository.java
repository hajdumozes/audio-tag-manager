package com.mozeshajdu.audiotagmanager.persistance;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotifyTrackRepository extends JpaRepository<SpotifyTrack, Long> {
}
