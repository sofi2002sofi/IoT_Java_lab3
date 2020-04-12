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

        return bootsProducerService.findBootsProducer(producerId);
    }

    @PostMapping
    public BootsProducer createBootsProducer(final @RequestBody BootsProducer bootsProducer) {

        return bootsProducerService.createBootsProducer(bootsProducer);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BootsProducer> deleteBootsProducer(final @PathVariable("id") Integer producerId) {

        HttpStatus status = bootsProducerService.deleteBootsProducer(producerId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BootsProducer> updateBootsProducer(final @PathVariable("id") Integer producerId,
            @RequestBody BootsProducer bootsProducer) {

        return bootsProducerService.updateBootsProducer(bootsProducer, producerId);
    }
}
