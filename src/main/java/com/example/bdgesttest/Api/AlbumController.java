package com.example.bdgesttest.Api;

import com.example.bdgesttest.Service.AlbumService;
import com.example.bdgesttest.persistence.Album;
import com.example.bdgesttest.persistence.Contributor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class AlbumController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(value = "/api/getAllAlbums")
    public List<Album> getAllAlbums() {
        logger.info("Service getAlllbums");
        return new ArrayList<>(albumService.getAllAlbums());
    }

    @GetMapping(value = "/api/getAlbum")
    public Album getAlbum(@RequestParam String isbn){
        logger.info("Service getAlbum");
        return albumService.getAlbum(isbn);
    }

    @GetMapping(value = "/api/addAlbum")
    public void addAlbum(String isbn, String title, String img, String serie, String num_serie, ArrayList<Contributor> contributorsList) {
        logger.info("Service addAlbum");
        albumService.addAlbum(isbn, title, img, serie, num_serie, contributorsList);
    }
}
