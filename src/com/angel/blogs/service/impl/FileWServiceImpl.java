package com.angel.blogs.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.angel.blogs.bean.CxfFileWrapper;
import com.angel.blogs.service.FileWService;


@Service
public class FileWServiceImpl implements FileWService {

	@Override
	public boolean upload(CxfFileWrapper file) {
		 boolean result = true;
	        OutputStream os = null;
	        InputStream is = null;
	        BufferedOutputStream bos = null;
	        try {
	            is = file.getFile().getInputStream();
	            File dest = new File("d:\\upload\\" + file.getFileName());
	            os = new FileOutputStream(dest);
	            bos = new BufferedOutputStream(os);
	            byte[] buffer = new byte[1024*1024];
	            int len = 0;
	            while ((len = is.read(buffer)) != -1) {
	                bos.write(buffer, 0, len);
	            }
	            bos.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	            result = false;
	        } finally {
	            if(bos != null){
	                try{
	                    bos.close();
	                }catch(Exception e){                    
	                }
	            }
	            if(os != null){
	                try{
	                    os.close();
	                }catch(Exception e){                    
	                }
	            }
	            if(is != null){
	                try{
	                    is.close();
	                }catch(Exception e){                    
	                }
	            }
	        }
	        return result;
	}

	@Override
	public CxfFileWrapper download() {
		 //下载文件的路径
        String filePath = "D:\\test.xlsx";
       CxfFileWrapper fileWrapper = new CxfFileWrapper();
       fileWrapper.setFileName("test.xlsx");
       fileWrapper.setFileExtension("xlsx");
       DataSource source = new FileDataSource(new File(filePath));
       fileWrapper.setFile(new DataHandler(source));
       return fileWrapper;
	}

}
