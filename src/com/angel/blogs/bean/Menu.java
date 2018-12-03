package com.angel.blogs.bean;

/**
 * 
 * @ClassName: Menu
 * @Description: 菜单Bean
 * @author zkm
 * @date 2018-08-29 14:39
 */
public class Menu implements java.io.Serializable {

	private static final long serialVersionUID = -6202739839115809803L;

	private int id;// id
	private String name;// 菜单名称
	private int status;// 状态：-1 删除 0 禁用 1启用
	private String menuUrl;// 菜单URL
	private int pId;// 上级菜单
	private int openType;// 菜单打开方式
	private int iIndex;// 排序
	private String remark;// 备注

	public Menu() {

	}

	/**
	 * @param id
	 * @param name
	 * @param status
	 * @param menuUrl
	 * @param pId
	 * @param openType
	 * @param iIndex
	 * @param remark
	 */
	public Menu(int id, String name, int status, String menuUrl, int pId, int openType, int iIndex, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.menuUrl = menuUrl;
		this.pId = pId;
		this.openType = openType;
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
	 * @param id
	 *            the id to set
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
	 * @param name
	 *            the name to set
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
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the menuUrl
	 */
	public String getMenuUrl() {
		return menuUrl;
	}

	/**
	 * @param menuUrl
	 *            the menuUrl to set
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	/**
	 * @return the pId
	 */
	public int getpId() {
		return pId;
	}

	/**
	 * @param pId
	 *            the pId to set
	 */
	public void setpId(int pId) {
		this.pId = pId;
	}

	/**
	 * @return the openType
	 */
	public int getOpenType() {
		return openType;
	}

	/**
	 * @param openType
	 *            the openType to set
	 */
	public void setOpenType(int openType) {
		this.openType = openType;
	}

	/**
	 * @return the iIndex
	 */
	public int getiIndex() {
		return iIndex;
	}

	/**
	 * @param iIndex
	 *            the iIndex to set
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
	 * @param remark
	 *            the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
