package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class BDGestService {

    private final AlbumRepository albumRepository;
    private final BDGestUserRepository bdgestRepository;

    public BDGestService(AlbumRepository albumRepository, BDGestUserRepository bdgestRepository) {
        this.albumRepository = albumRepository;
        this.bdgestRepository = bdgestRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Optional<Album> getAlbum(Long id) {
        return albumRepository.findById(id);
    }

    public boolean isNotNull(String str){
        return str != null && !str.equals("");
    }
    public boolean isValid(String isbn, String title, String img, String serie, String num_serie){
        return isNotNull(isbn) && isNotNull(title) && isNotNull(img) && isNotNull(serie) && isNotNull(num_serie);
    }
    // returns true if album added, false if not added
    public boolean addAlbum(String isbn, String title, String img, String serie, String num_serie) {
        if (isValid(isbn, title, img, serie, num_serie)) {
            albumRepository.save(new Album(isbn, title, img, serie, num_serie));
            return true;
        }
        return false;
    }

    public boolean addUser(String login, String password, String role) {
        if(bdgestRepository.findBDGestUserByLogin(login) == null){
            bdgestRepository.save(new BDGestUser(login, password, role));
            return true;
        } else {
            return false;
        }
    }

    public boolean remUser(Long id_user){
        if (bdgestRepository.existsById(id_user)){
            Optional<BDGestUser> album = bdgestRepository.findById(id_user);
            album.ifPresent(bdgestRepository::delete);
            return true;
        } else {
            return false;
        }

    }

    public BDGestUser getUser(String login) {
        return bdgestRepository.findBDGestUserByLogin(login);
    }

    public boolean addAlbumToUser(Long id_user, Long id_album){
        if(!albumRepository.existsById(id_album) || !bdgestRepository.existsById(id_user)){
            return false;
        } else {
            Album album = albumRepository.getById(id_album);
            BDGestUser bdGestUser = bdgestRepository.getById(id_user);
            bdGestUser.addUserAlbum(album);
            bdgestRepository.save(bdGestUser);
            return true;
        }
    }

    public boolean remAlbumFromUser(Long id_user, Long id_album){
        if(!albumRepository.existsById(id_album) || !bdgestRepository.existsById(id_user)){
            return false;
        } else {
            Album album = albumRepository.getById(id_album);
            BDGestUser bdGestUser = bdgestRepository.getById(id_user);
            bdGestUser.remUserAlbum(album);
            bdgestRepository.save(bdGestUser);
            return true;
        }
    }

    public Set<Album> getAlbumsById(Long id_user){
        return bdgestRepository.getById(id_user).getUserAlbum();
    }

    // Scrap an album from a given url at www.bedetheque.com
    public Album scrapAlbum(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        String isbn = doc.select("span[itemprop = isbn]").text();
        String[] info_title = doc.select("div.bandeau-info > h2").text().split("\\. ");
        String num_serie, title, serie;
        if(info_title.length == 1){
            // no further infos
            title = doc.select("div.bandeau-info > h1 > a").text();
            serie = title;
            num_serie = "";
        } else {
            // more infos
            num_serie = info_title[0];
            title = info_title[1];
            serie = doc.select("div.bandeau-info > h1").text();
        }
        String img = doc.select("a.zoom-format-icon").attr("href");
        String[] parts = doc.select("div.liste-auteurs").text().split("(?<=\\) )");
        ArrayList<Contributor> contributors = new ArrayList<>();
        if (parts[0].length() > 0) {
            for (int i = 0; i < parts.length; i++) {
                String[] infos = parts[i].split("\\(|\\)");
                if (!infos[0].equals("<Indéterminé> ")) {
                    contributors.add(new Contributor(infos[0], infos[1]));
                }
            }
        }
        boolean res = this.addAlbum(isbn, title, img, serie, num_serie);
        if (res){
            return new Album(isbn, title, img, serie, num_serie);
        }
        return null;
    }

    // Scrap a serie
    public int scrapSerie(String url) throws IOException {
        System.out.println("scrapSerie : " + url);
        Document doc = Jsoup.connect(url).get();
        int nb_albums_total = Integer.parseInt(doc.select("i.icon-book").first().nextSibling().toString().split(" ")[1]);
        int nb_albums_added = 0;
        String link_tome;
        Album album;
        if(nb_albums_total > 1) {
            for (Element element : doc.select("ul.liste-albums-side > li > a")) {
                link_tome = element.attr("href");
                album = this.scrapAlbum(link_tome);
                if (album != null){
                    nb_albums_added++;
                }
            }
        } else {
            link_tome = doc.select("a.titre").attr("href");
            this.scrapAlbum(link_tome);
            album = this.scrapAlbum(link_tome);
            if (album != null){
                nb_albums_added++;
            }
        }
        return nb_albums_added;
    }

    public String getRandomSerie() throws IOException {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int length = alphabet.length();
        Random random = new Random();
        String randomLetter = String.valueOf(alphabet.charAt(random.nextInt(length))).toUpperCase();
        String url = "https://www.bedetheque.com/bandes_dessinees_" + randomLetter + ".html";
        Document doc = Jsoup.connect(url).get();
        Elements series = doc.select("ul.nav-liste > li > a");
        System.out.println(series.size());
        System.out.println(url);
        System.out.println("nb : " + doc.select("span.sous-titre-texte").text());
        //int nbAlbums = Integer.valueOf(doc.select("span.sous-titre-texte").text().split(" ")[0]);
        return series.get(random.nextInt(series.size())).attr("href");
    }

    //scrap albums until reach max
    public int scrapNbAlbums(int max) throws IOException {
        if (max <= 5000){
            int nbScrap = 0;
            String serie;
            while (nbScrap< max) {
                serie = getRandomSerie();
                nbScrap += scrapSerie(serie);
            }
            return nbScrap;
        } else {
            return 0;
        }

    }
}
