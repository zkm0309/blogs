<%@ page pageEncoding="UTF-8"%>
<%@ page import="java.util.Random"%>
<%@ page import="com.angel.blogs.utils.OperateProperties"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="sysTitle" value="个人博客后台管理系统" />
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="page"/>
<%
Random rand = new Random();
long random = rand.nextLong();
String fileUploadPath = OperateProperties.readValueByKey("fileUploadPath");
%>
<c:set var="random" value="<%=random%>" scope="page"/>
<c:set var="fileUploadPath" value="<%=fileUploadPath%>" scope="page"/>
<input type="hidden" id="ctx" value="${ctx}" />
<input type="hidden" id="loginId" value="${sessionScope.account.id}" />
<input type="hidden" id="fileUploadPath" value="${fileUploadPath}" />
