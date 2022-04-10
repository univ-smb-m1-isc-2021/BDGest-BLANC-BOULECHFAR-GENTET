package com.example.bdgesttest.Api;

import com.example.bdgesttest.Service.BDGestService;
import com.example.bdgesttest.persistence.Album;
import com.example.bdgesttest.persistence.Contributor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BDGestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final BDGestService bdGestService;

    public BDGestController(BDGestService albumService) {
        this.bdGestService = albumService;
    }

    @GetMapping(value = "/api/getAllAlbums")
    public List<Album> getAllAlbums() {
        logger.info("Service getAlllbums");
        return new ArrayList<>(bdGestService.getAllAlbums());
    }

    @GetMapping(value = "/api/getAlbum")
    @ResponseBody
    public Album getAlbum(@RequestParam String isbn){
        logger.info("Service getAlbum");
        return bdGestService.getAlbum(isbn);
    }

    @GetMapping(value = "/api/addAlbum")
    public void addAlbum(String isbn, String title, String img, String serie, String num_serie, ArrayList<Contributor> contributorsList) {
        logger.info("Service addAlbum");
        bdGestService.addAlbum(isbn, title, img, serie, num_serie, contributorsList);
    }

    @GetMapping(value = "/api/addUser")
    public void addUser(@RequestParam String login, @RequestParam String password, @RequestParam String role) {
        logger.info("Service addUser");
        bdGestService.addUser(login, password, role, new ArrayList<>());
    }

}
