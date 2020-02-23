package ua.lviv.iot.shoeStore.model;

import java.util.List;

public class Sneakers extends AbstractShoes {
	
	private boolean eyeletsPresence;
	
	private Specification specification;

	public boolean isEyeletsPresence() {
		return eyeletsPresence;
	}

	public void setEyeletsPresence(boolean eyeletsPresence) {
		this.eyeletsPresence = eyeletsPresence;
	}

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public Sneakers(int sizeEURstandart, double priceInUAH, String assignment, Sex sex, String brand,
			String color, String materialOfVamp, String materialOfLining, Heels heels, String toecapType,
			boolean eyeletsPresence, Specification specification) {
		super(sizeEURstandart, priceInUAH, assignment, sex, brand, color, materialOfVamp, materialOfLining, heels,
				toecapType);
		this.eyeletsPresence = eyeletsPresence;
		this.specification = specification;
	}

}