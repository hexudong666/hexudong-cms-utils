package com.hexudong.cms.utils.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.hexudong.cms.utils.entity.FileUtils;


/**
 *
 */
public class TestFileUtils {
	
	/*@Test
	public void testGetSuffix() {
		
		String suffix = FileUtils.getSuffixName("D:\\program\\nodejs\\node_cache\\anonymous-cli-metrics.json");
		System.out.println("suffix = " + suffix);
		
	}*/
	
/*	@Test
	public void testDelFile() {
		FileUtils.delFile("D:\\mvntest - 副本zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz	");
	}
*/	
/*	@Test
	public void testGetpro() {
		FileUtils.getProperty("");
		
	}
*/	
/*	
	@Test 
	public void testGetEvn() {
		System.out.println( "java_home is " +  FileUtils.getEnv("JAVA_HOME"));
	}
	
	
*/	/*@Test
	public void testCompare() throws FileNotFoundException, IOException {
		System.out.println("比较开始");
		FileUtils.comparePath("D:\\project\\07b", "D:\\project\\07b - 副本");
		System.out.println("比较结束");
	}*/
	
	
	
	//读取文件
	@Test
	public void testReadLines() throws IOException {
		
		List<String> lines = FileUtils.readByLines("E:\\新建文本文档.txt");
		
		lines.forEach(x->{System.out.println(" x is " + x);});
		
		for (String string : lines) {
			String[] split = string.split("\\,");
			//添加
		}
		
	}
	
	/*@Test
	public void testCopy() throws IOException {
		String src="D:\\project\\07b\\07b.zip";
		String dst="D:\\project\\07b\\07b2.zip";
		FileUtils.copy(src,dst );
	}*/ 
	
	
	
}