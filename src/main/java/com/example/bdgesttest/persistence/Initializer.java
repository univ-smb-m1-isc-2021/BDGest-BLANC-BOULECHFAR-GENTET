package com.example.bdgesttest.persistence;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Service
public class Initializer {

    private final AlbumRepository albumRepository;
    private final BDGestUserRepository userRepository;

    public Initializer(AlbumRepository albumRepository, BDGestUserRepository userRepository){
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initialize(){
        if (albumRepository.findAll().isEmpty()) {
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
            albumRepository.saveAndFlush(new Album("2",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("2-21-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("2-8001-32-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("452-8001-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("2-8001-0103219-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("2-80321401-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            albumRepository.saveAndFlush(new Album("2-8045401-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2",
                    new ArrayList<>()));
            userRepository.saveAndFlush(new BDGestUser("poupi",
                    "zer",
                    "administrateur"));
        }
    }
}
