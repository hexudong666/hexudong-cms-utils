package com.hexudong.cms.utils.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public class TestBinry {
	
	public static void main(String[] args) {
		new HashMap<>();
		
		int a = 12; // 10 进制
		int b = 012;//   8进制   2 + 8X1 
		int c = 0x12; // 16进制    2 + 16X1
		int d = 0b1101;// 二进制
		System.out.println("  a " + a);//123
		System.out.println("  b " + b); // 
		System.out.println("  c " + c);
		System.out.println("  d " + d);
		
		TestBinry t1 = new TestBinry();
		
		TestBinry t2 =  new TestBinry();
		
		t1.test1();
		t1.test2();
		
		t2.test1();
		
		ArrayList<Object> arrayList = new ArrayList<Object>();
		arrayList.add("");
		new Vector();
		
		HashMap<Object, Object> hashMap = new HashMap<>();
		
		hashMap.put("aa", "fff");
		new ConcurrentHashMap<>();
		
		
		
		
		
		
		
	}
	
	public synchronized static void test3() {
		
	}
	
	public synchronized void test1() {
		
	}
	

	public synchronized void test2() {
		
	}

}
