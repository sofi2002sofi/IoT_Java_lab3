package ua.lviv.iot.shoeStore.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.shoeStore.model.AbstractShoes;
import ua.lviv.iot.shoeStore.model.SortType;

public class ShoppingManagerUtils {

	// sorting using static inner class
	private static final ShoesSortedByPriceInUAN SHOES_BY_PRICE_IN_UAH_SORTER = new ShoesSortedByPriceInUAN();

	public static void sortShoesByPriceInUAN(List<AbstractShoes> shoes, SortType sortType) {

		shoes.sort(sortType == SortType.ASC ? SHOES_BY_PRICE_IN_UAH_SORTER : SHOES_BY_PRICE_IN_UAH_SORTER.reversed());

	}

	// static inner class
	static class ShoesSortedByPriceInUAN implements Comparator<AbstractShoes> {

		@Override
		public int compare(AbstractShoes firstShoes, AbstractShoes secondShoes) {
			return (int) (firstShoes.getPriceInUAH() - secondShoes.getPriceInUAH());
		}
	}

	// sorting using inner class
	public static void sortShoesByBrandInABC(List<AbstractShoes> shoes, SortType sortType) {

		ShoppingManagerUtils shoppingManagerUtils = new ShoppingManagerUtils();
		ShoesSortedByBrand brandComparator = shoppingManagerUtils.new ShoesSortedByBrand();

		shoes.sort(sortType == SortType.ASC ? brandComparator : brandComparator.reversed());

	}

	// inner class
	class ShoesSortedByBrand implements Comparator<AbstractShoes> {

		@Override
		public int compare(AbstractShoes firstShoes, AbstractShoes secondShoes) {
			return firstShoes.getBrand().compareTo(secondShoes.getBrand());

		}
	}

	// sorting using anonymous class
	public static void sortShoesByHightOfHeels(List<AbstractShoes> shoes, SortType sortType) {

		// anonymous class
		Comparator<AbstractShoes> hightOfHeelsComparator = new Comparator<AbstractShoes>() {

			@Override
			public int compare(AbstractShoes firstShoes, AbstractShoes secondShoes) {

				return (int) (firstShoes.getHeels().getHightOfHeelsInSM()
						- secondShoes.getHeels().getHightOfHeelsInSM());

			}
		};
		shoes.sort(sortType == SortType.ASC ? hightOfHeelsComparator : hightOfHeelsComparator.reversed());

	}

	// sorting using lambdas
	public static void sortShoesBySizeEURstandart(List<AbstractShoes> shoes, SortType sortType) {

		Comparator<AbstractShoes> sizeComperator = (firstShoes, secondShoes) -> firstShoes.getSizeEURstandart()
				- secondShoes.getSizeEURstandart();
		shoes.sort(sortType == SortType.ASC ? sizeComperator : sizeComperator.reversed());

	}

}
