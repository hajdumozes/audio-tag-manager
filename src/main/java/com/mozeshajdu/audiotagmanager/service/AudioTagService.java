package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AudioTagService {
    AudioTagRepository audioTagRepository;

    public List<AudioTag> findAll() {
        return audioTagRepository.findAll();
    }

    public List<AudioTag> findTagsWithoutSpotifyConnection() {
        return audioTagRepository.findAudioTagsBySpotifyTrackIsNull();
    }

    public List<AudioTag> findTagsWithSpotifyConnection() {
        return audioTagRepository.findAudioTagsBySpotifyTrackIsNotNull();
    }

    public Optional<AudioTag> findById(Long id) {
        return audioTagRepository.findById(id);
    }

    public void save(AudioTag audioTag) {
        try {
            audioTagRepository.save(audioTag);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save tag (%s) due to constraint violation", audioTag.toString()));
        }
    }
}
