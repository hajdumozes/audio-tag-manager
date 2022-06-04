package com.mozeshajdu.audiotagmanager.mapper;

import com.mozeshajdu.audiotagmanager.entity.Playlist;
import com.mozeshajdu.audiotagmanager.event.entity.PlaylistCreatedMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "spotifyId", source = "id")
    Playlist of(PlaylistCreatedMessage source);
}
