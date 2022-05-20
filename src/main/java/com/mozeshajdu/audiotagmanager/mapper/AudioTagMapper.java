package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.AlbumArtist;
import com.mozeshajdu.audiotagmanager.entity.Artist;
import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.entity.Genre;
import com.mozeshajdu.audiotagmanager.event.AudioTagMessage;
import com.mozeshajdu.audiotagmanager.service.AlbumArtistService;
import com.mozeshajdu.audiotagmanager.service.ArtistService;
import com.mozeshajdu.audiotagmanager.service.GenreService;
import com.mozeshajdu.audiotagmanager.web.dto.ArtistDto;
import com.mozeshajdu.audiotagmanager.web.dto.AudioTagDto;
import com.mozeshajdu.audiotagmanager.web.dto.GenreDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ArtistService.class, AlbumArtistService.class, GenreService.class})
public interface AudioTagMapper {

    @Mapping(target = "spotifyTrack", ignore = true)
    @Mapping(target = "id", ignore = true)
    AudioTag of(AudioTagMessage source);

    List<AudioTagDto> toDtoList(List<AudioTag> source);

    @Mapping(target = "spotifyTrackId", source = "spotifyTrack.spotifyId")
    AudioTagDto toDto(AudioTag source);

    ArtistDto toDto(Artist source);

    AlbumArtist toDto(AlbumArtist source);

    GenreDto toDto(Genre source);

}
