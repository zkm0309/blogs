<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${sysTitle}</title>
<%@include file="/include/css.jsp"%>
<script type="text/javascript">
window.onload=function(){
	func1();
}
function func1(){
	  $.ajax({
		type: 'POST',
		url: $("#ctx").val()+"/t_picture/getById.do",
		dataType: 'json',
		data:{id:parent.document.getElementById('newstitle111').value},
		success: function(data){
			$("#newstitle").html(data.map.pname);
			$("#newssketch").html(data.map.psketch);
			$("#newstime").html(data.map.pcreatedate);
			if(data.map.purl!=null&&data.map.purl!=""){
				$("#wxlj").html(data.map.purl);
			}else{
				$("#wxlj").html("无");
			}
			if(data.fileURL!=null&&data.fileURL!=""){
				$("#image").attr("src",data.fileURL);
				$("#image").css("height","80px");
				$("#image").css("width","100px");
				$("#image").css("border","3px solid #000");
				$("#image").css("cursor","pointer");
				$("#imageSrc").val(data.fileURL);
			}else{
				$("#imagezw").html("无");
			}
		},
	});	  	
}
function selectPic(){
	layer_show("查看图片","../picture/picture_selectPic.jsp",720,450);
}
</script>
</head>
<body>
	<article class="page-container">
	<table class="table table-border table-bordered table-hover">
	<tr>
	 <th><span>图片标题:</span></th>
	 <td><span id="newstitle"></span></td>
	</tr>
	<tr>
	 <th><span>简述:</span></th>
	 <td><span id="newssketch"></span></td>
	</tr>
	<tr>
	 <th><span>图片URL:</span></th>
	 <td><span id="wxlj"></span></td>
	</tr>
	<tr>
	<th><span>图片:</span></th>
	<td><span id="imagezw"></span><img id="image" src="" onclick="selectPic()"></img>
	<input type="text" id="imageSrc" hidden="hedden">
	</td>
	</tr>
	<tr>
	 <th><span>创建时间:</span></th>
	 <td><span id="newstime"></span></td>
	</tr>
	</table>
	</article>

<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
</body>
</html>
