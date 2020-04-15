package ua.lviv.iot.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.BootsFunctionRepository;
import ua.lviv.iot.shoeStore.model.BootsFunction;

@Service
public class BootsFunctionService extends AbstractService<BootsFunction> {

    @Autowired
    private BootsFunctionRepository bootsFunctionRepository;

    @Override
    protected BootsFunctionRepository getJpaRepository() {
        return bootsFunctionRepository;
    }

}
