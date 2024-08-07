package _miniproject.vo.items;

import java.util.Objects;

public class TodayLuck extends Item{
	
	public TodayLuck(String itemNum, String name, int price) {
		super(itemNum, name, price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(getItemNum());
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TodayLuck) {
			TodayLuck other = (TodayLuck)obj;
			return this.getItemNum().equals(other.getItemNum());
		}
		return false;
	}

	@Override
	public void use() {
		String[] luck = {"매우 나쁨","나쁨","보통","좋음","매우 좋음"};
		System.out.printf("오늘의 운세는 %s입니다.\n", luck[(int)(Math.random() * luck.length)]);
	}

}
