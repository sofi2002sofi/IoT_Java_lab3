package ua.lviv.iot.shoeStore.model;

public class Heels {

	private String heelsType;

	private double hightOfHeelsInSM;

	public Heels(String heelsType, double hightOfHeelsInSM) {
		super();
		this.heelsType = heelsType;
		this.hightOfHeelsInSM = hightOfHeelsInSM;
	}

	public String getHeelsType() {
		return heelsType;
	}

	public void setHeelsType(String heelsType) {
		this.heelsType = heelsType;
	}

	public double getHightOfHeelsInSM() {
		return hightOfHeelsInSM;
	}

	public void setHightOfHeelsInSM(double hightOfHeelsInSM) {
		this.hightOfHeelsInSM = hightOfHeelsInSM;
	}

	public String getHeaders() {
		return "heelsType" + "hightOfHeelsInSM";
	}

	public String toCSV() {
		return getHeelsType() + "," + getHightOfHeelsInSM();
	}
}
