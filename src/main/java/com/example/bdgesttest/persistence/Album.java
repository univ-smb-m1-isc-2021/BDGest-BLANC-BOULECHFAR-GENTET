package com.example.bdgesttest.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    // Attributs

    @Id
    private String isbn;
    private String title;
    private String img;
    private String serie;
    private String num_serie;
    @OneToMany
    private List<Contributor> contributorsList;

    // Constructeurs

    public Album(String isbn, String title, String img, String serie, String num_serie, List<Contributor> contributorsList) {
        this.isbn = isbn;
        this.title = title;
        this.img = img;
        this.serie = serie;
        this.num_serie = num_serie;
        this.contributorsList = contributorsList;
    }

    public Album() {}

    // Methodes

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNum_serie() {
        return this.num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public List<Contributor> getContributorsList() {
        return this.contributorsList;
    }

    public void setContributorsList(List<Contributor> contributorsList) {
        this.contributorsList = contributorsList;
    }

    @Override
    public String toString() {
        return "Album {\n" +
                "   isbn = "+this.isbn+"\n" +
                "   title = "+this.title+"\n" +
                "   img = "+this.img+"\n" +
                "   serie = "+this.serie+"\n" +
                "   num_serie = "+this.num_serie+"\n" +
                "   contributorsList = "+this.contributorsList+"\n" +
                "}\n";
    }
}
