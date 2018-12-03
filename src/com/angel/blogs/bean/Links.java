package com.angel.blogs.bean;

/**
 * 
* @ClassName: Links
* @Description: 友情链接bean
* @author zkm
* @date  2018-09-04 13:53
 */
public class Links {
	
	private static final long serialVersionUID = -107859605064716057L;

	private int id;// id
	private String title;//链接标题
	private int status;// 状态：-1 删除 0 禁用 1启用
	private String code;//连接code
	private int iindex;// 排序
	private String linksurl;//友情链接URL
	private String createdate;// 创建时间
	private String remark;// 备注
	
	
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
	public String getLinksurl() {
		return linksurl;
	}
	public void setLinksurl(String linksurl) {
		this.linksurl = linksurl;
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
