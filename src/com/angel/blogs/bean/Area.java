package com.angel.blogs.bean;

/**
 * 
* @ClassName: Area
* @Description: 区域Bean
* @author zkm
* @date  2018-08-28 15:55
 */
public class Area implements java.io.Serializable{

	private static final long serialVersionUID = 4753370832449867840L;
	
	private int id;
	private String name;
	private int status;
	private String code;
	private int pId;
	private int layer;
	private int iIndex;
	private String remark;

	public Area(){
		
	}

	/**
	 * @param id
	 * @param name
	 * @param status
	 * @param code
	 * @param pId
	 * @param layer
	 * @param iIndex
	 * @param remark
	 */
	public Area(int id, String name, int status, String code, int pId, int layer, int iIndex, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.code = code;
		this.pId = pId;
		this.layer = layer;
		this.iIndex = iIndex;
		this.remark = remark;
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
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * @return the layer
	 */
	public int getLayer() {
		return layer;
	}

	/**
	 * @param layer the layer to set
	 */
	public void setLayer(int layer) {
		this.layer = layer;
	}

	/**
	 * @return the iIndex
	 */
	public int getiIndex() {
		return iIndex;
	}

	/**
	 * @param iIndex the iIndex to set
	 */
	public void setiIndex(int iIndex) {
		this.iIndex = iIndex;
	}

	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
	
	

}
