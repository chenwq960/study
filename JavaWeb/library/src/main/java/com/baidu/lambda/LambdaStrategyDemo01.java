package com.baidu.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import com.baidu.entity.Apple;

public class LambdaStrategyDemo01 {
	public static void main(String[] args) {
		List<Apple> appleList = Arrays.asList(new Apple("red", 120), new Apple("blue", 540), new Apple("red", 220));

		// 第一版 Lambda表达式
		filterApple(appleList, (Apple apple) -> {
			return Objects.equals(apple.getColor(), "blue");
		});

		// 第二版，lambda表达式，参数类型可以通过JVM推断出来，可以省略参数类型
		filterApple(appleList, (apple) -> {
			return Objects.equals(apple.getColor(), "blue");
		});

		// 第三版，如果lambda表达式只有一个参数，小括号可以省略，如果lambda表达式没有参数，小括号不可以省略
		filterApple(appleList, apple -> {
			return Objects.equals(apple.getColor(), "blue");
		});

		// 第四版，如果lambda表达式内容只有一行
		// 1，大括号可以省略，
		// 2，如果大括号省略后，lambda表达式有返回值，则return 必须省略
		// 3，如果大括号省略后，这一行的分号也必须省略
		filterApple(appleList, apple -> Objects.equals(apple.getColor(), "blue"));

		
		//对比两种方式开线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}).start();

		new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

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
