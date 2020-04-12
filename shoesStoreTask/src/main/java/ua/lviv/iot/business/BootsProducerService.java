package ua.lviv.iot.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.BootsProducerRepository;
import ua.lviv.iot.shoeStore.model.BootsProducer;

@Service
public class BootsProducerService {

    @Autowired
    private BootsProducerRepository bootsProducerRepository;

    public List<BootsProducer> findAll() {
        return bootsProducerRepository.findAll();
    }

    public BootsProducer findBootsProducer(Integer producerId) {
        return bootsProducerRepository.findById(producerId).get();
    }

    public BootsProducer createBootsProducer(BootsProducer bootsProducer) {
        return bootsProducerRepository.save(bootsProducer);
    }

    public HttpStatus deleteBootsProducer(Integer producerId) {
        if (bootsProducerRepository.existsById(producerId)) {
            bootsProducerRepository.deleteById(producerId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public ResponseEntity<BootsProducer> updateBootsProducer(BootsProducer bootsProducer, Integer producerId) {
        if (bootsProducerRepository.existsById(producerId)) {
            bootsProducer.setId(producerId);
            BootsProducer changedBootsProducer = bootsProducerRepository.save(bootsProducer);
            return new ResponseEntity<BootsProducer>(changedBootsProducer, HttpStatus.OK);
        } else {
            return new ResponseEntity<BootsProducer>(HttpStatus.NOT_FOUND);
        }
    }
}
