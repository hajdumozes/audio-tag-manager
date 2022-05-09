package com.mozeshajdu.audiotagmanager.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Table(name = "album_artist")
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AlbumArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name", nullable = false, unique = true)
    String name;

    @ManyToMany(mappedBy = "albumArtists", fetch = FetchType.EAGER)
    Set<AudioTag> audioTags;
}
