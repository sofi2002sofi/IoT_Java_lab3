package ua.lviv.iot.shoeStore.model;

public class Pumps extends AbstractShoes {

	private DegreeOfOpenness degreeOfOpenness;

	public DegreeOfOpenness getDegreeOfOpenness() {
		return degreeOfOpenness;
	}

	public void setDegreeOfOpenness(DegreeOfOpenness degreeOfOpenness) {
		this.degreeOfOpenness = degreeOfOpenness;
	}

	public Pumps(int sizeEURstandart, double priceInUAH, String assignment, Sex sex, String brand, String color,
			String materialOfVamp, String materialOfLining, Heels heels, String toecapType,
			DegreeOfOpenness degreeOfOpenness) {
		super(sizeEURstandart, priceInUAH, assignment, sex, brand, color, materialOfVamp, materialOfLining, heels,
				toecapType);
		this.degreeOfOpenness = degreeOfOpenness;
	}

	public String getHeaders() {
		return super.getHeaders() + "," + "degreeOfOpenness";
	}

	public String toCSV() {
		return super.toCSV() + "," + getDegreeOfOpenness();
	}
}
