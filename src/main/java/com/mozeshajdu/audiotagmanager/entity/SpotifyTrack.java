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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Table(name = "spotify_track")
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SpotifyTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "spotify_id", nullable = false, unique = true)
    String spotifyId;

    @Column(name = "name")
    String name;

    @Column(name = "album")
    String album;

    @Column(name = "release_date")
    String releaseDate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "spotify_track_artist",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "spotify_track_id")),
            inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "artist_id")))
    List<Artist> artists;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "spotify_track_playlist",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "spotify_track_id")),
            inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "playlist_id")))
    List<Playlist> playlists;

    @Column(name = "popularity")
    Integer popularity;

    @Column(name = "track_number")
    String trackNumber;

    @Column(name = "url")
    String url;

    @Column(name = "liked", columnDefinition = "boolean default false")
    Boolean liked;

    @OneToOne
    @JoinColumn(name = "audio_tag_id", referencedColumnName = "id")
    AudioTag audioTag;
}
