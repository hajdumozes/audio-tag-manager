package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.SpotifyTrack;
import com.mozeshajdu.audiotagmanager.event.entity.SpotifyTrackMessage;
import com.mozeshajdu.audiotagmanager.service.ArtistService;
import com.mozeshajdu.audiotagmanager.service.AudioTagService;
import com.mozeshajdu.audiotagmanager.web.dto.SpotifyTrackDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ArtistService.class, AudioTagService.class})
public interface SpotifyTrackMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "audioTag", source = "audioTagId")
    @Mapping(target = "spotifyId", source = "spotifyId")
    SpotifyTrack of(SpotifyTrackMessage source);

    List<SpotifyTrack> toDtoList(List<SpotifyTrack> source);

    SpotifyTrackDto of(SpotifyTrack source);
}
