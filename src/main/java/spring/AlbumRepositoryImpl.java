package spring;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class AlbumRepositoryImpl implements AlbumRepository {

    final @NonNull EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Album> getListAlbum() {
        return em.createQuery("SELECT a FROM Album a")
                .getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addAlbum(Album album) {
        em.persist(album);
    }

}
