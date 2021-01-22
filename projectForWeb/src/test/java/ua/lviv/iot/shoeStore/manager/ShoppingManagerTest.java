package ua.lviv.iot.shoeStore.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.shoeStore.manager.ShoppingManager;
import ua.lviv.iot.shoeStore.manager.ShoppingManagerUtils;
import ua.lviv.iot.shoeStore.model.AbstractShoes;
import ua.lviv.iot.shoeStore.model.SortType;

class ShoppingManagerTest extends BaseShoppingManagerTest {

	private ShoppingManager shoppingManager;

	@BeforeEach
	public void setUp() {

		shoppingManager = new ShoppingManager();
		shoppingManager.addShoes(bestShoes);

	}

	@Test
	public void testFindBySizeEURStandart() {

		List<AbstractShoes> suitableShoes = shoppingManager.findShoesBy(39);
		assertEquals(1, suitableShoes.size());
		assertEquals(39, suitableShoes.get(0).getSizeEURstandart());

	}

	@Test
	public void testFindByAssignment() {

		List<AbstractShoes> suitableShoes = shoppingManager.findShoesBy("winter");
		assertEquals(3, suitableShoes.size());
		assertEquals("winter", suitableShoes.get(0).getAssignment());

	}

}
