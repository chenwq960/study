package com.baidu;

import java.util.ArrayList;
import java.util.List;

public class Change extends Model implements Change1,Change2{
	
	@Override
	public List<Integer> listchange() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.println(output().length);
		for (int i = 0; i < output().length; i++) {
			arr.add(output()[i]);
		}
		return arr;
	}
	@Override
	public List<String> listchange2() {
		ArrayList<String> array = new ArrayList<String>();
		System.out.println(output().length);
		for (int i = 0; i < output().length; i++) {
			array.add(output()[i].toString());
		}
		return array;
	}
}