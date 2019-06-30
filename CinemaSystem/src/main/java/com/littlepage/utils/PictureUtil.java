package com.littlepage.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Random;


/**
 * 临时图片处理
 * @author 74302
 *
 */
public class PictureUtil {
	/**
	 * 得到随机临时图片地址，默认
	 * @return
	 */
	public static String getRandomSite() {
		Random random=new Random();
		return "pic"+random.nextInt(10000000);
	}
	
	/**
	 * 转换图片流
	 * 从数据库读取图片转换到static/tempPic下
	 * @throws IOException 
	 */
	public static String save(byte[] bytePic,String fileName) throws IOException {
		String path="src/main/resources/static/tempPic/"+fileName+".jpg";
		OutputStream os = new FileOutputStream(path);
		os.write(bytePic, 0, bytePic.length);
		os.flush();
		os.close();
		File file=new File(path);
		return file.getAbsolutePath();
	}
	
	
}
