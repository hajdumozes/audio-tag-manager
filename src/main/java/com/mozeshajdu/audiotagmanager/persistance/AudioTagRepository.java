package com.mozeshajdu.audiotagmanager.persistance;

import com.mozeshajdu.audiotagmanager.entity.AudioTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AudioTagRepository extends JpaRepository<AudioTag, Long> {
}