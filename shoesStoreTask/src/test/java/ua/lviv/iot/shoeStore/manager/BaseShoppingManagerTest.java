package ua.lviv.iot.shoeStore.manager;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.shoeStore.model.AbstractShoes;
import ua.lviv.iot.shoeStore.model.Boots;
import ua.lviv.iot.shoeStore.model.DegreeOfOpenness;
import ua.lviv.iot.shoeStore.model.Heels;
import ua.lviv.iot.shoeStore.model.Pumps;
import ua.lviv.iot.shoeStore.model.Sex;
import ua.lviv.iot.shoeStore.model.Sneakers;
import ua.lviv.iot.shoeStore.model.Specification;

public abstract class BaseShoppingManagerTest {

	Heels platform = new Heels("platform", 3.0);
	Heels lowPump = new Heels("pump", 4.0);
	Heels highPump = new Heels("pump", 8.0);
	Heels thickenedSole = new Heels("thickenedSole", 1.4);

	protected List<AbstractShoes> bestShoes;

	@BeforeEach
	public void createBoots() {
		bestShoes = new LinkedList<AbstractShoes>();
		bestShoes.add(
				new Boots(38, 2059.0, "winter", Sex.FEMALE, "ECCO", "black", "skin", "fur", lowPump, "oval", 35.5));
		bestShoes.add(new Boots(41, 1300.0, "winter", Sex.FEMALE, "CCC", "blue", "textile", "textile", thickenedSole,
				"square", 24.6));
		bestShoes.add(new Boots(39, 2500.0, "winter", Sex.FEMALE, "Welfare", "brown", "leatherette", "fur", highPump,
				"sharpToecap", 34.0));
		bestShoes.add(new Pumps(40, 1600.0, "classical", Sex.FEMALE, "Anemone", "red", "suede", "skin", platform,
				"sharpToecap", DegreeOfOpenness.WITHOUT_EXTRA_OPEN_SPACES));
		bestShoes.add(new Pumps(40, 999.0, "classical", Sex.FEMALE, "ECCO", "black", "skin", "skin", highPump,
				"sharpToecap", DegreeOfOpenness.OPEN_SIDE));
		bestShoes.add(new Sneakers(43, 1250.0, "sport", Sex.MALE, "Nike", "blue", "textile", "orthoLite", thickenedSole,
				"oval", true, Specification.FOR_TRAINING));
		bestShoes.add(new Sneakers(43, 1800.0, "sport", Sex.FEMALE, "NewBalance", "gray", "suede", "orthoLite",
				thickenedSole, "oval", true, Specification.FOR_RUNNING));

	}
}
