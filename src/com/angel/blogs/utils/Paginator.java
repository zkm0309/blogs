package com.angel.blogs.utils;

import java.util.List;

/**
 * ClassName:Paginator<br/>
 * Description:bootstrap分页工具类<br/>
 * @author 	changboalong<br/>
 * @date 	2018-01-09 03:29:42<br/>
 */
public class Paginator {
	
	protected List<?> result = null;			//当前页数据
	protected int currentPage = 1;				//当前页码
	protected int pageSize = 5;				//每页显示多少行数据   5：电子围栏分页显示为每页5条数据如需更改，请对实施位置和轨迹查询进行二次修改
	protected int totalPages = -1;				//总页数
	protected int totalCount = -1;				//总数据数
	
	public Paginator(){
		
	}
	
	
	/**
	 * @return the result
	 */
	public List<?> getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(List<?> result) {
		this.result = result;
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return totalCount==0?0:currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	/**
	 * @return the totalPages
	 */
	public int getTotalPages() {
		return (int) Math.ceil((double) totalCount / (double) getPageSize());
	}
	/**
	 * @param totalPages the totalPages to set
	 */
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}


	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}


	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	

}
