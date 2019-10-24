package com.baidu.lambda;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import com.baidu.entity.Apple;

public class LambdaStrategyDemo2 {
	public static void main(String[] args) throws FileNotFoundException {
		List<Apple> appleList = Arrays.asList(new Apple("red", 120), new Apple("blue", 540), new Apple("red", 220));

		// java1.5版本出现的增强for循环，foreach
		for (Apple apple : appleList) {
			System.err.println(apple);
		}

		// java 1.8版本出现在Iterable接口中foreach方法
		appleList.forEach((Apple apple) -> {
			System.err.println(apple);
		});

		appleList.forEach(apple -> System.err.println(apple));

		appleList.forEach(apple -> print(apple));

		// 函数式引用，双英文冒号
		// 如果使用静态导入
		// import static java.lang.System.err;

		// 两种方式
		// 方式一，静态方法引用
		appleList.forEach(LambdaStrategyDemo2::print);

		appleList.sort((o1, o2) -> o1.getWeight() - o2.getWeight());

		// 方式二，实例方法引用
		PrintStream ps = new PrintStream("");
		appleList.forEach(ps::println);

//		assert 

	}

	public static void print(Apple apple) {
		System.err.println(apple);
	}

}
