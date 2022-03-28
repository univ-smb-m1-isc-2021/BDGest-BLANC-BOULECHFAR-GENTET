package spring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository {

    List<Album> getListAlbum();
    void addAlbum(Album album);

}
