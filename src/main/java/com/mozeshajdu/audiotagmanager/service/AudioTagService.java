package com.mozeshajdu.audiotagmanager.service;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.entity.AudioTagQuery;
import com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository.groupingContains;
import static com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository.ratingAtLeast;
import static com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository.spotifyTrackIdIsPresent;
import static com.mozeshajdu.audiotagmanager.persistance.AudioTagRepository.titleContains;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class AudioTagService {
    public static final List<String> IGNORED_PROPERTIES = List.of("id", "spotifyTrack");
    AudioTagRepository audioTagRepository;

    public List<AudioTag> find(AudioTagQuery audioTagQuery) {
        Specification<AudioTag> specification = Specification.where(null);
        if (audioTagQuery.getTitle() != null) {
            specification = specification.and(titleContains(audioTagQuery.getTitle()));
        }
        if (audioTagQuery.getRatingAtLeast() != null) {
            specification = specification.and(ratingAtLeast(audioTagQuery.getRatingAtLeast()));
        }
        if (audioTagQuery.getSpotifyTrackPresence() != null) {
            specification = specification.and(spotifyTrackIdIsPresent(audioTagQuery.getSpotifyTrackPresence()));
        }
        if (audioTagQuery.getGrouping() != null) {
            specification = specification.and(groupingContains(audioTagQuery.getGrouping()));
        }
        return audioTagRepository.findAll(specification);
    }

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

    public AudioTag of(Long id) {
        return findById(id).orElse(null);
    }

    public void save(AudioTag audioTag) {
        Optional<AudioTag> optionalAudioTag =
                audioTagRepository.findAudioTagByTitleAndAlbum(audioTag.getTitle(), audioTag.getAlbum());
        if (optionalAudioTag.isPresent()) {
            update(audioTag, optionalAudioTag.get());
        } else {
            persist(audioTag);
        }
    }

    private void update(AudioTag incomingAudioTag, AudioTag audioTagInRepository) {
        BeanUtils.copyProperties(incomingAudioTag, audioTagInRepository, IGNORED_PROPERTIES.toArray(String[]::new));
    }

    private void persist(AudioTag audioTag) {
        try {
            audioTagRepository.save(audioTag);
        } catch (DataIntegrityViolationException e) {
            log.error(String.format("Could not save tag (%s) due to constraint violation", audioTag.toString()));
        }
    }
}
