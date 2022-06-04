package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.Playlist;
import com.mozeshajdu.audiotagmanager.persistance.PlaylistRepository;
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
public class PlaylistService {
    PlaylistRepository playlistRepository;

    public void save(Playlist playlist) {
        try {
            playlistRepository.save(playlist);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save playlist (%s) due to constraint violation", playlist.toString()));
        }
    }
}
