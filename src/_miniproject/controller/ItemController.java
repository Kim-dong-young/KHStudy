package _miniproject.controller;

import java.util.HashMap;

import _miniproject.vo.items.Item;
import _miniproject.vo.items.PredictPrice;
import _miniproject.vo.items.TodayLuck;

public class ItemController {
	private static ItemController ic;
	private StockController sc = StockController.getInstance();
	private HashMap<String, Item> itemList;
	
	private ItemController() {
		super();
		this.itemList = new HashMap<>();
		
		itemList.put("1", new TodayLuck("1","오늘의운세",500));
		itemList.put("2", new PredictPrice("2","주식가격예측",10000));
	}
	
	public static ItemController getInstance() {
		if(ic == null) {
			ic = new ItemController();
		}
		return ic;
	}
	
	public HashMap<String, Item> getItemList(){
		return itemList;
	}
	
	public Item getItem(int iNum) {
		String itemNum = Integer.toString(iNum);
		if(itemList.containsKey(itemNum)) {
			return itemList.get(itemNum);
		}
		return null;
	}
	
}
