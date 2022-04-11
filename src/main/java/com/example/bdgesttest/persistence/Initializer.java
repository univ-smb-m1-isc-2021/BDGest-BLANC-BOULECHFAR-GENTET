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
            albumRepository.saveAndFlush(new Album("2-258-03431-0 ",
                    "Adieu, monde cruel !",
                    "https://www.bedetheque.com/media/Couvertures/Couv_40205.jpg",
                    "Calvin et Hobbes",
                    "1"));
            albumRepository.saveAndFlush(new Album("2-258-03438-8 ",
                    "En avant, tête de thon !",
                    "https://www.bedetheque.com/media/Couvertures/CalvinEtHobbes2_12112004.jpg",
                    "Calvin et Hobbes",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-258-03486-8",
                    "On est fait comme des rats !",
                    "https://www.bedetheque.com/media/Couvertures/CalvinEtHobbes3_12112004.jpg",
                    "Calvin et Hobbes",
                    "3"));
            albumRepository.saveAndFlush(new Album("2-258-03487-6 ",
                    "Debout, tas de nouilles !",
                    "https://www.bedetheque.com/media/Couvertures/CalvinEtHobbes4_12112004.jpg",
                    "Les schtroumpfs",
                    "4"));
            albumRepository.saveAndFlush(new Album("2-87442-103-0",
                    "A la chasse aux fantômes",
                    "https://www.bedetheque.com/media/Couvertures/Scoobydoo1_10062007_193454.jpg",
                    "Scooby-Doo !",
                    "1"));
            albumRepository.saveAndFlush(new Album("2-87442-236-3",
                    "Pas de panique !",
                    "https://www.bedetheque.com/media/Couvertures/Scoobydoo2_11052006.jpg",
                    "Scooby-Doo !",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-87442-296-7 ",
                    "Ouh là là !",
                    "https://www.bedetheque.com/media/Couvertures/Scoobydoo3_04012008_225344.jpg",
                    "Scooby-Doo !",
                    "3"));
            albumRepository.saveAndFlush(new Album("2-87442-296-7 ",
                    "Suivez ce monstre !",
                    "https://www.bedetheque.com/media/Couvertures/Couv_124827.jpg",
                    "Scooby-Doo !",
                    "4"));
            albumRepository.saveAndFlush(new Album("2-203-00100-3 ",
                    "Tintin au pays des Soviets",
                    "https://www.bedetheque.com/media/Couvertures/TintinActuelSoviets.jpg",
                    "Tintin",
                    "1"));
            albumRepository.saveAndFlush(new Album("2-203-00101-1 ",
                    "Tintin au Congo",
                    "https://www.bedetheque.com/media/Couvertures/tintinactuel02_22012004.jpg",
                    "Tintin",
                    "2"));
            albumRepository.saveAndFlush(new Album("2-203-00102-X ",
                    "Tintin en Amérique",
                    "https://www.bedetheque.com/media/Couvertures/tintinactuel03_22012004.jpg",
                    "Tintin",
                    "3"));
            albumRepository.saveAndFlush(new Album("2-203-00103-8 ",
                    "Les cigares du pharaon",
                    "https://www.bedetheque.com/media/Couvertures/TintinActuelSoviets.jpg",
                    "Tintin",
                    "4"));
            Set<Album> albumSet = new HashSet<>();
            albumSet.add(album1);
            userRepository.saveAndFlush(new BDGestUser("poupi",
                    "zer",
                    "administrateur",
                    albumSet));
        }
    }
}
