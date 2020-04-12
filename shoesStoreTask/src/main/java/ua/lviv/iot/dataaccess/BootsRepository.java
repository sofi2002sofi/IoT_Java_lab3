package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.shoeStore.model.Boots;

@Repository
public interface BootsRepository extends JpaRepository<Boots, Integer> {

}
