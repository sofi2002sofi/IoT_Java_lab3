package ua.lviv.iot.shoeStore.model;

public class Boots extends AbstractShoes {

	private double hightfShaftlnSM;

	public double getHightfShaftlnSM() {
		return hightfShaftlnSM;
	}

	public void setHightfShaftlnSM(double hightfShaftlnSM) {
		this.hightfShaftlnSM = hightfShaftlnSM;
	}

	public Boots(int sizeEURstandart, double priceInUAH, String assignment, Sex sex, String brand, String color,
			String materialOfVamp, String materialOfLining, Heels heels, String toecapType, double hightfShaftlnSM) {
		super(sizeEURstandart, priceInUAH, assignment, sex, brand, color, materialOfVamp, materialOfLining, heels,
				toecapType);
		this.hightfShaftlnSM = hightfShaftlnSM;
	}

	public String getHeaders() {
		return super.getHeaders() + "," + "hightfShaftlnSM";
	}

	public String toCSV() {
		return super.toCSV() + "," + getHightfShaftlnSM();
	}

}
