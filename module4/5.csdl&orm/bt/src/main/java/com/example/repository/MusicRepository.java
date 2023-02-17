package com.example.repository;

import com.example.model.Music;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        List<Music> musicList = new ArrayList<>();
        TypedQuery<Music> query = entityManager.createQuery("from Music", Music.class);
        musicList = query.getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        entityManager.persist(music);
    }

    @Override
    public void update(int id, Music music) {
        Music musicUpdate = findById(music.getId());
        musicUpdate.setName(music.getName());
        musicUpdate.setArtist(music.getArtist());
        musicUpdate.setCategory(music.getCategory());
        musicUpdate.setLink(music.getLink());
        entityManager.merge(musicUpdate);
    }

    @Override
    public void remove(int id) {
        Music musicDelete = findById(id);
        entityManager.remove(musicDelete);
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }
}
