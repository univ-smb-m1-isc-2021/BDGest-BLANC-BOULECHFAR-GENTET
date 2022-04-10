package com.example.bdgesttest.persistence;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "album")
public class Album {

    // Attributs
    @Id
    @Column(name="id_album", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String img;
    private String serie;
    private String num_serie;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "contributorAlbum",
            joinColumns = { @JoinColumn(name = "id_album") },
            inverseJoinColumns = { @JoinColumn(name = "id_contributor") })
    private Set<Contributor> contributorAlbum = new HashSet<>();

    @ManyToMany(mappedBy = "userAlbum", cascade = CascadeType.MERGE)
    private Set<BDGestUser> userAlbum = new HashSet<>();


    // Constructeurs
    public Album(String isbn, String title, String img, String serie, String num_serie) {
        this.isbn = isbn;
        this.title = title;
        this.img = img;
        this.serie = serie;
        this.num_serie = num_serie;
    }

    public Album() {}

    public Album(String isbn, String title, String img, String serie, String num_serie, Set<Contributor> contributorSet) {
        this.isbn = isbn;
        this.title = title;
        this.img = img;
        this.serie = serie;
        this.num_serie = num_serie;
        this.contributorAlbum = contributorSet;
    }

    // Methodes

    public Long getId_album() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<Contributor> getContributors() {
        return contributorAlbum;
    }

    public void setContributors(Set<Contributor> contributors) {
        this.contributorAlbum = contributors;
    }

    public void addContributor(Contributor contributor){
        this.contributorAlbum.add(contributor);
    }

    @Override
    public String toString() {
        return "Album {\n" +
                "   isbn = "+this.isbn+"\n" +
                "   title = "+this.title+"\n" +
                "   img = "+this.img+"\n" +
                "   serie = "+this.serie+"\n" +
                "   num_serie = "+this.num_serie+"\n" +
                "   contributors = "+"\n" +
                "}\n";
    }
}
