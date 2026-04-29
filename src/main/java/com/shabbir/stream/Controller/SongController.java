package com.shabbir.stream.Controller;

import com.shabbir.stream.Service.SongService;
import com.shabbir.stream.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SongController {

    @Autowired
    private SongService service;
    @GetMapping("/health")
    public String check(){
        return "OK";
    }


    @GetMapping("/get-song-by-id/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable String id){
        return service.getSongById(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Song>> universalSearch(@RequestParam String query) {
        return service.universalSearch(query);
    }

    @GetMapping("/get-song-by-genre/{genre}")
    public ResponseEntity<List<Song>> getSongByGenre(@PathVariable String genre){
        return service.getSongByGenre(genre);
    }

    @GetMapping("/get-recommend-song/{genre}/{id}")
    public ResponseEntity<List<Song>> getRecommendedSong(
            @PathVariable String genre,
            @PathVariable String id
    ){
        return service.getRecommendedSong(genre,id);
    }

}
