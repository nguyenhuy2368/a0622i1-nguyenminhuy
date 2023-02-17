package com.example.service;

import com.example.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    void save(Music music);
    void update(int id,Music music);
    void remove(int id);
    Music findById(int id);
}
