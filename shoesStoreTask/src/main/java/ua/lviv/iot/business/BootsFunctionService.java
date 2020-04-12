package ua.lviv.iot.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.BootsFunctionRepository;
import ua.lviv.iot.shoeStore.model.BootsFunction;

@Service
public class BootsFunctionService {

    @Autowired
    private BootsFunctionRepository bootsFunctionRepository;

    public List<BootsFunction> findAll() {
        return bootsFunctionRepository.findAll();
    }

    public BootsFunction findBootsFunction(Integer functionId) {
        return bootsFunctionRepository.findById(functionId).get();
    }

    public BootsFunction createBootsFunction(BootsFunction bootsFunction) {
        return bootsFunctionRepository.save(bootsFunction);
    }

    public HttpStatus deleteBootsFunction(Integer functionId) {
        if (bootsFunctionRepository.existsById(functionId)) {
            bootsFunctionRepository.deleteById(functionId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public ResponseEntity<BootsFunction> updateBootsFunction(BootsFunction bootsFunction, Integer producerId) {
        if (bootsFunctionRepository.existsById(producerId)) {
            bootsFunction.setId(producerId);
            BootsFunction changedBootsFunction = bootsFunctionRepository.save(bootsFunction);
            return new ResponseEntity<BootsFunction>(changedBootsFunction, HttpStatus.OK);
        } else {
            return new ResponseEntity<BootsFunction>(HttpStatus.NOT_FOUND);
        }
    }
}
