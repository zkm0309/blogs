<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sysTitle}</title>
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@include file="/include/css.jsp"%>
</head>
<body>
	<article class="page-container">
		<ul id="treeDemo" class="ztree" style="height:260px;overflow: auto;"></ul>
	</article>
<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/js/assortment/selectAssortment.js?${random}"></script>
</body>
</html>