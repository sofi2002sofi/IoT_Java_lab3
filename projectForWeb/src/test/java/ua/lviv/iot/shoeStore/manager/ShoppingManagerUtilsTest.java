package ua.lviv.iot.shoeStore.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.lviv.iot.shoeStore.manager.ShoppingManagerUtils;
import ua.lviv.iot.shoeStore.model.SortType;;

public class ShoppingManagerUtilsTest extends BaseShoppingManagerTest {

	@Test
	public void testSortingShoesByPriceInUAN() {

		ShoppingManagerUtils.sortShoesByPriceInUAN(bestShoes, SortType.ASC);
		assertEquals(999.0, bestShoes.get(0).getPriceInUAH());
		assertEquals(1250.0, bestShoes.get(1).getPriceInUAH());
		assertEquals(1300.0, bestShoes.get(2).getPriceInUAH());
		assertEquals(1600.0, bestShoes.get(3).getPriceInUAH());
		assertEquals(1800.0, bestShoes.get(4).getPriceInUAH());
		assertEquals(2059.0, bestShoes.get(5).getPriceInUAH());
		assertEquals(2500.0, bestShoes.get(6).getPriceInUAH());

	}

	@Test
	public void testSortingShoesByHightOfHeels() {

		ShoppingManagerUtils.sortShoesByHightOfHeels(bestShoes, SortType.ASC);
		assertEquals(1.4, bestShoes.get(0).getHeels().getHightOfHeelsInSM());
		assertEquals(1.4, bestShoes.get(1).getHeels().getHightOfHeelsInSM());
		assertEquals(1.4, bestShoes.get(2).getHeels().getHightOfHeelsInSM());
		assertEquals(3.0, bestShoes.get(3).getHeels().getHightOfHeelsInSM());
		assertEquals(4.0, bestShoes.get(4).getHeels().getHightOfHeelsInSM());
		assertEquals(8.0, bestShoes.get(5).getHeels().getHightOfHeelsInSM());
		assertEquals(8.0, bestShoes.get(6).getHeels().getHightOfHeelsInSM());

	}

	@Test
	public void testSortShoesByBrandInABC() {

		ShoppingManagerUtils.sortShoesByBrandInABC(bestShoes, SortType.ASC);
		assertEquals("Anemone", bestShoes.get(0).getBrand());
		assertEquals("CCC", bestShoes.get(1).getBrand());
		assertEquals("ECCO", bestShoes.get(2).getBrand());
		assertEquals("ECCO", bestShoes.get(3).getBrand());
		assertEquals("NewBalance", bestShoes.get(4).getBrand());
		assertEquals("Nike", bestShoes.get(5).getBrand());
		assertEquals("Welfare", bestShoes.get(6).getBrand());

	}

	@Test
	public void testSortShoesBySizeEURstandart() {

		ShoppingManagerUtils.sortShoesBySizeEURstandart(bestShoes, SortType.ASC);
		assertEquals(38, bestShoes.get(0).getSizeEURstandart());
		assertEquals(39, bestShoes.get(1).getSizeEURstandart());
		assertEquals(40, bestShoes.get(2).getSizeEURstandart());
		assertEquals(40, bestShoes.get(3).getSizeEURstandart());
		assertEquals(41, bestShoes.get(4).getSizeEURstandart());
		assertEquals(43, bestShoes.get(5).getSizeEURstandart());
		assertEquals(43, bestShoes.get(6).getSizeEURstandart());

	}
}