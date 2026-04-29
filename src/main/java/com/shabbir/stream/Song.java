package com.shabbir.stream;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "songs")
public class Song {
    @Id
    private ObjectId id;
    private String songId;
    private String title;
    private String artist;
    private String composer;
    private String lyricist;
    private String genre;
    private String language;
    private String label;
    private String videoId;
    private String lyrics;
    private boolean popular;
    private LocalDateTime dateTime;

}
