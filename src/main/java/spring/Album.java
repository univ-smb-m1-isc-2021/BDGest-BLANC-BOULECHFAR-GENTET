package spring;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;

@Entity public class Album extends AbstractPersistable<Long> {

    // Attributs

    @Column(unique = true) private String isbn;
    private String title;
    private String img;
    private String serie;
    private String num_serie;
    @OneToMany private ArrayList<Contributor> contributorsList;

    // Constructeurs

    public Album() {}

    public Album(Long id_album) {
        this.setId(id_album);
    }

    public Album(String isbn, String title, String img, String serie, String num_serie, ArrayList<Contributor> contributorsList) {
        this.isbn = isbn;
        this.title = title;
        this.img = img;
        this.serie = serie;
        this.num_serie = num_serie;
        this.contributorsList = contributorsList;
    }

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

    public ArrayList<Contributor> getContributorsList() {
        return this.contributorsList;
    }

    public void setContributorsList(ArrayList<Contributor> contributorsList) {
        this.contributorsList = contributorsList;
    }

}
