package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import com.mozeshajdu.audiotagmanager.persistance.SpotifyTrackRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SpotifyTrackService {
    public static final List<String> IGNORED_PROPERTIES = List.of("id", "liked", "audioTag", "artists", "playlists");
    SpotifyTrackRepository spotifyTrackRepository;

    public List<SpotifyTrack> findAll() {
        return spotifyTrackRepository.findAll();
    }

    public void save(SpotifyTrack incomingSpotifyTrack) {
        Optional<SpotifyTrack> optionalSpotifyTrack = spotifyTrackRepository.findBySpotifyId(incomingSpotifyTrack.getSpotifyId());
        if (optionalSpotifyTrack.isPresent()) {
            update(incomingSpotifyTrack, optionalSpotifyTrack.get());
        } else {
            persist(incomingSpotifyTrack);
        }
    }

    public void setLiked(List<String> ids, boolean liked) {
        List<SpotifyTrack> spotifyTracks = spotifyTrackRepository.findAllBySpotifyIdIn(ids);
        spotifyTracks.forEach(spotifyTrack -> spotifyTrack.setLiked(liked));
    }

    public List<SpotifyTrack> findByUris(List<String> uris) {
        return spotifyTrackRepository.findAllByUriIn(uris);
    }

    private void update(SpotifyTrack incomingSpotifyTrack, SpotifyTrack spotifyTrackInRepository) {
        BeanUtils.copyProperties(incomingSpotifyTrack, spotifyTrackInRepository, IGNORED_PROPERTIES.toArray(String[]::new));
    }

    private void persist(SpotifyTrack track) {
        try {
            SpotifyTrack savedSpotifyTrack = spotifyTrackRepository.save(track);
            savedSpotifyTrack.getAudioTag().setSpotifyTrack(savedSpotifyTrack);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save track (%s) due to constraint violation", track.toString()));
        }
    }
}
