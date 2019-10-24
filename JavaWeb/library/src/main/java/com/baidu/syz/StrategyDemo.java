package com.baidu.syz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.baidu.entity.Apple;

public class StrategyDemo {
	public static void main(String[] args) {
		List<Apple> appleList = Arrays.asList(new Apple("blue", 100), new Apple("blue", 150), new Apple("red", 77),
				new Apple("blue", 120));

		BlueAppleFilter blueFilter = new BlueAppleFilter();
		List<Apple> blueAppleList = filterAppleList(appleList, blueFilter);
		System.err.println(blueAppleList);

	}

	public static List<Apple> filterAppleList(List<Apple> appleList, AppleFilter filter) {
		List<Apple> list = new ArrayList<>();
		for (Apple apple : appleList) {
			if (filter.filter(apple)) {
				list.add(apple);
			}
		}
		return list;
	}

}

@FunctionalInterface
interface AppleFilter {
	boolean filter(Apple apple);
}

class BlueAppleFilter implements AppleFilter {

	@Override
	public boolean filter(Apple apple) {
		return Objects.equals("blue", apple.getColor());
	}

}
