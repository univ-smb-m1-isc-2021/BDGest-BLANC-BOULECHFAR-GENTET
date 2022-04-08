package com.example.bdgesttest.persistence;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class Initializer {
    private final AlbumRepository albumRepository;

    public Initializer(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    public void initial(){
        if (albumRepository.findAll().isEmpty()){
            albumRepository.saveAndFlush(new Album("2-8001-0108-3",
                    "Les Schtroumpfs noirs",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfs01_333.jpg",
                    "Les schtroumpfs",
                    "1",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("2-8001-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
        }
    }
}
