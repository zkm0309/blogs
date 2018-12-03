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
<%@include file="/include/css.jsp"%>
</head>
<body>
	<article class="page-container">
		<ul id="treeDemo" class="ztree"></ul>
	</article>
<%@include file="/include/javascript.jsp"%>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/js/area/selectArea1.js?${random}"></script>
</body>
<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="button" onclick="baocundq()" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
</div>
</html>
