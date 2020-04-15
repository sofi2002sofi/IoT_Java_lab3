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
import ua.lviv.iot.business.BootsFunctionService;
import ua.lviv.iot.shoeStore.model.BootsFunction;

@RequestMapping("/bootsFunctions")
@RestController
public class BootsFunctionController {

    @Autowired
    private BootsFunctionService bootsFunctionService;

    @GetMapping
    public List<BootsFunction> getAllBootsFunctions() {
        return bootsFunctionService.findAll();
    }

    @GetMapping(path = "/{id}")
    public BootsFunction getBootsFunction(final @PathVariable("id") Integer functionId) {

        return bootsFunctionService.findObjectById(functionId);
    }

    @PostMapping
    public BootsFunction createBootsFunction(final @RequestBody BootsFunction bootsFunction) {

        return bootsFunctionService.createObject(bootsFunction);

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<BootsFunction> deleteBootsFunction(final @PathVariable("id") Integer functionId) {

        HttpStatus status;
        if (bootsFunctionService.existById(functionId)) {
            bootsFunctionService.deleteById(functionId);
            status = HttpStatus.OK;
            return ResponseEntity.status(status).build();
        } else {
            status = HttpStatus.NOT_FOUND;
            return ResponseEntity.status(status).build();
        }

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<BootsFunction> updateBootsFunction(final @PathVariable("id") Integer functionId,
            @RequestBody BootsFunction bootsFunction) {

        if (bootsFunctionService.existById(functionId)) {
            bootsFunction.setId(functionId);
            BootsFunction changedBootsFunction = bootsFunctionService.createObject(bootsFunction);
            return new ResponseEntity<BootsFunction>(changedBootsFunction, HttpStatus.OK);
        } else {
            return new ResponseEntity<BootsFunction>(HttpStatus.NOT_FOUND);
        }

    }

}
