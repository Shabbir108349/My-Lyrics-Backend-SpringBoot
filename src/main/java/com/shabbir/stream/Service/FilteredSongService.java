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

import java.util.ArrayList;
import java.util.List;


@Service
public class FilteredSongService {

    @Autowired
    private Repository repository;

    @Autowired
    MongoTemplate template;

    public List<Song> getSpecificSongFromDb(String genre){
        Query q = new Query(Criteria.where("genre").is(genre));
        return template.find(q, Song.class);
    }


    public ResponseEntity<List<Song>> getSpecificSongHome(String genre) {
        List<Song> byIsPopular = getSpecificSongFromDb(genre);
        if(byIsPopular.size() < 5) return new ResponseEntity<>(byIsPopular,HttpStatus.OK);
        List<Song> l = new ArrayList<>();
        for(int i=0; i<5; i++){
            l.add(byIsPopular.get(i));
        }
        return new ResponseEntity<>(l, HttpStatus.OK);
    }


    public ResponseEntity<List<Song>> getSpecificSong(String genre) {
        List<Song> byIsPopular = getSpecificSongFromDb(genre);
        return new ResponseEntity<>(byIsPopular,HttpStatus.OK);
    }

    public ResponseEntity<List<Song>> getPopularSongHome() {
        List<Song> byPopular = repository.findByPopular(true);
        if(byPopular.size() < 5) return new ResponseEntity<>(byPopular,HttpStatus.OK);
        List<Song> l = new ArrayList<>();
        for(int i=0; i<5; i++){
            l.add(byPopular.get(i));
        }
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    public ResponseEntity<List<Song>> getPopularSong() {
        return new ResponseEntity<>(repository.findByPopular(true),HttpStatus.OK);
    }
}
