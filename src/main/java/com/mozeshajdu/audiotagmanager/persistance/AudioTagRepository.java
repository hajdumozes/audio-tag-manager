package com.mozeshajdu.audiotagmanager.persistance;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudioTagRepository extends JpaRepository<AudioTag, Long>, JpaSpecificationExecutor<AudioTag> {

    String ANYTHING_BEFORE_AFTER_FORMAT = "%%%s%%";

    List<AudioTag> findAudioTagsBySpotifyTrackIsNull();

    List<AudioTag> findAudioTagsBySpotifyTrackIsNotNull();

    static Specification<AudioTag> titleContains(String title) {
        return (audioTag, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(
                        criteriaBuilder.lower(
                                audioTag.get("title")), String.format(ANYTHING_BEFORE_AFTER_FORMAT, title.toLowerCase()
                        )
                );
    }

    static Specification<AudioTag> ratingAtLeast(int rating) {
        return (audioTag, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(audioTag.get("rating"), rating);
    }

    static Specification<AudioTag> spotifyTrackIdIsPresent(boolean isPresent) {
        return (audioTag, criteriaQuery, criteriaBuilder) ->
                isPresent ?
                        criteriaBuilder.isNotNull(audioTag.get("spotifyTrack")) :
                        criteriaBuilder.isNull(audioTag.get("spotifyTrack"));
    }
}
