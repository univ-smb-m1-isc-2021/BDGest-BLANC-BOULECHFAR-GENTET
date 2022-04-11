package com.example.bdgesttest.Api;

import com.example.bdgesttest.Service.BDGestService;
import com.example.bdgesttest.persistence.Album;
import com.example.bdgesttest.persistence.BDGestUser;
import com.example.bdgesttest.persistence.Contributor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BDGestController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final BDGestService bdGestService;

    public BDGestController(BDGestService albumService) {
        this.bdGestService = albumService;
    }

    @CrossOrigin
    @GetMapping(value = "/api/getAllAlbums")
    public List<Album> getAllAlbums() {
        logger.info("Service getAlllbums");
        return bdGestService.getAllAlbums();
    }

    @GetMapping(value = "/api/getAlbum")
    @ResponseBody
    public Optional<Album> getAlbum(@RequestParam Long id){
        logger.info("Service getAlbum");
        return bdGestService.getAlbum(id);
    }

    @GetMapping(value = "/api/addAlbum")
    public void addAlbum(String isbn, String title, String img, String serie, String num_serie, ArrayList<Contributor> contributorsList) {
        logger.info("Service addAlbum");
        bdGestService.addAlbum(isbn, title, img, serie, num_serie);
    }

    @GetMapping(value = "/api/scrapAlbum")
    public Album scrapAlbum(@RequestParam String url) throws IOException {
        logger.info("Service scrapAlbum");
        Album album = bdGestService.scrapAlbum(url);
        bdGestService.addAlbum(album.getIsbn(), album.getTitle(), album.getImg(), album.getSerie(), album.getNum_serie());
        return album;
    }

    @GetMapping(value = "/api/scrapSerie")
    public int scrapSerie(@RequestParam String url) throws IOException {
        logger.info("Service scrapSerie");
        int nbScraps = bdGestService.scrapSerie(url);
        return nbScraps;
    }

    @GetMapping(value = "/api/scrapNbAlbums")
    public int scrapNbAlbums(@RequestParam int nb) throws IOException {
        logger.info("Service scrapNbAlbums");
        int nbScraps = bdGestService.scrapNbAlbums(nb);
        return nbScraps;
    }

    @GetMapping(value = "/api/addUser")
    public void addUser(@RequestParam String login, @RequestParam String password, @RequestParam String role) {
        logger.info("Service addUser");
        bdGestService.addUser(login, password, role);
    }

    @GetMapping(value = "/api/check")
    public BDGestUser getUser(@RequestParam String login, @RequestParam String password) {
        logger.info("Service checkUser");
        BDGestUser bdGestUser = bdGestService.getUser(login);
        if (bdGestUser != null && bdGestUser.getPassword().equals(password)){
            return bdGestUser;
        } else {
            return new BDGestUser((long) -1);
        }
    }

    @GetMapping(value = "/api/addAlbumToUser")
    public boolean addAlbumToUser(@RequestParam Long id_user, @RequestParam Long id_album){
        return bdGestService.addAlbumToUser(id_user, id_album);
    }

}
