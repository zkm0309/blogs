<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sysTitle}</title>
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@ include file="/include/css.jsp" %>
</head>
<body>

<script type="text/javascript">
	window.location= "${ctx}/init/init.do";
</script>
  
 <!-- zkm 2018-9-3 底部公共引用 -->
<%@include file="/include/foot.jsp"%>
<!-- zkm 2018-9-3 js公共引用 -->
<%@include file="/include/javascript.jsp"%>
</body>
</html>