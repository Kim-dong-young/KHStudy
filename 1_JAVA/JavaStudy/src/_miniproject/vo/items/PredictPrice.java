package _miniproject.vo.items;

import java.util.Objects;

import _miniproject.controller.StockController;
import _miniproject.vo.Stock;

public class PredictPrice extends Item{

	public PredictPrice(String itemNum, String name, int price) {
		super(itemNum, name, price);
	}


	@Override
	public int hashCode() {
		return Objects.hash(getItemNum());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PredictPrice) {
			PredictPrice other = (PredictPrice)obj;
			return this.getItemNum().equals(other.getItemNum());
		}
		return false;
	}
	
	@Override
	public void use() {
		Stock stock = StockController.getInstance().getRandomStock();
		System.out.printf("소문에 따르면... %s는 내일 %.2f 만큼 가격이 변동합니다.\n",stock.getStockName(), stock.getNextFluct() * (0.8 + (Math.random() * 0.4)) );
	}

}
