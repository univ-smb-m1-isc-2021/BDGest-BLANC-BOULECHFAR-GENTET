package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.Album;
import com.example.bdgesttest.persistence.AlbumRepository;
import com.example.bdgesttest.persistence.Contributor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public void addAlbum(String isbn, String title, String img, String serie, String num_serie, ArrayList<Contributor> contributorsList) {
        if (!albumRepository.existsById(isbn)) {
            albumRepository.save(new Album(isbn, title, img, serie, num_serie, contributorsList));
        }
    }
}
