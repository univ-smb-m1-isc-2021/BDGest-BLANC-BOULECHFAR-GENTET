package com.example.bdgesttest.spring;

import java.util.List;

public interface AlbumRepository {

    public List<Album> getListAlbum();
    public void addAlbum(Album album);

}
