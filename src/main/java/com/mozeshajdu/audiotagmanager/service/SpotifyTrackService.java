package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import com.mozeshajdu.audiotagmanager.persistance.SpotifyTrackRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SpotifyTrackService {
    SpotifyTrackRepository spotifyTrackRepository;

    public void save(SpotifyTrack track) {
        try {
            SpotifyTrack savedSpotifyTrack = spotifyTrackRepository.save(track);
            savedSpotifyTrack.getAudioTag().setSpotifyTrack(savedSpotifyTrack);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save track (%s) due to constraint violation", track.toString()));
        }
    }
}
