package com.hexudong.cms.utils.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

//import com.hexudong.Demo.DemoKM;
import com.hexudong.cms.utils.entity.FileUtils;
//import com.hexudong.entity.Car;

public class TestKm {

	/*@Test
	public void testImport() {
		
		List<String> lines;
		try {
			lines = FileUtils.readByLines("d:\\cardata.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("文件解析错误！！！");
			return;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for (String carStr : lines) {
			Car car = new Car();
			String[] carData = carStr.split("\\|");
			if(carData.length!=4) {
				System.out.println(" 数据 不合法  长度 " + carStr);
				continue;
			}
			
			// 车牌号
			car.setCarno(carData[0]);
			//
			try {
				car.setLongitude(Double.parseDouble(carData[1]));	
				car.setLatitude(Double.parseDouble(carData[2]));	
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("精度或维度不合法" +  carStr);
				continue;
			}
			try {
				car.setZptime(format.parse(carData[3]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//
				System.out.println("日期解析错误  " + carStr);
				continue;
			}
			car.setDistance(DemoKM.calBylw(car.getLongitude(), car.getLatitude(), 116.38, 39.90));
			System.out.println(" car is  " + car);
		}
		
	}*/
	
}
