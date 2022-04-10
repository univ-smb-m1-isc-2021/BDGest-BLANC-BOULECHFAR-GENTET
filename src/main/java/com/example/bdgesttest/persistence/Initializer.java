package com.example.bdgesttest.persistence;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class Initializer {

    private final AlbumRepository albumRepository;
    private final BDGestUserRepository userRepository;
    private final ContributorRepository contributorRepository;

    public Initializer(AlbumRepository albumRepository, BDGestUserRepository userRepository, ContributorRepository contributorRepository){
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
        this.contributorRepository = contributorRepository;
    }

    @PostConstruct
    public void initialize(){
        if (albumRepository.findAll().isEmpty()) {
            Contributor c1 = new Contributor("Peyo", "dessinateur");
            Contributor c2 = new Contributor("Machin", "editeur");
            Set<Contributor> contributorSet = new HashSet<>();
            contributorSet.add(c1);
            contributorSet.add(c2);
            contributorRepository.saveAndFlush(c1);
            contributorRepository.saveAndFlush(c2);
            Album album1 = new Album("2-8001-0108-3",
                    "Les Schtroumpfs noirs",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfs01_333.jpg",
                    "Les schtroumpfs",
                    "1",
                    contributorSet);
            albumRepository.saveAndFlush(album1);
            albumRepository.saveAndFlush(new Album("2-8001-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("2",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-21-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-8001-32-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("452-8001-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-8001-0103219-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-80321401-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-8045401-0109-1",
                    "Le Schtroumpfissime (+ Schtroumpfonie en ut)",
                    "https://www.bedetheque.com/media/Couvertures/schtroumpfscou02.jpg",
                    "Les schtroumpfs",
                    "2"));
            Set<Album> albumSet = new HashSet<>();
            albumSet.add(album1);
            userRepository.saveAndFlush(new BDGestUser("poupi",
                    "zer",
                    "administrateur",
                    albumSet));
        }
    }
}
