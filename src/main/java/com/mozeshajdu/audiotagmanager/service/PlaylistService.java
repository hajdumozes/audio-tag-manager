package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.Playlist;
import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import com.mozeshajdu.audiotagmanager.persistance.PlaylistRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PlaylistService {
    PlaylistRepository playlistRepository;
    SpotifyTrackService spotifyTrackService;

    public void save(Playlist playlist) {
        try {
            playlistRepository.save(playlist);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save playlist (%s) due to constraint violation", playlist.toString()));
        }
    }

    public void delete(String spotifyId) {
        playlistRepository.findBySpotifyId(spotifyId)
                .ifPresent(playlistRepository::delete);
    }

    public void addItems(String spotifyId, List<String> trackUris) {
        List<SpotifyTrack> tracks = spotifyTrackService.findByUris(trackUris);
        playlistRepository.findBySpotifyId(spotifyId)
                .ifPresent(playlist -> persist(tracks, playlist));
    }

    private void persist(List<SpotifyTrack> tracks, Playlist playlist) {
        playlist.getTracks().addAll(tracks);
        tracks.forEach(track -> track.getPlaylists().add(playlist));
    }
}
