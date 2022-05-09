package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.event.AudioTagMessage;
import com.mozeshajdu.audiotagmanager.service.AlbumArtistService;
import com.mozeshajdu.audiotagmanager.service.ArtistService;
import com.mozeshajdu.audiotagmanager.service.GenreService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ArtistService.class, AlbumArtistService.class, GenreService.class})
public interface AudioTagMapper {

    @Mapping(target = "id", ignore = true)
    AudioTag of(AudioTagMessage source);
}
