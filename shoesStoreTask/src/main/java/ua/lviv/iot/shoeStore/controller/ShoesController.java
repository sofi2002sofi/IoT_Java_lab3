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
import ua.lviv.iot.business.BootsService;
import ua.lviv.iot.shoeStore.model.Boots;

@RequestMapping("/shoes")
@RestController
public class ShoesController {

    @Autowired
    private BootsService bootsService;

    @GetMapping
    public List<Boots> getShoes() {

        return bootsService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Boots getShoe(final @PathVariable("id") Integer shoesId) {

        return bootsService.findObjectById(shoesId);
    }

    @PostMapping
    public Boots createShoes(final @RequestBody Boots boot) {

        return bootsService.createObject(boot);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boots> deleteShoes(final @PathVariable("id") Integer shoesId) {

        HttpStatus status;
        if (bootsService.existById(shoesId)) {
            bootsService.deleteById(shoesId);
            status = HttpStatus.OK;
            return ResponseEntity.status(status).build();
        } else {
            status = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(status).build();
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Boots> updateBootsFunction(final @PathVariable("id") Integer shoesId,
            @RequestBody Boots shoe) {

        if (bootsService.existById(shoesId)) {
            shoe.setId(shoesId);
            Boots changedBootsFunction = bootsService.createObject(shoe);
            return new ResponseEntity<Boots>(changedBootsFunction, HttpStatus.OK);
        } else {
            return new ResponseEntity<Boots>(HttpStatus.NOT_FOUND);
        }

    }
}
