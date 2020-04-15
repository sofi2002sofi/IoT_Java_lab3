package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.BootsRepository;
import ua.lviv.iot.shoeStore.model.Boots;

@Service
public class BootsService extends AbstractService<Boots> {

    @Autowired
    private BootsRepository bootsRepository;

    @Override
    public BootsRepository getJpaRepository() {
        return bootsRepository;
    }
}
