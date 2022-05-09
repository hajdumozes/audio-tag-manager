package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import com.mozeshajdu.audiotagmanager.event.AudioTagMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ArtistMapper.class, AlbumArtistMapper.class, GenreMapper.class})
public interface AudioTagMapper {

    @Mapping(target = "id", ignore = true)
    AudioTag of(AudioTagMessage source);
}
