package com.angel.blogs.bean;


/**
 * 
* @ClassName: s_account
* @Description: 账户类
* @author zkm
* @date  2018-08-27 16:12
 */
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = -107859605064716057L;

	private int id;// id
	private String username;// 用户名
	private String accountName;// 账户名
	private String password;// 密码
	private int roId;// 对应角色id
	private int arId;// 对应区域id
	private int iIndex;// 排序
	private String remark;// 备注
	private String createDate;// 创建时间
	private int sex;// 性别：1男 0女
	private String telphone;// 电话
	private String imei; // 手机设备唯一标识
	private int status;// 状态(0:未激活 1:激活 -1:已删除)

	private String aname;//所属区域名
	private String rname;//所属角色名
	
	private String sexname;//存储性别中文名
	private String statusname;//存储状态中文名
	private String useremail;//用户邮箱
	
	private String fileName;//图片名称
	private String fileUrl;//图片URL
	
	
	
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

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getStatusname() {
		return statusname;
	}

	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	public String getSexname() {
		return sexname;
	}

	public void setSexname(String sexname) {
		this.sexname = sexname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoId() {
		return roId;
	}

	public void setRoId(int roId) {
		this.roId = roId;
	}

	public int getArId() {
		return arId;
	}

	public void setArId(int arId) {
		this.arId = arId;
	}

	public int getiIndex() {
		return iIndex;
	}

	public void setiIndex(int iIndex) {
		this.iIndex = iIndex;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
