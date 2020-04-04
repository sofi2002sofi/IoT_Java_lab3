package ua.lviv.iot.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.dataaccess.HeelsRepository;
import ua.lviv.iot.shoeStore.model.Heels;

@Service
public class HeelsService {

	@Autowired
	private HeelsRepository heelsRepository;

	public List<Heels> findAll() {
		return heelsRepository.findAll();
	}

}
