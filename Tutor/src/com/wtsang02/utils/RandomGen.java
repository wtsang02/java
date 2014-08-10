package com.wtsang02.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomGen {
	public static Random generator = new Random();
	private static  Map<Integer, String> map;
	static{
		Map<Integer, String> aMap=new HashMap<Integer, String>();
		aMap.put(0, "-");
		aMap.put(1, "A");
		aMap.put(2, "B");
		aMap.put(3, "C");
		aMap.put(4, "D");
		aMap.put(5, "E");
		aMap.put(6, "F");
		aMap.put(7, "G");
		aMap.put(8, "H");
		aMap.put(9, "I");
		aMap.put(10, "J");
		aMap.put(11, "K");
		aMap.put(12, "L");
		aMap.put(13, "M");
		aMap.put(14, "N");
		aMap.put(15, "O");
		aMap.put(16, "P");
		aMap.put(17, "Q");
		aMap.put(18, "R");
		aMap.put(19, "S");
		aMap.put(20, "T");
		aMap.put(21, "U");
		aMap.put(22, "V");
		aMap.put(23, "W");
		aMap.put(24, "X");
		aMap.put(25, "Y");
		aMap.put(26, "Z");
		aMap.put(27, "0");
		aMap.put(28, "1");
		aMap.put(29, "2");
		aMap.put(30, "3");
		aMap.put(31, "4");
		aMap.put(32, "5");
		aMap.put(33, "6");
		aMap.put(34, "7");
		aMap.put(35, "8");
		aMap.put(36, "9");
		
		map=Collections.unmodifiableMap(aMap);
	}
	public static Object[] questionOrder(String[] array){
		int answer=trans(array[4]);
		ArrayList<Integer> stored=new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			int num=generator.nextInt(4);
			stored.add(check(stored,num));
		}

		stored.add(stored.indexOf(answer));
		return stored.toArray();
		
	}

		public static int check(ArrayList<Integer> list,int num){
			while(list.contains(num)){
				num=generator.nextInt(4);
			}
			return num;
		}
	
	public static int trans(String letter){
		if(letter.equalsIgnoreCase("A"))
			return 0;
		if(letter.equalsIgnoreCase("B"))
			return 1;
		if(letter.equalsIgnoreCase("C"))
			return 2;
		if(letter.equalsIgnoreCase("D"))
			return 3;
		return 0;
	}

	public static String genUCode() {
		StringBuilder sb=new StringBuilder();
		String firstLetter=map.get(generator.nextInt(27)+1);
		sb.append(firstLetter);
		for(int i=0;i<5;i++){
			sb.append(map.get(generator.nextInt(27)));
		}
		sb.append(map.get(0));
		for(int i=0;i<15;i++){
			sb.append(generator.nextInt(10));
		}
		return sb.toString();
	}
	public static String getRanUpLetter(){
		String letter=map.get(generator.nextInt(26)+1);
		return letter;
		
	}
	public static String getRanNumber(){
		return String.valueOf(generator.nextInt(10));
		
	}
	public static String getRandomChar(){
		String letter=map.get(generator.nextInt(36)+1);
		return letter;
	}
	
}
