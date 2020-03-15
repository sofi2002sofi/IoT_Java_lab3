package ua.lviv.iot.shoeStore.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import ua.lviv.iot.shoeStore.model.AbstractShoes;

public class ShoesWriter {

	private Writer infoWriter;

	public void writeToFile(List<AbstractShoes> shoes) throws IOException {
		for (AbstractShoes shoe : shoes) {
			infoWriter.write(shoe.getHeaders());
			infoWriter.write("\n");
			infoWriter.write(shoe.toCSV());
			infoWriter.write("\n");
		}
		infoWriter.flush();

		infoWriter.close();
	}

	public void setInfoWriter(Writer infoWriter) {
		this.infoWriter = infoWriter;
	}

	@Override
	public String toString() {
		return infoWriter.toString();
	}

}
