package ua.lviv.iot.shoeStore.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
public class AbstractShoes {

	private int sizeEURstandart;

	private double priceInUAH;

	private String assignment;

	private Sex sex;

	private String brand;

	private String color;

	private String materialOfVamp;

	private String materialOfLining;

	@OneToOne( fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "heels_id")
	//@JsonIgnoreProperties("shoes")
	private Heels heels;

	private String toecapType;

	public AbstractShoes(int sizeEURstandart, double priceInUAH, String assignment, Sex sex, String brand, String color,
			String materialOfVamp, String materialOfLining, Heels heels, String toecapType) {
		super();
		this.sizeEURstandart = sizeEURstandart;
		this.priceInUAH = priceInUAH;
		this.assignment = assignment;
		this.sex = sex;
		this.brand = brand;
		this.color = color;
		this.materialOfVamp = materialOfVamp;
		this.materialOfLining = materialOfLining;
		this.heels = heels;
		this.toecapType = toecapType;
	}

	public AbstractShoes() {

	}

	public String getHeaders() {
		return "sizeEURstandart" + "," + "priceInUAH" + "," + "assignment" + "," + "sex" + "," + "brand" + "," + "color"
				+ "," + "materialOfVamp" + "," + "materialOfLining" + "," + heels.getHeaders() + "," + "toecapType";
	}

	public String toCSV() {
		return getSizeEURstandart() + "," + getPriceInUAH() + "," + getAssignment() + "," + getSex() + "," + getBrand()
				+ "," + getColor() + "," + getMaterialOfVamp() + "," + getMaterialOfLining() + "," + heels.toCSV() + ","
				+ getToecapType();
	}

	public int getSizeEURstandart() {
		return sizeEURstandart;
	}

	public void setSizeEURstandart(int sizeEURstandart) {
		this.sizeEURstandart = sizeEURstandart;
	}

	public double getPriceInUAH() {
		return priceInUAH;
	}

	public void setPriceInUAH(double priceInUAH) {
		this.priceInUAH = priceInUAH;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMaterialOfVamp() {
		return materialOfVamp;
	}

	public void setMaterialOfVamp(String materialOfVamp) {
		this.materialOfVamp = materialOfVamp;
	}

	public String getMaterialOfLining() {
		return materialOfLining;
	}

	public void setMaterialOfLining(String materialOfLining) {
		this.materialOfLining = materialOfLining;
	}

	public Heels getHeels() {
		return heels;
	}

	public void setHeels(Heels heels) {
		this.heels = heels;
	}

	public String getToecapType() {
		return toecapType;
	}

	public void setToecapType(String toecapType) {
		this.toecapType = toecapType;
	}

}
