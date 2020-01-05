package com.hexudong.cms.utils.entity;

import java.util.Random;

/**
 * @ClassName:  RandomUtil   
 * @Description:随机数工具类   
 * @date:   2020年1月3日 上午9:07:35
 */
public class RandomUtil {
	/**
	 * @Title: random   
	 * @Description: 获得指定区间的随机数   
	 * @param: @param min
	 * @param: @param max
	 * @param: @return      
	 * @return: int      
	 * @throws
	 */
	public static int random(int min,int max) {
		Random random = new Random();
		int nextInt = random.nextInt(max-min+1);
		if(nextInt<min) {
			return random(min,max);
		}
		return nextInt;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<100;i++) {
			System.out.println(random(1,2));
		}
	}

}
