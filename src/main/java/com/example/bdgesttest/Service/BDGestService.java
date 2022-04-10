package com.example.bdgesttest.Service;

import com.example.bdgesttest.persistence.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void addAlbum(String isbn, String title, String img, String serie, String num_serie, List<Contributor> contributorsList) {
        if (!albumRepository.existsById(isbn)) {
            albumRepository.save(new Album(isbn, title, img, serie, num_serie, contributorsList));
        }
    }

    public void addUser(String login, String password, String role, List<Album> albumsList) {
        bdgestRepository.save(new BDGestUser(login, password, role));
    }

    // Scrap an album from a given url at www.bedetheque.com
    public static Album scrapAlbum(String url) throws IOException {
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
        return new Album(isbn, title, img, serie, num_serie, contributors);
    }
}
