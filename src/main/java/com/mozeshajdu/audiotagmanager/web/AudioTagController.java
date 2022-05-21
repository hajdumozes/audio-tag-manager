package com.mozeshajdu.audiotagmanager.web;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.entity.AudioTagQuery;
import com.mozeshajdu.audiotagmanager.mapper.AudioTagMapper;
import com.mozeshajdu.audiotagmanager.service.AudioTagService;
import com.mozeshajdu.audiotagmanager.web.dto.AudioTagDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/audio-tag", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AudioTagController {
    AudioTagService audioTagService;
    AudioTagMapper audioTagMapper;

    @GetMapping
    public ResponseEntity<List<AudioTagDto>> findAll() {
        List<AudioTag> audioTags = audioTagService.findAll();
        return ResponseEntity.ok(audioTagMapper.toDtoList(audioTags));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AudioTagDto> findById(@PathVariable Long id) {
        AudioTagDto audioTagDto = audioTagService.findById(id)
                .map(audioTagMapper::toDto)
                .orElse(null);
        return ResponseEntity.ok(audioTagDto);
    }

    @PostMapping(value = "/find", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AudioTagDto>> find(@RequestBody AudioTagQuery audioTagQuery) {
        List<AudioTagDto> result = audioTagService.find(audioTagQuery)
                .stream()
                .map(audioTagMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/disconnected")
    public ResponseEntity<List<AudioTagDto>> findDisconnected() {
        List<AudioTag> audioTags = audioTagService.findTagsWithoutSpotifyConnection();
        return ResponseEntity.ok(audioTagMapper.toDtoList(audioTags));
    }

    @GetMapping(value = "/connected")
    public ResponseEntity<List<AudioTagDto>> findConnected() {
        List<AudioTag> audioTags = audioTagService.findTagsWithSpotifyConnection();
        return ResponseEntity.ok(audioTagMapper.toDtoList(audioTags));
    }
}
