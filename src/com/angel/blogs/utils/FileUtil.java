package com.angel.blogs.utils;

import java.io.*;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class FileUtil {
	/**
	 * 根据文件名所代表的文件或目录删除该文件或者该目录下所有文件;
	 * 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除。
	 * 
	 * @return 当且仅当成功删除文件或目录时，返回 true；否则返回 false
	 * @param filename
	 */
	public static void delete(String filename) {
		if (filename == null || filename.length() == 0 || filename.trim().equals(""))
			return;
		File f = new File(filename);
		if (f.exists()) {
			if (f.isFile())
				f.delete();
			else {
				File[] all = f.listFiles();
				for (int i = 0; i < all.length; i++)
					delete(all[i]);
				f.delete();
			}
		}
	}

	/**
	 * 删除指定文件对象所代表的文件或目录
	 * 
	 * @param file
	 */
	public static void delete(File file) {
		if (file.exists()) {
			if (file.isFile())
				file.delete();
			else {
				File[] all = file.listFiles();
				for (int i = 0; i < all.length; i++)
					delete(all[i]);
				file.delete();
				// file.deleteOnExit();在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。
			}
		}
	}

	/**
	 * 删除单个文件
	 * 
	 * @param filename
	 */
	public static boolean deleteStandFile(String filename) {
		if (filename == null || filename.length() == 0 || filename.trim().equals(""))
			return false;
		File file = new File(filename);
		if (file.exists())
			return file.delete();
		else
			return false;
	}

	// 文件下载 删除源文件
	public static void download1(String flieName, String filePath, HttpServletResponse response) {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		File file = new File(filePath);// 取得文件全路径，待下载完成后删除服务器上的文件
		try {
			flieName = new String(flieName.getBytes("GBK"), "ISO8859-1");
			response.setHeader("Content-Disposition", "attachment; filename=" + flieName);
			outputStream = response.getOutputStream();
			inputStream = new FileInputStream(filePath);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
				file.delete();// 删除服务器生成的文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 文件下载 删除源文件
	public static void download(String flieName, String filePath, HttpServletResponse response) {
		response.setContentType("json/html;charset=utf-8");
		OutputStream outputStream = null;
		InputStream inputStream = null;
		File file = new File(filePath);// 取得文件全路径，待下载完成后删除服务器上的文件
		try {
			flieName = new String(flieName.getBytes("GBK"), "ISO8859-1");
			response.setContentType("text/plain;charset=UTF-8");
			response.setHeader("Location", flieName);
			response.setHeader("Content-Disposition", "attachment; filename=" + flieName);
			outputStream = response.getOutputStream();
			inputStream = new FileInputStream(filePath);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
				file.delete();// 删除服务器生成的文件
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 文件下载，不删除源文件
	public static void downloadImg(String flieName, String filePath, HttpServletResponse response) {
		OutputStream outputStream = null;
		InputStream inputStream = null;
		try {
			flieName = new String(flieName.getBytes("GBK"), "ISO8859-1");
			response.setContentType("text/plain;charset=UTF-8");
			response.setHeader("Location", flieName);
			response.setHeader("Content-Disposition", "attachment; filename=" + flieName);
			outputStream = response.getOutputStream();
			inputStream = new FileInputStream(filePath);
			byte[] buffer = new byte[1024];
			int i = -1;
			while ((i = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 图片格式转成png
	 * 
	 * @author Administrator
	 *
	 */
	public static void convert(String source, String formatName, String result) {
		try {
			File f = new File(source);
			f.canRead();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, formatName, new File(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * public static void main(String[] args) {
		 * convert("d:/test/t.jpg","png","d:/test/t.png"); }
		 */
	}
	// 从网上下载图片
	/*
	 * public static void downloadImg(String imageUrl,String imgPath) throws
	 * IOException{ // imageUrl =
	 * "http://localhost:8080/portal/img/login_img.jpg"; try { URL url = new
	 * URL(imageUrl); //打开网络输入流 DataInputStream dis = new
	 * DataInputStream(url.openStream()); //String newImageName=
	 * "E:/eclipse/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/cloud-store/downloadimage/a.png";
	 * //建立一个新的文件 FileOutputStream fos = new FileOutputStream(new
	 * File(imgPath)); byte[] buffer = new byte[1024]; int length; //开始填充数据
	 * while((length = dis.read(buffer))>0){ fos.write(buffer,0,length); }
	 * dis.close(); fos.close(); //File fileImg=new File(imgPath);//删除服务器生成的文件
	 * //fileImg.delete(); } catch (Exception e) { System.out.print("图片不存在"); }
	 * }
	 */
}
