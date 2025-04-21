package com.event.p1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.event.p1.entity.Music;
import com.event.p1.repository.MusicRepository;

@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getAllMusic() {
        return musicRepository.findAll();
    }

    public Music getMusicById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }

    public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }

    public Music updateMusic(Long id, Music newMusicData) {
        Music existingMusic = musicRepository.findById(id).orElse(null);
        if (existingMusic != null) {
            existingMusic.setName(newMusicData.getName());
            existingMusic.setPrice(newMusicData.getPrice());
            return musicRepository.save(existingMusic);
        }
        return null;
    }

    public void deleteMusic(Long id) {
        musicRepository.deleteById(id);
    }
}
