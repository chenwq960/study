package com.baidu;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//获取Emp的class对象信息
		Class<?> name = Class.forName("com.baidu.Emp");
		//输出Emp的基本信息
		System.out.println("包类型名称\t"+name.getPackage());
		System.out.println("权限定义名\t"+name.getName());
		System.out.println("父类的名称\t");
		//所有的成员信息
		Field[] fields = name.getDeclaredFields();
		System.out.println("所有的成员信息-----------------------");
		for (Field field : fields) {
			//修饰符
			System.out.print(Modifier.toString(field.getModifiers())+" ");
			//类型名称
			System.out.print(field.getType().getSimpleName()+" ");
			//成员名称
			System.out.println(field.getName());
		}
		
		//输出所有的方法，包含父类的
		System.out.println("所有的方法，包含父类的---------------------------");
		Method[] methods = name.getMethods();
		for (Method method : methods) {
			//修饰符名称
			System.out.print(Modifier.toString(method.getModifiers())+" ");
			//类型名
			System.out.print(method.getReturnType()+" ");
			
			//方法名
			System.out.print(method.getName()+" ");
			//参数名
			System.out.print("(");
			Parameter[] parameters = method.getParameters();
			for (Parameter method2 : parameters) {
				System.out.print(method2.getType().getSimpleName()+" ");
			}
			System.out.println(")");
		}
		//通过反射调用无返的方法
		Object obj = name.newInstance();
		Method[] declaredMethods = name.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if(method.getName().startsWith("set")) {
				if(method.getName().endsWith("rkNo")) {
					method.invoke(obj,"work工资");
				}
				if(method.getName().endsWith("Name")) {
					method.invoke(obj,"name的姓名");
				}
				if(method.getName().endsWith("Year")) {
					method.invoke(obj,"workyear");
				}
				if(method.getName().endsWith("ept")) {
					method.invoke(obj,"部门");
				}
			}
		}
		//通过反射电泳println的方法
		System.out.println("反射调用输出的方法---------------------------------------");
		Method[] declaredMethods2 = name.getDeclaredMethods();
		for (Method method : declaredMethods2) {
			if(method.getName().equals("print")) {
				method.invoke(obj);
			}
		}
		//反射调用sayHi的方法
		Method[] declaredMethods3 = name.getDeclaredMethods();
		for (Method method : declaredMethods3) {
			if(method.getName().equals("sayHi")) {
				method.invoke(obj, String.class);
			}
		}
	}
}
