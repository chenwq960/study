package com.baidu;

import java.util.*;
import java.util.Map.Entry;


public class Test {
	public static void main(String[] args) {
		Map<Integer, User> map = new TreeMap<Integer, User>();
		map.put(15, new User("趙六",14, '男'));
		map.put(5, new User("田七",15, '女'));
		map.put(3, new User("王五",12, '男'));
		map.put(4, new User("張三",16, '男'));
		map.put(19, new User("笑笑",7, '女'));
		
		List list = new ArrayList();
		Set<User> tree = new TreeSet<User>();
		Set<Map.Entry<Integer,User>> set = map.entrySet();
		for (Entry<Integer, User> entry : set) {
			System.out.println(entry);
			tree.add(entry.getValue());
		}
		
		Iterator it = tree.iterator();
		while(it.hasNext()) {
			list.add(((User) it.next()).getAge());
		}	
		int maxAge = (int) Collections.max(list);
		int minAge = (int) Collections.min(list);
		
		
		Iterator treeIt = tree.iterator();
		while(treeIt.hasNext()) {
			Object obj = treeIt.next();
			if(((User) obj).getAge() == maxAge) {
				System.out.println("最大年齡信息為\n"+obj);
				
			}
			if(((User) obj).getAge() == minAge)
				System.out.println("最小的年齡為\n"+obj);
		}
		
		
		
	}

}
