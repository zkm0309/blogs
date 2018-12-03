<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${sysTitle}</title>
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@include file="/include/css.jsp"%>
</head>
<body>
	<article class="page-container">
		<div class="text-c" style="max-height:300px;height:260px;overflow-x:auto;">
			<ul id="treeMenu" class="ztree"></ul>
		</div>
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<a href="javascript:changeMenu();" class="btn btn-primary radius">确定</a>
		</div>
	</article>
<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/js/menu/selectMenu.js?${random}"></script>
</body>
</html>
