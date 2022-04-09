package com.example.bdgesttest.spring;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@SuppressWarnings("unchecked")
public class AlbumRepositoryImpl implements AlbumRepository {

    final @NonNull EntityManager em;

    @Override
    public List<Album> getListAlbum() {
        return em.createQuery("SELECT a FROM Album a")
                .getResultList();
    }

    @Override
    public void addAlbum(Album album) {
        em.persist(album);
    }

}
