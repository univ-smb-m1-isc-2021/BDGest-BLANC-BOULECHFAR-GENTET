package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;

    public AlbumService(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbum(String isbn) {
        return albumRepository.findByIsbn(isbn);
    }

    public void addAlbum(String isbn, String title, String img, String serie, String num_serie, List<Contributor> contributorsList) {
        if (!albumRepository.existsById(isbn)) {
            albumRepository.save(new Album(isbn, title, img, serie, num_serie, contributorsList));
        }
    }

    public void addUser(String login, String password, String role, List<Album> albumsList) {
        userRepository.save(new User(login, password, role, albumsList));
    }
}
