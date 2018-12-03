package com.angel.blogs.utils;

/**
 * 
* @ClassName: FormatSql
* @Description:格式化SQL
* @author zkm
* @date  2018-08-30 15:17
 */
public class FormatSql {
	
	
	/**
	 * 分页查询SQL
	 * @param columns			字段名称
	 * @param tableName			表名称
	 * @param where				where查询条件
	 * @param order				查询排序
	 * @param start				数据位置(从1开始计算)
	 * @return
	 * @author changbaolong
	 * @date 2018-01-15 02:18:12
	 */
	public static String queryPageSql(String columns,String selectSql,String start){
		int offset = 10;
		int prev = 0;
		if(Integer.parseInt(start) > 0){
			prev = Integer.parseInt(start)+1;
			offset = prev+10;
		}
		//String findSql = "SELECT "+columns+" FROM ( SELECT A.*, ROWNUM RN FROM ("+selectSql+") A WHERE ROWNUM <= "+offset+" ) WHERE RN >= "+prev;
		
		String findSql = "SELECT "+columns+" FROM ("+selectSql+") AS t LIMIT "+prev+","+offset+"";
		
		return findSql;
	}
	
	/**
	 * 固定查找10条记录  ..
	 */
	public static String queryTenListSql(String columns,String selectSql,String start){
		int offset = 10;
		int prev = 0;
		String findSql="";
		if(Integer.parseInt(start) >= 1){
			//findSql = "SELECT "+columns+" FROM ( SELECT A.*, ROWNUM RN FROM ("+selectSql+") A WHERE ROWNUM <= 0 ) ";
			
			findSql = "select "+columns+" from ("+selectSql+") AS t  limit 0";
			
		}else{
			findSql = "select "+columns+" from ("+selectSql+") AS t   limit 10";
		}
		
		return findSql;
	}
	
	/***
	 * 此方法只限于配合地图人员查询使用
	 * @param columns
	 * @param selectSql
	 * @param start
	 * @return
	 */
	public static String queryPageSqlList(String columns,String selectSql,String start){
		int offset = 5;
		int prev = 0;
		if(Integer.parseInt(start) > 0){
			prev = (Integer.parseInt(start)-1)*5;
			offset = Integer.parseInt(start)*5;
		}
		//String findSql = "SELECT "+columns+" FROM ( SELECT A.*, ROWNUM RN FROM ("+selectSql+") A WHERE ROWNUM <= "+offset+" ) WHERE RN > "+prev;
		
		String findSql = "SELECT "+columns+" FROM ("+selectSql+") AS t  LIMIT "+prev+","+offset+"";
		return findSql;
	}

}
