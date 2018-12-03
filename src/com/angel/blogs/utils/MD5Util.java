package com.angel.blogs.utils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

public class MD5Util {

	private static char md5Chars[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static MessageDigest messagedigest;

	/** 获取一个文件的md5码 */
	public static String getFileMD5String(File file) throws Exception {
		
		messagedigest = MessageDigest.getInstance("MD5");
		FileInputStream in = new FileInputStream(file);
		try{
			FileChannel ch = in.getChannel();
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
					file.length());
			messagedigest.update(byteBuffer);
		}
		finally{
			if(in != null){
				in.close();
			}
		}
		return bufferToHex(messagedigest.digest());
	}

	/** 获取一个文件流的md5码 */
	public static String getInputStreamMD5String(InputStream is)
			throws Exception {
		try{
			if(is == null || !(is instanceof FileInputStream || is instanceof ByteArrayInputStream)){
				throw new Exception("流为空或不为文件流");
			}
			if(is instanceof FileInputStream){
				FileInputStream fis = (FileInputStream) is;
				messagedigest = MessageDigest.getInstance("MD5");
				FileChannel ch = fis.getChannel();
				MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
						fis.available());
				messagedigest.update(byteBuffer);
			}
			else{
				byte[] bytes = new byte[1024];  
		        int len = 0;
		        messagedigest = MessageDigest.getInstance("MD5");
		        while ((len = is.read(bytes)) > 0) { 
		            messagedigest.update(bytes, 0, len);  
		        }
			}
		}
		finally{
			if(is != null){
				is.close();
			}
		}
		return bufferToHex(messagedigest.digest());
	}

	/** 获取一个字符串的md5码 */
	public static String getStringMD5String(String str) throws Exception {
		messagedigest = MessageDigest.getInstance("MD5");
		messagedigest.update(str.getBytes());
		return bufferToHex(messagedigest.digest()).toUpperCase();
	}

	/** 验证一个字符串和一个MD5码是否相等 */
	public static boolean check(String str, String md5) throws Exception {
		if (getStringMD5String(str).equals(md5))
			return true;
		else
			return false;
	}

	/** 验证一个文件和一个MD5码是否相等 */
	public static boolean check(InputStream f, String md5) throws Exception {
		if (getInputStreamMD5String(f).equals(md5))
			return true;
		else
			return false;
	}

	/** 验证一个文件和一个MD5码是否相等 */
	public static boolean check(File f, String md5) throws Exception {
		if (getFileMD5String(f).equals(md5))
			return true;
		else
			return false;
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = md5Chars[(bt & 0xf0) >> 4];
		char c1 = md5Chars[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}
	
	public static void main(String[] a){
		try {
			System.out.println(getStringMD5String("manager"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
