package ua.lviv.iot.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.BootsRepository;
import ua.lviv.iot.shoeStore.model.Boots;

@Service
public class BootsService {
    @Autowired
    private BootsRepository bootsRepository;

    public Boots createBoots(Boots boots) {
        return bootsRepository.save(boots);

    }

    public Boots findBoot(Integer bootId) {
        return bootsRepository.findById(bootId).get();
    }

    public List<Boots> findAll() {
        return bootsRepository.findAll();
    }

    public HttpStatus deleteBoots(Integer bootId) {
        if (bootsRepository.existsById(bootId)) {
            bootsRepository.deleteById(bootId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }

    }

    public ResponseEntity<Boots> updateBoots(Boots boot, Integer bootId) {
        if (bootsRepository.existsById(bootId)) {
            boot.setId(bootId);
            Boots changedBoot = bootsRepository.save(boot);
            return new ResponseEntity<Boots>(changedBoot, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boots>(HttpStatus.NOT_FOUND);
        }
    }

}
