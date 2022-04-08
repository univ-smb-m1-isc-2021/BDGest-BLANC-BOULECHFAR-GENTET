package com.example.bdgesttest.Api;

import com.example.bdgesttest.Service.AlbumService;
import com.example.bdgesttest.persistence.Album;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class AlbumController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(value = "/api/AllAlbums")
    public List<Album> albums(){
        logger.info("Service Albums");
        return albumService.albums().stream().collect(toList());
    }
}
