package test240729.object1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class LotteryController {
	private HashSet<Lottery> lottery = new HashSet<>();
	private HashSet<Lottery> win = new HashSet<>();
	
	public boolean insertObject(Lottery l) {
		return lottery.add(l);
	}
	
	public boolean deleteObject(Lottery l) {
		if(lottery.contains(l)) {
			lottery.remove(l);
			if(win.contains(l)) {
				win.remove(l);
				winObject();
			}
			return true;
		}
		return false;
	}
	
	public HashSet<Lottery> winObject() {
		ArrayList<Lottery> arrList = new ArrayList<>(lottery);
		
		if(arrList.size() >= 4) {
			while(win.size() < 4) {
				int index = (int)(Math.random() * arrList.size());
				win.add(arrList.get( index ));
			}
		}
		return win;
	}
	
	public TreeSet<Lottery> sortedWinObject() {
		TreeSet<Lottery> treeSet = new TreeSet<>(new SortedLottery() /*TreeSet의 정렬 기준 선언*/ );
		treeSet.addAll(win);
		
		return treeSet;
	}
	
	public boolean searchWinner(Lottery l) {
		return win.contains(l);
	}
}
