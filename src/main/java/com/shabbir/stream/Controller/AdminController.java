package com.shabbir.stream.Controller;

import com.shabbir.stream.Service.AdminService;
import com.shabbir.stream.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shabbir")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/add-song")
    public ResponseEntity<String> addSong(@RequestBody Song song){
        return service.addSong(song);
    }

    @GetMapping("/get-all-song")
    public ResponseEntity<List<Song>> getAllSong(){
        return service.getAllSong();
    }

    @DeleteMapping("/delete-song/{id}")
    public ResponseEntity<Boolean> deleteSongById(@PathVariable String id){
        return service.deleteSongById(id);
    }

    @PutMapping("/update-song-by-id/{id}")
    public ResponseEntity<String> updateSongById(@PathVariable String id,@RequestBody Song song){
        return service.updateSongById(id,song);
    }
}
