package com.baidu;

import java.util.Scanner;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("请输入用户名 【长度2-20，字母开头】");
		Scanner s = new Scanner(System.in);
		String next = s.next();
		boolean nameIf = next.matches("[a-z||A-Z]\\w{3,19}");
		
		System.out.println("请输入密码【长度6-10位数】");
		String pass = s.next();
		boolean passIf = pass.matches("\\w{6,10}");
		System.out.println("请输入邮箱【格式必须正确】");
		String email = s.next();
		boolean emailIf = email.matches("\\w+\\@\\w+\\.(\\w+)+");
		System.out.println("请输入手机号：");
		String tel = s.next();
		boolean telIf = tel.matches("1[3-8]\\d{9}");
		if(telIf && emailIf &&passIf&&nameIf) {
			System.out.println("注册成功");
		}else {
			if(telIf != true) {
				System.out.println("手机号输入不正确");
			}
			if(emailIf != true) {
				System.out.println("邮箱输入不正确");
			}
			//验证密码
			if(passIf != true) {
				System.out.println("密码输入不正确");
			}
			//验证姓名
			if(nameIf != true) {
				System.out.println("用户名输入不正确");
			}
		}
		
		
	}
}
