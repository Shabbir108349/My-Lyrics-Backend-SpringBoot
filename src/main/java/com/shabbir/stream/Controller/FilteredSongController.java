package com.shabbir.stream.Controller;

import com.shabbir.stream.Repository;
import com.shabbir.stream.Service.FilteredSongService;
import com.shabbir.stream.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/song")
@CrossOrigin("*")
public class FilteredSongController {

    @Autowired
    private FilteredSongService service;

    @GetMapping("/home/{genre}")
    public ResponseEntity<List<Song>> getSpecificSongHome(@PathVariable String genre){
        return service.getSpecificSongHome(genre);
    }

    @GetMapping("/list/{genre}")
    public ResponseEntity<List<Song>> getSpecificSong(@PathVariable String genre){
        return service.getSpecificSong(genre);
    }

    @GetMapping("/home/popular")
    public ResponseEntity<List<Song>> getPopularSongHome(){
        return service.getPopularSongHome();
    }

    @GetMapping("/list/popular")
    public ResponseEntity<List<Song>> getPopularSong(){
        return service.getPopularSong();
    }


}
