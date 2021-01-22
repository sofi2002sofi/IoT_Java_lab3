package ua.lviv.iot.shoeStore.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.shoeStore.model.AbstractShoes;

public class ShoppingManager {

	private List<AbstractShoes> shoes = new LinkedList<>();

	public void addShoes(List<AbstractShoes> shoes) {

		this.shoes.addAll(shoes);

	}

	public List<AbstractShoes> findShoesBy(String assignment) {

		List<AbstractShoes> suitableShoes = new LinkedList<AbstractShoes>();
		for (AbstractShoes shoe : shoes) {
			if (shoe.getAssignment().equals(assignment)) {
				suitableShoes.add(shoe);
			}
		}
		return suitableShoes;
	}

	public List<AbstractShoes> findShoesBy(int sizeEURstandart) {

		List<AbstractShoes> suitableShoes = new LinkedList<AbstractShoes>();
		for (AbstractShoes shoe : shoes) {
			if (shoe.getSizeEURstandart() == sizeEURstandart) {
				suitableShoes.add(shoe);
			}
		}
		return suitableShoes;
	}

}
