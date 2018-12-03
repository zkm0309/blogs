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
    <div class="container"> <i class="Hui-iconfont">&#xe67f;</i> <a href="index.html" class="c-primary">首页</a> <span class="c-gray en">&gt;</span>  <span class="c-gray">关于</span> </div>
</nav>

<section class="container">
    <div class="container-fluid">
        <div class="about">
            <h2>Just about me</h2>
            <ul>
                <p>一枚正在努力进步的java程序员。服务器端维护开发。。。</p>
            </ul>
            <h2>About my blog</h2>
            <ul>
                <p>域  名：xalucky.cn 注册于2018年07月19日</p>
                <p>服务器：腾讯云服务器 ，于2018年08月07日完成备案</p>
                <p>备案号：陕ICP备18013591号</p>
                <p>本站定位为IT技术博客站，博客内容主要涉及编程语言、前端开发、服务端开发及一些热门技术等方面，同时分享实用的开发资料。</p>
            </ul>
            <h2>Contact  me</h2>
            <ul>
                <p><i class="Hui-iconfont">&#xe67b;</i>qq : 543***662</p>
                <p><i class="Hui-iconfont">&#xe6d1;</i>git：https://gitee.com/zhangkaimin/events</p>
                <p><i class="Hui-iconfont">&#xe63b;</i>email : 543***662@qq.com</p>
            </ul>
        </div>

    </div>
</section>

<!-- zkm 2018-9-3 底部公共引用 -->
<%@include file="/include/foot.jsp"%>
<!-- zkm 2018-9-3 js公共引用 -->
<%@include file="/include/javascript.jsp"%>

</body>
</html>
