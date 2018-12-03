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
<!-- zkm 2018-9-3 顶部公共引用 -->
<%@ include file="/include/header.jsp" %>

<!--导航条-->
<nav class="breadcrumb">
    <div class="container"><i class="Hui-iconfont">&#xe67f;</i> <a href="index.html" class="c-primary">首页</a> <span class="c-gray en">&gt;</span> <span class="c-gray">碎言碎语</span></div>
</nav>

<section class="container mt-20">
    <div class="container-fluid">
        <div class="timeline">
			<div class="cd-timeline-block">
			    <div class="cd-timeline-img cd-picture">
			        <img src="${ctx}/css/wilco/css/timeline/cd-icon-location.svg" alt="position">
			    </div>
			    <div class="cd-timeline-content">
			        <h4>测试测试</h4>
			        <p>Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。</p>
			        <a href="http://www.wfyvv.com" class="f-r"><input class="btn btn-success size-S" type="button" value="更多"></a>
			        <span class="cd-date">2017年1月01日</span>
			    </div>
			</div>
			
			<div class="cd-timeline-block">
			    <div class="cd-timeline-img cd-picture">
			        <img src="${ctx}/css/wilco/css/timeline/cd-icon-location.svg" alt="position">
			    </div>
			    <div class="cd-timeline-content">
			        <h4>测试测试</h4>
			        <p>Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。Lao王博客测试版本上线。。</p>
			        <a href="http://www.wfyvv.com" class="f-r"><input class="btn btn-success size-S" type="button" value="更多"></a>
			        <span class="cd-date">2017年1月01日</span>
			    </div>
			</div>
        </div>
    </div>
</section>

<!-- zkm 2018-9-3 底部公共引用 -->
<%@include file="/include/foot.jsp"%>
<!-- zkm 2018-9-3 js公共引用 -->
<%@include file="/include/javascript.jsp"%>
</body>
</html>