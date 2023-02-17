package com.example.repository;

import com.example.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();
    void save(Music music);
    void update(int id,Music music);
    void remove(int id);
    Music findById(int id);
}
