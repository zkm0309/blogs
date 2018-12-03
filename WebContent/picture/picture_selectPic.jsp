<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- zkm 2018-8-29 css公共样式引用 -->
<title>${sysTitle}</title>
<%@include file="/include/css.jsp"%>
<script type="text/javascript">
window.onload=function(){
	func1();
}
function func1(){
	$("#picture").attr("src",parent.document.getElementById('imageSrc').value);
}
</script>
</head>

<body align="center">

	  <img alt="图片" src="" id="picture" width="100%;" height="100%;">
	  
<!-- zkm 2018-8-29 js 公共部分引用  -->	  
<%@include file="/include/javascript.jsp"%>
</body>
</html>
