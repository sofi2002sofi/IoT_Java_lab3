package ua.lviv.iot.shoeStore.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.business.HeelsService;
import ua.lviv.iot.shoeStore.model.Heels;

@RequestMapping("/heels")
@RestController
public class HeelsController {

    @Autowired
    private HeelsService heelsService;

    @GetMapping
    public List<Heels> getAllGroups() {
        return heelsService.findAll();
    }
}
