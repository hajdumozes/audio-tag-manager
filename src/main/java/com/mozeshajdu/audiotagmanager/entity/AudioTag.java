package com.mozeshajdu.audiotagmanager.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
import javax.persistence.UniqueConstraint;
import java.util.Set;

@Table(name = "audio_tag", uniqueConstraints = {@UniqueConstraint(columnNames = {"title", "album", "year"})})
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AudioTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title", nullable = false)
    String title;

    @Column(name = "album", nullable = false)
    String album;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "audio_tag_artist",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "audio_tag_id")),
            inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "artist_id")))
    Set<Artist> artists;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "audio_tag_album_artist",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "audio_tag_id")),
            inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "album_artist_id")))
    Set<AlbumArtist> albumArtists;

    @Column(name = "year")
    String year;

    @Column(name = "track")
    String track;

    @Column(name = "composer")
    String composer;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "audio_tag_genre",
            joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "audio_tag_id")),
            inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "genre_id")))
    Set<Genre> genres;

    @Column(name = "grouping")
    String grouping;

    @OneToOne
    @JoinColumn(name = "spotify_track_id", referencedColumnName = "id")
    SpotifyTrack spotifyTrack;
}

