package com.angel.blogs.bean;

/**
 * 
* @ClassName: Role
* @Description: 角色Bean
* @author zkm
* @date  2018-08-30 10:29
 */
public class Role implements java.io.Serializable{

	private static final long serialVersionUID = 4510861329145327070L;
	
	
	private int id;//id
	private String name;//角色名称
	private int status;//状态：-1 删除 0 禁用 1启用
	private String code;//角色code
	private int iIndex;//排序
	private String remark;//备注
	private String menuIds;//菜单id
	private String menuName;//菜单名称
	
	public Role(){
		
	}

	/**
	 * @param id
	 * @param name
	 * @param status
	 * @param code
	 * @param iIndex
	 * @param remark
	 */
	public Role(int id, String name, int status, String code, int iIndex, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.code = code;
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

	/**
	 * @return the menuIds
	 */
	public String getMenuIds() {
		return menuIds;
	}

	/**
	 * @param menuIds the menuIds to set
	 */
	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	
	
	
	

}
