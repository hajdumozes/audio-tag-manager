package com.mozeshajdu.audiotagmanager.web;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import com.mozeshajdu.audiotagmanager.mapper.SpotifyTrackMapper;
import com.mozeshajdu.audiotagmanager.service.SpotifyTrackService;
import com.mozeshajdu.audiotagmanager.web.dto.SpotifyTrackDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Spotify track API")
@RestController
@RequestMapping(value = "/spotify-tracks", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SpotifyTrackController {

    SpotifyTrackService spotifyTrackService;
    SpotifyTrackMapper spotifyTrackMapper;

    @Operation(summary = "Get all spotify tracks")
    @GetMapping
    public ResponseEntity<List<SpotifyTrackDto>> findAll() {
        List<SpotifyTrack> spotifyTracks = spotifyTrackService.findAll();
        return ResponseEntity.ok(spotifyTrackMapper.toDtoList(spotifyTracks));
    }
}
