package com.kh.model.vo.items;

public class TodayLuck extends Item {
	
	@Override
	public void use() {
		String[] luck = {"매우 나쁨","나쁨","보통","좋음","매우 좋음"};
		System.out.printf("오늘의 운세는 %s입니다.\n", luck[(int)(Math.random() * luck.length)]);
	}
	
}
