package com.example.bdgesttest.persistence;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Album {
    @Id
    private String isbn;
    private String title, img, serie, num_serie;
    @OneToMany private ArrayList<Contributor> contributorsList;

    public Album(String isbn, String title, String img, String serie, String num_serie, ArrayList<Contributor> contributorsList) {
        this.isbn = isbn;
        this.title = title;
        this.img = img;
        this.serie = serie;
        this.num_serie = num_serie;
        this.contributorsList = contributorsList;
    }

    public Album() {

    }

    @Override
    public String toString() {
        return "Album{" + '\n' +
                "   isbn = " + isbn + '\n' +
                "   title = " + title + '\n' +
                "   img = " + img + '\n' +
                "   serie = " + serie + '\n' +
                "   num_serie = " + num_serie + '\n' +
                "   contributorsList = " + contributorsList + '\n' +
                '}';
    }
}
