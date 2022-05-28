package com.mozeshajdu.audiotagmanager.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.util.Strings;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AudioTagQuery {
    String title = Strings.EMPTY;
    Integer ratingAtLeast = 0;
}
