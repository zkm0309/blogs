package com.angel.blogs.bean;

/**
 * 
* @ClassName: Articles
* @Description: 文章bean
* @author zkm
* @date  2018-09-06 17:12
 */
public class Articles {
	private int id;//文章id
	private int uid;//用户id
	private String title;//文章标题
	private String keywords;//文章关键词
	private String content;//文章内容
	private String authorss;//文章作者
	private String sources;//文章来源
	private int iindex;//排序
	private int views;//文章浏览量
	private int comments;//评论总数
	private String createdate;//创建时间
	private int likenum;//点赞数
	private int auditstatus;//审核状态：-1已删除，1审核通过，0未审核
	private int assortmentid;// 分类id
	
	private String assortmentname;//分类名称
	private String[]  articlesTagIds;	//文章标签id
	private String abstracts;//文章简介
	private String auditstatusname;// 状态名称
	
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
	public String getAuditstatusname() {
		return auditstatusname;
	}
	public void setAuditstatusname(String auditstatusname) {
		this.auditstatusname = auditstatusname;
	}
	public String[] getArticlesTagIds() {
		return articlesTagIds;
	}
	public void setArticlesTagIds(String[] articlesTagIds) {
		this.articlesTagIds = articlesTagIds;
	}
	public String getAbstracts() {
		return abstracts;
	}
	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}
	public String getAssortmentname() {
		return assortmentname;
	}
	public void setAssortmentname(String assortmentname) {
		this.assortmentname = assortmentname;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getAuthorss() {
		return authorss;
	}
	public void setAuthorss(String authorss) {
		this.authorss = authorss;
	}
	public String getSources() {
		return sources;
	}
	public void setSources(String sources) {
		this.sources = sources;
	}
	public int getIindex() {
		return iindex;
	}
	public void setIindex(int iindex) {
		this.iindex = iindex;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public int getLikenum() {
		return likenum;
	}
	public void setLikenum(int likenum) {
		this.likenum = likenum;
	}
	public int getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
	}
	public int getAssortmentid() {
		return assortmentid;
	}
	public void setAssortmentid(int assortmentid) {
		this.assortmentid = assortmentid;
	}
	
	
}
