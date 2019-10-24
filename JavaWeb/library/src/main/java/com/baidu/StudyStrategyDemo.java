package com.baidu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.baidu.entity.Apple;

/**
 * 简化的设计模式思想
 * 
 * @author Administrator
 *
 */
public class StudyStrategyDemo {
	public static void main(String[] args) {
		List<Apple> appleList = Arrays.asList(new Apple("red", 120), new Apple("blue", 540), new Apple("red", 220));

		filterApple(appleList, new AppleFilter() {

			@Override
			public Boolean filter(Apple apple) {
				// TODO Auto-generated method stub
				return Objects.equals(apple.getColor(), "blue");
			}
		});
	}

	public static List<Apple> filterApple(List<Apple> appleList, AppleFilter appleFilter) {
		List<Apple> list = new ArrayList<Apple>();
		for (Apple apple : appleList) {
			if (appleFilter.filter(apple)) {
				list.add(apple);
			}
		}
		return list;
	}

}

@FunctionalInterface
interface AppleFilter {
	Boolean filter(Apple apple);
}
