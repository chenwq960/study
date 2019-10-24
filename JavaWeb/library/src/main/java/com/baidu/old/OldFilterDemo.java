package com.baidu.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.baidu.entity.Apple;

public class OldFilterDemo {
	public static void main(String[] args) {

		List<Apple> appleList = Arrays.asList(new Apple("blue", 100), new Apple("blue", 150), new Apple("red", 77),
				new Apple("blue", 120));
		// List<Apple> blueList = filterBlueApple(appleList);
		// System.out.println(blueList);

		// 过滤颜色和体重
		List<Apple> findColorList = findAppleListByColorAndWeight(appleList, "red", 0);
		System.out.println(findColorList);

	}

	public static List<Apple> filterBlueApple(List<Apple> list) {
		ArrayList<Apple> findApple = new ArrayList<Apple>();
		Iterator<Apple> it = list.iterator();
//		while (it.hasNext()) {
//
////			System.out.println(it);
//			Apple apple = it.next();
////			if (it.next().getColor().equals("blue")) {
////				System.out.println(it);
////			}
//			if(Objects.equals(apple.getColor(),"blue")) {
//				findApple.add(apple);
//			}
//
//		}

		for (Apple apple : list) {
			if (Objects.equals(apple.getColor(), "blue")) {

				findApple.add(apple);
			}
		}
		return findApple;

	}

	public static List<Apple> findAppleListByColorAndWeight(List<Apple> appleList, String color, int weight) {
		List<Apple> list = new ArrayList<Apple>();
		for (Apple apple : appleList) {
			boolean flagColor = false;
			boolean flagWeight = false;
			if (color != null) {
				if (Objects.equals(apple.getColor(), color)) {
					flagColor = true;

				}
			} else {
				flagColor = true;
			}

			if (weight != 0) {
				if (apple.getWeight() >= weight) {
					flagWeight = true;
				}

			} else {
				flagWeight = true;
			}

			if (flagColor && flagWeight) {
				list.add(apple);
			}

		}
		return list;

	}

}
