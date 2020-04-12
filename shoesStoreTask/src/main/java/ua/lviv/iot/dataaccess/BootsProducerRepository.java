package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.shoeStore.model.BootsProducer;

@Repository
public interface BootsProducerRepository extends JpaRepository<BootsProducer, Integer> {

}
