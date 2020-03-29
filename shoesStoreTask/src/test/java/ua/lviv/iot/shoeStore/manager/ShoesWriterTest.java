package ua.lviv.iot.shoeStore.manager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.shoeStore.model.AbstractShoes;
import ua.lviv.iot.shoeStore.writer.ShoesWriter;

public class ShoesWriterTest extends BaseShoppingManagerTest {

	ShoesWriter shoesWriter = new ShoesWriter();

	@Test
	void writeToFileTest() throws IOException {
		Writer csvFileWriter = new FileWriter("info.csv");
		shoesWriter.setInfoWriter(csvFileWriter);
		shoesWriter.writeToFile(bestShoes);
	}

	@Test
	void stringWriterTest() throws IOException {
		String expectedResult = "";
		shoesWriter.setInfoWriter(new StringWriter());
		shoesWriter.writeToFile(bestShoes);
		for (AbstractShoes shoes : bestShoes) {
			expectedResult += shoes.getHeaders() + "\n";
			expectedResult += shoes.toCSV() + "\n";
		}
		assertEquals(expectedResult, shoesWriter.toString());
	}
}
