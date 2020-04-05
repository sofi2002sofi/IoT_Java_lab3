package ua.lviv.iot.shoeStore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Heels {

	private String heelsType;

	private double hightOfHeelsInSM;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Heels() {

	}

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
