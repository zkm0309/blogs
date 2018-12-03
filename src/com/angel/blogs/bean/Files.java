package com.angel.blogs.bean;

/**
 * 
* @ClassName: Files
* @Description: 文件Bean
* @author zkm
* @date  2018-09-05 14:16
 */
public class Files implements java.io.Serializable{
	
	private static final long serialVersionUID = 993196299123827768L;
	
	
	private int id;//id
	private String name;//文件名称
	private int status;//-1 删除 1正常
	private String fileUrl;//文件url
	private String fingerTable;//指定表
	private int fingerId;//指定Id
	private int type;//1 图片 2 文件
	private String suffix;//后缀 列 jpg
	
	
	public Files(){
		
	}


	/**
	 * @param id
	 * @param name
	 * @param status
	 * @param fileUrl
	 * @param fingerTable
	 * @param fingerId
	 * @param type
	 * @param suffix
	 */
	public Files(int id, String name, int status, String fileUrl, String fingerTable, int fingerId, int type,
			String suffix) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.fileUrl = fileUrl;
		this.fingerTable = fingerTable;
		this.fingerId = fingerId;
		this.type = type;
		this.suffix = suffix;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}


	/**
	 * @return the fileUrl
	 */
	public String getFileUrl() {
		return fileUrl;
	}


	/**
	 * @param fileUrl the fileUrl to set
	 */
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}


	/**
	 * @return the fingerTable
	 */
	public String getFingerTable() {
		return fingerTable;
	}


	/**
	 * @param fingerTable the fingerTable to set
	 */
	public void setFingerTable(String fingerTable) {
		this.fingerTable = fingerTable;
	}


	/**
	 * @return the fingerId
	 */
	public int getFingerId() {
		return fingerId;
	}


	/**
	 * @param fingerId the fingerId to set
	 */
	public void setFingerId(int fingerId) {
		this.fingerId = fingerId;
	}


	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}


	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}


	/**
	 * @param suffix the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	
	

}
