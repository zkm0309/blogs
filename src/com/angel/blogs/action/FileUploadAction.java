package com.angel.blogs.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.angel.blogs.utils.DateUtil;
import com.angel.blogs.utils.OperateProperties;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: FileUploadAction
* @Description:文件上传Action
* @author zkm
* @date  2018-08-31 17:13
 */
@Controller
@RequestMapping("/fileUpload/*")
public class FileUploadAction {
    
    @RequestMapping("image.do")
    public String fileImage(@RequestParam("file") MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) {
    	//设定编码 
        response.setCharacterEncoding("UTF-8");
        //表示是json类型的数据
        response.setContentType("application/json");
        
        String pathLoad = OperateProperties.readValueByKey("fileUploadImage");
        String timePath = DateUtil.formatDate();
        pathLoad += timePath+"/";
        File uploadFile = new File(pathLoad);
        File fileNew = null;
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String name = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileNew = new File(uploadFile, name);
            file.transferTo(fileNew);
            JSONObject json = new JSONObject();
            json.put("fileUploadPath", timePath + "/"+name);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.flush();
            out.close();
        }
        
        return null;
    }
    @RequestMapping("fileeUpload.do")
    public String fileeUpload(@RequestParam("file") MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/Xml;charset=utf-8");
        String pathLoad = OperateProperties.readValueByKey("fileUploadOffice");
        String timePath = DateUtil.formatDate();
        pathLoad += timePath+"/";
        File uploadFile = new File(pathLoad);
        File fileNew = null;
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String name =  file.getOriginalFilename();
            String name1 = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileNew = new File(uploadFile, name1);
            file.transferTo(fileNew);
            JSONObject json = new JSONObject();
            json.put("fileUploadPath", timePath + "/"+name1);
            json.put("fileUploadName",name);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.flush();
            out.close();
        }
        
        return null;
    }
    
    
    @RequestMapping("video.do")
    public String fileVideoUpload(@RequestParam("file") MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/Xml;charset=utf-8");
        String pathLoad = OperateProperties.readValueByKey("fileUploadVideo");
        String timePath = DateUtil.formatDate();
        pathLoad += timePath+"/";
        File uploadFile = new File(pathLoad);
        File fileNew = null;
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String name = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileNew = new File(uploadFile, name);
            file.transferTo(fileNew);
            JSONObject json = new JSONObject();
            json.put("fileUploadVideoPath", timePath + "/"+name);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.flush();
            out.close();
        }
        return null;
    }
    
    @RequestMapping("app.do")
    public String fileApp(@RequestParam("file") MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/Xml;charset=utf-8");
        String pathLoad = OperateProperties.readValueByKey("fileUploadApp");
        String timePath = DateUtil.formatDate();
        pathLoad += timePath+"/";
        File uploadFile = new File(pathLoad);
        File fileNew = null;
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String name = System.currentTimeMillis()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            fileNew = new File(uploadFile, name);
            file.transferTo(fileNew);
            JSONObject json = new JSONObject();
            json.put("fileUploadPath", OperateProperties.readValueByKey("fileUploadAppPath")+timePath + "/"+name);
            DecimalFormat df = new DecimalFormat("#.00");
            String appSize = df.format(new BigDecimal(Float.parseFloat(String.valueOf(file.getSize()))/Float.parseFloat("1024")/Float.parseFloat("1024")));
            json.put("appSize", appSize);
            out.print(json);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            out.flush();
            out.close();
        }
        
        return null;
    }
    
}

