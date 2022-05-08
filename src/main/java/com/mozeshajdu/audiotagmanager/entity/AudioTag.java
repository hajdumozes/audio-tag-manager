package com.mozeshajdu.audiotagmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "audio_tag")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AudioTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    @Column(name = "title", nullable = false)
    String title;
}
