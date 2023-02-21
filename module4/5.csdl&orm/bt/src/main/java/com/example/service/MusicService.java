package com.example.service;

import com.example.model.Music;
import com.example.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void update(int id, Music music) {
        musicRepository.update(id, music);
    }

    @Override
    public void remove(int id) {
        musicRepository.remove(id);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id);
    }
}