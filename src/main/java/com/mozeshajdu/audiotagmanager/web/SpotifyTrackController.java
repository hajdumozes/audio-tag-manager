package com.mozeshajdu.audiotagmanager.web;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import com.mozeshajdu.audiotagmanager.mapper.SpotifyTrackMapper;
import com.mozeshajdu.audiotagmanager.service.SpotifyTrackService;
import com.mozeshajdu.audiotagmanager.web.dto.SpotifyTrackDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/spotify-track", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpotifyTrackController {

    SpotifyTrackService spotifyTrackService;
    SpotifyTrackMapper spotifyTrackMapper;

    @GetMapping
    public ResponseEntity<List<SpotifyTrackDto>> findAll() {
        List<SpotifyTrack> spotifyTracks = spotifyTrackService.findAll();
        return ResponseEntity.ok(spotifyTrackMapper.toDtoList(spotifyTracks));
    }
}
