<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${sysTitle}</title>
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@include file="/include/css.jsp"%>
</head>
<body>
<!-- zkm 2018-8-29 菜单选择时显示 菜单层级-->
<%@include file="/include/nav.jsp"%>
<div class="page-container">
	<div class="text-c">
			友情链接标题：
			<input type="text" class="input-text" style="width:250px;" placeholder="友情链接标题" name="name">
			<button type="button" class="btn btn-success" id="searchBtn"><i class="Hui-iconfont">&#xe665;</i>查询</button>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="l">
				<a href="javascript:;" id="batchDel" class="btn btn-danger radius">
					<i class="Hui-iconfont">&#xe6e2;</i> 批量删除
				</a>
				<a href="javascript:;" onclick="admin_add('添加友情链接标题','links_add.jsp','800','500')" class="btn btn-primary radius">
					<i class="Hui-iconfont">&#xe600;</i> 添加友情链接
				</a>
			</span>
			<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="cb-check-all"></th>
						<th>友情链接标题</th>
						<th>Code</th>
						<th>友情链接URL</th>
						<th>创建时间</th>
						<th>备注</th>
						<th width="100">操作</th>
					</tr>
				</thead>
				<tbody></tbody>
			</table>
	</div>
</div>
<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
<script type="text/javascript" src="${ctx}/js/links/links_list.js?${random}"></script>
<script type="text/javascript" src="${ctx}/js/constant.js?${random}"></script>
</body>
</html>
