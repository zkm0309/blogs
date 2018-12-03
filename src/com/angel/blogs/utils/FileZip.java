package com.angel.blogs.utils;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import java.util.zip.ZipEntry;

import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

public class FileZip {

	/**
	 * 
	 * @param srcfile
	 *            文件名数组
	 * @param zipfile
	 *            压缩后文件
	 */
	public static void ZipFiles(java.io.File[] srcfile, java.io.File zipfile) {

		byte[] buf = new byte[1024];

		try {

			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));

			for (int i = 0; i < srcfile.length; i++) {

				FileInputStream in = new FileInputStream(srcfile[i]);

				out.putNextEntry(new ZipEntry(srcfile[i].getName()));

				int len;

				while ((len = in.read(buf)) > 0) {

					out.write(buf, 0, len);

				}

				out.closeEntry();

				in.close();

			}

			out.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
		// try {
		// // 以流的形式下载文件。
		// InputStream fis = new BufferedInputStream(new
		// FileInputStream(file.getPath()));
		// byte[] buffer = new byte[fis.available()];
		// fis.read(buffer);
		// fis.close();
		// // 清空response
		// response.reset();
		// OutputStream toClient = new
		// BufferedOutputStream(response.getOutputStream());
		// response.setContentType("application/octet-stream");
		// //如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
		// response.setHeader("Content-Disposition", "attachment;filename=" +
		// URLEncoder.encode(file.getName(), "UTF-8"));
		// toClient.write(buffer);
		// toClient.flush();
		// toClient.close();
		// } catch (IOException ex) {
		// ex.printStackTrace();
		// } finally {
		// try {
		// File f = new File(file.getPath());
		//// f.delete();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// return response;

	}

}
