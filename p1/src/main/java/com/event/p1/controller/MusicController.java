package com.event.p1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.event.p1.entity.Music;
import com.event.p1.service.MusicService;

@RestController
@RequestMapping("/music")
public class MusicController {
    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/all")
    public List<Music> getAllMusic() {
        return musicService.getAllMusic();
    }

    @GetMapping("/{id}")
    public Music getMusicById(@PathVariable Long id) {
        return musicService.getMusicById(id);
    }

    @PostMapping("/create")
    public Music createMusic(@RequestBody Music music) {
        return musicService.saveMusic(music);
    }

    @PutMapping("/update/{id}")
    public Music updateMusic(@PathVariable Long id, @RequestBody Music newMusicData) {
        return musicService.updateMusic(id, newMusicData);
    }

    @DeleteMapping("/{id}")
    public String deleteMusic(@PathVariable Long id) {
        musicService.deleteMusic(id);
        return "Music deleted successfully!";
    }
}

