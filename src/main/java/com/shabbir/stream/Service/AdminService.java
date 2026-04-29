package com.shabbir.stream.Service;

import com.shabbir.stream.Repository;
import com.shabbir.stream.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    private Repository repository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public ResponseEntity<String> addSong(Song song) {
        song.setSongId(UUID.randomUUID().toString());
        song.setDateTime(LocalDateTime.now());
        Song save = repository.save(song);

        if(save != null) return new ResponseEntity<>("Created", HttpStatus.CREATED);
        return new ResponseEntity<>("Not added",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Song>> getAllSong() {
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Boolean> deleteSongById(String id){
        Query query = new Query(Criteria.where("songId").is(id));
        Song song = mongoTemplate.findAndRemove(query, Song.class);
        return new ResponseEntity<>(song != null,HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<String> updateSongById(String id,Song updateSong) {
        Song songIdDb = repository.findBySongId(id);
        if(songIdDb != null){
            songIdDb.setTitle(updateSong.getTitle());
            songIdDb.setArtist(updateSong.getArtist());
            songIdDb.setComposer(updateSong.getComposer());
            songIdDb.setLyrics(updateSong.getLyrics());
            songIdDb.setGenre(updateSong.getGenre());
            songIdDb.setLanguage(updateSong.getLanguage());
            songIdDb.setLabel(updateSong.getLabel());
            songIdDb.setLyrics(updateSong.getLyrics());
            songIdDb.setPopular(updateSong.isPopular());
            songIdDb.setVideoId(updateSong.getVideoId());
            songIdDb.setDateTime(LocalDateTime.now());
            repository.save(songIdDb);
            return new ResponseEntity<>("update Successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Something Went Wrong",HttpStatus.BAD_REQUEST);
    }
}
