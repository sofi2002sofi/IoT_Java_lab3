package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.BootsProducerRepository;
import ua.lviv.iot.shoeStore.model.BootsProducer;

@Service
public class BootsProducerService extends AbstractService<BootsProducer> {

    @Autowired
    private BootsProducerRepository bootsProducerRepository;

    @Override
    public BootsProducerRepository getJpaRepository() {
        return bootsProducerRepository;
    }

}
