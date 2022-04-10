package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

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

    public Album getAlbum(String isbn) {
        return albumRepository.findByIsbn(isbn);
    }

    public boolean isNotNull(String str){
        return str != null && !str.equals("");
    }
    public boolean isValid(String isbn, String title, String img, String serie, String num_serie){
        return isNotNull(isbn) && isNotNull(title) && isNotNull(img) && isNotNull(serie) && isNotNull(num_serie);
    }
    // returns true if album added, false if not added
    public boolean addAlbum(String isbn, String title, String img, String serie, String num_serie) {
        if (!albumRepository.existsById(isbn) && isValid(isbn, title, img, serie, num_serie)) {
            albumRepository.save(new Album(isbn, title, img, serie, num_serie, new ArrayList<>()));
            return true;
        }
        return false;
    }

    public void addUser(String login, String password, String role, List<Album> albumsList) {
        bdgestRepository.save(new BDGestUser(login, password, role));
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
            return new Album(isbn, title, img, serie, num_serie, contributors);
        }
        return null;
    }

    public int scrapSerie(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        int nb_albums_total = Integer.parseInt(doc.select("i.icon-book").first().nextSibling().toString().split(" ")[1]);
        int nb_albums_added = 0;
        String link_tome;
        Album album;
        boolean valid;
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
        int nbAlbums = Integer.valueOf(doc.select("span.sous-titre-texte").text().split(" ")[0]);
        return doc.select("ul.nav-liste > li > a").get(1).attr("href");
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
