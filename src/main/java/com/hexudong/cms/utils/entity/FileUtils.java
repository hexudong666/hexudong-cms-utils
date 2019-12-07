package com.hexudong.cms.utils.entity;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;

public class FileUtils {
	
	/**
	 * 获取文件的扩展名
	 * 
	 * @param String fileName
	 */
	public static synchronized String getSuffixName(String fileName) {
		
		//获取最后一个点的位置
		int dotPos = fileName.lastIndexOf('.');
		if(dotPos<0)
			return "";
		
		return fileName.substring(dotPos);
	}
	
	/**
	 * 
	 * @param fileName
	 */
	public static void delFile(String fileName) {
		
		File file = new File(fileName);
		
		// 获取文件的分隔符号
		String fileSeperator = getProperty("file.separator");
		
		
		
		//文件不存在
		if(!file.exists())
			return ;
		
		// 如果是目录
		if(file.isDirectory()) {
			//递归删除子目录或者文件
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				String childFileName = fileName+ fileSeperator + list[i];
				delFile(childFileName);
			}
		}
		// 如果是文件 或者删除子目录之后 删除本身
		file.delete();
		
	}
	
	/**
	 * 根据属性key 获取系统环境变量值
	 * @param key
	 * @return
	 */
	public static String getProperty(String key) {
		
		Properties properties = System.getProperties();
		/*//获取环境变量
		//System.getenv();
		
		//ArrayList<String> arrayList = new ArrayList<String>();
		//
		//arrayList.forEach(x->{System.out.println(x);});
		 Set<Object> keySet = properties.keySet();
		for (Object hKey: keySet) {
			System.out.println("hKey is " + hKey);
			System.out.println("hValue is " + properties.getProperty((String) hKey));
		}*/
		return properties.getProperty(key);
	} 
	
	/**
	 * 获取系统的环境变量
	 * @param key
	 * @return
	 */
	public static String getEnv(String key) {
		
		Map<String, String> getenv = System.getenv();
		/*getenv.forEach((hKey,hValue)->{
			System.out.println("key is " + hKey );
			System.out.println("vlaue is " + hValue );
		});*/
		return getenv.get(key);
	}
	
	/**
	 * 获取文件的大小
	 * @param fileName
	 * @return
	 */
	public static long getSize(String fileName) {
		
		File file = new File(fileName);
		if(!file.exists() || ! file.isFile())
			return 0;
		return file.length();
		
	}
	
	/**
	 *  比较两个两个文件架内容是否相同
	 * @param src  原目录
	 * @param dst  目标目录
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void comparePath(String src,String dst) throws FileNotFoundException, IOException {
		
		 File srcFile = new File(src);// 
		 File dstFile = new File(dst);//
		 if(!srcFile.exists()) {
			 System.out.println(" 源文件 不存在  "  + src);
			 return;
		 }
		 
		 if(!dstFile.exists()) {
			 System.out.println(" 目标文件 不存在  "  + dst);
			 return;
		 }
		 if(srcFile.isFile() && dstFile.isFile()) {
			 if(srcFile.length() != dstFile.length()) {
				 System.out.println(" 文件长度不一致" + src);
			 }else {
				 byte[] md5Src = DigestUtils.md5(new FileInputStream(srcFile));
				 byte[] md5Dst = DigestUtils.md5(new FileInputStream(dstFile));
				 String strMd5Src = new String(md5Src);
				 String strMd5Dst = new String(md5Dst);
				 if(!strMd5Src.equals(strMd5Dst)) {
					 System.out.println(" 文件内容不一致  " +  src);
				 }
			 }
			 return ;
		 }
		 
		 if(srcFile.isDirectory()) {
			 // 递归， 遍历
			 String[] list = srcFile.list();
			 for (int i = 0; i < list.length; i++) {
				 //源文件的子文件路径
				 String childSrcFile = src + "\\" + list[i];
				//目标文件的子文件路径
				 String childDstFile = dst + "\\" + list[i];
				 comparePath(childSrcFile,childDstFile);
			}
			 
		 }
		
	}
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static String read(String fileName) throws IOException {
		
		//用于存储文件内容
		StringBuilder sb = new StringBuilder();
		
		// 创建文件对象
		File file = new File(fileName);
		
		//创建文件输入流
		FileInputStream fis = new FileInputStream(file);
		// 创建缓冲流
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"GBK"));
		String ln=null;
		//按行读入
		while ((ln= br.readLine())!=null) {
			sb.append(ln);
		}
		
		closeStream(br,fis);
		
		return sb.toString();
	}
	
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	public static List<String> readByLines(String fileName) throws IOException {
		
		//用于存储文件内容
		List<String> lines = new ArrayList();
		
		// 创建文件对象
		File file = new File(fileName);
		
		//创建文件输入流
		FileInputStream fis = new FileInputStream(file);
		// 创建缓冲流
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
		String ln=null;
		//按行读入
		while ((ln= br.readLine())!=null) {
			//sb.append(ln);
			lines.add(ln);
		}
		
		closeStream(br,fis);
		
		return lines;
	}
	
	
	
	/**
	 *  关闭流
	 * @param stream
	 * @throws IOException 
	 */
	public static void closeStream(Closeable ... stream) throws IOException {
		
		for (int i = 0; i < stream.length; i++) {
			stream[i].close();
		}
	}
	
	/**
	 * 复制文件
	 * @param srcFile  源文件
	 * @param dstFile  目标文件
	 * @throws IOException 
	 */
	public synchronized static void copy(String srcFileName ,String dstFileName) throws IOException {
		// 源文件
		File srcFile = new File(srcFileName);
		File dstFile = new File(dstFileName);
		
		FileInputStream fis = new FileInputStream(srcFile);
		FileOutputStream fos  = new FileOutputStream(dstFile);
		byte b[]=new byte[1024];
		
		while(fis.read(b)>0) {
			fos.write(b);
		}
		closeStream(fos,fis);
	}
		
	

}
