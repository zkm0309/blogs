package com.angel.blogs.bean;

/**
 * 
* @ClassName: Tags
* @Description: 标签bean
* @author zkm
* @date  2018-09-05 09:44
 */
public class Tags {
	
	private static final long serialVersionUID = -107859605064716057L;

	private int id;// id
	private String tagname;//标签标题
	private int status;// 状态：-1 删除 0 禁用 1启用
	private String code;//标签code
	private int iindex;// 排序
	private String tagurl;//标签URL
	private String createdate;// 创建时间
	private String remark;// 备注
	
	
	
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public String getTagurl() {
		return tagurl;
	}
	public void setTagurl(String tagurl) {
		this.tagurl = tagurl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getIindex() {
		return iindex;
	}
	public void setIindex(int iindex) {
		this.iindex = iindex;
	}
	
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
