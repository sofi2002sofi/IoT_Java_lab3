package ua.lviv.iot.shoeStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boots extends AbstractShoes {

	private double hightfShaftlnSM;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Boots() {
		super(0, 0.0, null, null, null, null, null, null, new Heels(null, 0.0), null);
		this.hightfShaftlnSM = 0.0;
	}

}
