package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.Album;
import com.example.bdgesttest.persistence.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> albums() {
        return albumRepository.findAll();
    }
}
