package ua.lviv.iot.shoeStore.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

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

import ua.lviv.iot.shoeStore.model.AbstractShoes;
import ua.lviv.iot.shoeStore.model.Boots;

@RequestMapping("/shoes")
@RestController
public class ShoesController {

	private Map<Integer, AbstractShoes> shoes = new HashMap<Integer, AbstractShoes>();

	private AtomicInteger idCounter = new AtomicInteger();

	@GetMapping
	public List<AbstractShoes> getShoes() {
		return new LinkedList<AbstractShoes>(shoes.values());
	}

	@GetMapping(path = "/{id}")
	public AbstractShoes getShoes(final @PathVariable("id") Integer shoesId) {
		return shoes.get(shoesId);
	}

	@PostMapping
	public AbstractShoes createShoes(@RequestBody Boots boot) {
		boot.setId(idCounter.incrementAndGet());
		shoes.put(boot.getId(), boot);
		return boot;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<AbstractShoes> deleteShoes(@PathVariable("id") Integer shoesId) {

		HttpStatus status = shoes.remove(shoesId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
		return ResponseEntity.status(status).build();
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<AbstractShoes> updateShoes(final @PathVariable("id") Integer shoesId,
			@RequestBody AbstractShoes shoe) {
		shoe.setId(shoesId);
		HttpStatus status = shoes.put(shoesId, shoe) != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return ResponseEntity.status(status).build();

	}
}
