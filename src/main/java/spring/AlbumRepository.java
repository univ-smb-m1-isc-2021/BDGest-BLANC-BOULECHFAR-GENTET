package spring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumRepository {

    public List<Album> getListAlbum();
    public void addAlbum(Album album);

}
