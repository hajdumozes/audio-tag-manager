package com.mozeshajdu.audiotagmanager.web;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.entity.AudioTagQuery;
import com.mozeshajdu.audiotagmanager.mapper.AudioTagMapper;
import com.mozeshajdu.audiotagmanager.service.AudioTagService;
import com.mozeshajdu.audiotagmanager.web.dto.AudioTagDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "Audio tag API")
@RestController
@RequestMapping(value = "/audio-tags", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AudioTagController {
    AudioTagService audioTagService;
    AudioTagMapper audioTagMapper;

    @Operation(summary = "Get all audio tags")
    @GetMapping
    public ResponseEntity<List<AudioTagDto>> findAll() {
        List<AudioTag> audioTags = audioTagService.findAll();
        return ResponseEntity.ok(audioTagMapper.toDtoList(audioTags));
    }

    @Operation(summary = "Get audio tag by id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AudioTagDto> findById(@PathVariable Long id) {
        AudioTagDto audioTagDto = audioTagService.findById(id)
                .map(audioTagMapper::toDto)
                .orElse(null);
        return ResponseEntity.ok(audioTagDto);
    }

    @Operation(summary = "Get audio tags by query")
    @PostMapping(value = "/query", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AudioTagDto>> find(@RequestBody AudioTagQuery audioTagQuery) {
        List<AudioTagDto> result = audioTagService.find(audioTagQuery)
                .stream()
                .map(audioTagMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
