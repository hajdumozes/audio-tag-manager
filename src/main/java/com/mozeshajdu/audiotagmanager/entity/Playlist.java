package com.mozeshajdu.audiotagmanager.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Table(name = "playlist")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "spotify_id", nullable = false, unique = true)
    String spotifyId;

    @Column(name = "name")
    String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "playlist_spotify_track",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "playlist_id")),
            inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "spotify_track_id")))
    List<SpotifyTrack> tracks;

    @Column(name = "url")
    String url;
}
