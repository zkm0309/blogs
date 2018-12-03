
package com.angel.blogs.bean;

/**
 * 
* @ClassName: Assortment
* @Description: 分类Bean
* @author zkm
* @date  2018-09-04 08:51
 */
public class Assortment implements java.io.Serializable{

	private static final long serialVersionUID = 4079270463742146892L;
	
	
	private int id;//id
	private String name;//分类名称
	private int status;//分类状态：-1 删除 0 禁用 1启用
	private String code;//分类code
	private int pId;//上级分类
	private int iIndex;//排序
	private String remark;//备注
	
	public Assortment(){
		
	}

	/**
	 * @param id
	 * @param name
	 * @param status
	 * @param code
	 * @param pId
	 * @param iIndex
	 * @param remark
	 */
	public Assortment(int id, String name, int status, String code, int pId, int iIndex, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.code = code;
		this.pId = pId;
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
