package com.angel.blogs.bean;

/**
 * 
 * @ClassName: Picture
 * @Description: 轮播图bean
 * @author zkm
 * @date 2018-09-05 14:07
 */
public class Picture {

	private int id;// id
	private String pname;// 图片名称
	private String psketch;// 图片简介
	private int pstatus;// 图片状态：-1删除 1 启用，0，禁用
	private String pcreatedate;// 图片创建时间
	private int piindex;// 排序
	private int pcreateid;// 创建者id
	private String purl;// 图片链接URL

	private String createName;// 创建者名称
	private String fileName;// 文件名称
	private String fileUrl;// 文件URL

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsketch() {
		return psketch;
	}

	public void setPsketch(String psketch) {
		this.psketch = psketch;
	}

	public int getPstatus() {
		return pstatus;
	}

	public void setPstatus(int pstatus) {
		this.pstatus = pstatus;
	}

	public String getPcreatedate() {
		return pcreatedate;
	}

	public void setPcreatedate(String pcreatedate) {
		this.pcreatedate = pcreatedate;
	}

	public int getPiindex() {
		return piindex;
	}

	public void setPiindex(int piindex) {
		this.piindex = piindex;
	}

	public int getPcreateid() {
		return pcreateid;
	}

	public void setPcreateid(int pcreateid) {
		this.pcreateid = pcreateid;
	}

	public String getPurl() {
		return purl;
	}

	public void setPurl(String purl) {
		this.purl = purl;
	}

}
