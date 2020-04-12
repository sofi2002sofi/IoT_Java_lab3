package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.shoeStore.model.Heels;

@Repository
public interface HeelsRepository extends JpaRepository<Heels, Integer> {

}
