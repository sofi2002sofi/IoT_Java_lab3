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

        return bootsService.findBoot(shoesId);
    }

    @PostMapping
    public Boots createShoes(final @RequestBody Boots boot) {

        return bootsService.createBoots(boot);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boots> deleteShoes(final @PathVariable("id") Integer shoesId) {

        HttpStatus status = bootsService.deleteBoots(shoesId);
        return ResponseEntity.status(status).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Boots> updateShoes(final @PathVariable("id") Integer shoesId, @RequestBody Boots shoe) {

        return bootsService.updateBoots(shoe, shoesId);
    }
}
