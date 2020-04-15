package ua.lviv.iot.shoeStore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.business.BootsProducerService;
import ua.lviv.iot.shoeStore.model.BootsProducer;

@RequestMapping("/bootsProducers")
@RestController
public class BootsProducerController {

    @Autowired
    private BootsProducerService bootsProducerService;

    @GetMapping
    public List<BootsProducer> getAllBootsProducers() {
        return bootsProducerService.findAll();
    }

    @GetMapping(path = "/{id}")
    public BootsProducer getBootsProducer(final @PathVariable("id") Integer producerId) {

        return bootsProducerService.findObjectById(producerId);
    }

    @PostMapping
    public BootsProducer createBootsProducer(final @RequestBody BootsProducer bootsProducer) {

        return bootsProducerService.createObject(bootsProducer);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BootsProducer> deleteBootsProducer(final @PathVariable("id") Integer producerId) {

        HttpStatus status;
        if (bootsProducerService.existById(producerId)) {
            bootsProducerService.deleteById(producerId);
            status = HttpStatus.OK;
            return ResponseEntity.status(status).build();
        } else {
            status = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(status).build();
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BootsProducer> updateBootsFunction(final @PathVariable("id") Integer producerId,
            @RequestBody BootsProducer bootsProducer) {

        if (bootsProducerService.existById(producerId)) {
            bootsProducer.setId(producerId);
            BootsProducer changedBootsProducer = bootsProducerService.createObject(bootsProducer);
            return new ResponseEntity<BootsProducer>(changedBootsProducer, HttpStatus.OK);
        } else {
            return new ResponseEntity<BootsProducer>(HttpStatus.NOT_FOUND);
        }
    }

}
