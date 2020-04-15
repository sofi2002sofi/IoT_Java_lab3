package ua.lviv.iot.business;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T> {

    protected abstract JpaRepository<T, Integer> getJpaRepository();

    public List<T> findAll() {
        return getJpaRepository().findAll();
    }

    public T findObjectById(Integer id) {
        return getJpaRepository().findById(id).get();
    }

    public T createObject(T object) {
        return getJpaRepository().save(object);
    }

    public boolean existById(Integer id) {
        return getJpaRepository().existsById(id);
    }

    public void deleteById(Integer id) {
        getJpaRepository().deleteById(id);
    }
}
