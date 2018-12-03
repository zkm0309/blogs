package com.angel.blogs.bean;


import java.util.List;
import java.util.Map;

public class YwxwPublic implements java.io.Serializable{

	/**
	 * 手机端 业务新闻
	 */
	private static final long serialVersionUID = -3731112581788167412L;
	private int id;  					//id
	private String title;				//标题
	private String sketch;				//简述
	private String createdate;				//时间
	private String img;					//详情
	private String infoUrl;				//详情url
	private String wxUrl;
	private List<Map<String,Object>> videoList;		//视频集合 内包括视频名称和视频url
	
	public List<Map<String, Object>> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Map<String, Object>> videoList) {
		this.videoList = videoList;
	}
	
	
	public String getWxUrl() {
		return wxUrl;
	}
	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSketch() {
		return sketch;
	}
	public void setSketch(String sketch) {
		this.sketch = sketch;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getInfoUrl() {
		return infoUrl;
	}
	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}
	
	
}
