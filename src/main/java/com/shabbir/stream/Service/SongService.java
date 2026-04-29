package com.shabbir.stream.Service;

import com.shabbir.stream.Repository;
import com.shabbir.stream.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class SongService {

    @Autowired
    private Repository repository;
    @Autowired
    private MongoTemplate template;

    public ResponseEntity<Song> getSongById(String id){
        Song songIdDb = repository.findBySongId(id);
        if(songIdDb != null){
            return new ResponseEntity<>(songIdDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<Song>> getSongByGenre(String genre) {
        Query q = new Query(Criteria.where("genre").is(genre));
        List<Song> songs = template.find(q, Song.class);
        if(songs.size() < 5) return new ResponseEntity<>(songs, HttpStatus.OK);
        List<Song> l = new ArrayList<>();
        for(int i=0; i<5; i++){
            l.add(songs.get(i));
        }
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    public ResponseEntity<List<Song>> getRecommendedSong(String genre, String id) {
        Query q = new Query(Criteria.where("genre").is(genre));
        List<Song> songs = template.find(q, Song.class);
        boolean b = songs.removeIf(x -> x.getSongId().equals(id));

        if(songs.size() < 5) return new ResponseEntity<>(songs,HttpStatus.OK);
        else{
            List<Song> l = new ArrayList<>();
            for(int i=0; i<5; i++){
                l.add(songs.get(i));
            }
            return new ResponseEntity<>(l,HttpStatus.OK);
        }

    }


    public ResponseEntity<List<Song>> universalSearch(String query) {
        List<Song> songs = repository.searchSongs(query);
        if (!songs.isEmpty()) return new ResponseEntity<>(songs,HttpStatus.OK);
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }



}
