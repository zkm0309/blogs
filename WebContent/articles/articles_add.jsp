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
<style type="text/css">

li{ display:inline} 
</style>
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal"  id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="标题" name="title">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div id="uploader-demo">
				    <div id="fileList" class="uploader-list"></div>
				    <div id="filePicker">选择图片</div>
				    <button id="deleteFile" type="button" class="btn webuploader-pick radius" style="display:none;">删除</button>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>关键词：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="关键词" name="keywords">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>简介：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="abstracts"  class="textarea"  placeholder="说点什么...最少输入10个字符" "></textarea>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">作者：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" readonly="readonly" class="input-text"  name="authorss" value="${sessionScope.account.username}"   placeholder="作者" name="authors">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">来源：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text"  placeholder="来源" name="sources">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">排序：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="排序" name="iindex">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>分类：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" id="assName" name="assName" readonly="readonly"  style="width:150px;">
				<input id="assId" name="assId" type="hidden" />
				<a href="javascript:selectAssortmetNotLayer();" class="btn btn-primary radius">选择</a>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">标签：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<div class="check-box" id="apitesttry">
				    <ul  id="articlesTagIds" ></ul>
				</div>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input name="auditstatus" value="0" type="radio" id="sex-1" >
				<label for="sex-1">未审核</label>
				<input name="auditstatus" value="1" type="radio" id="sex-2" checked>
				<label for="sex-2">审核通过</label>
			</div>
		</div>
		<div class="row cl ">
			<label class="form-label col-xs-4 col-sm-3">文章内容：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<script id="editor" name="content" type="text/plain"></script>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input name="id" type="hidden" value="${param.id}" />
				<input class="btn btn-primary radius"  type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
		</form>
	</article>
<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
<script type="text/javascript" src="${ctx}/js/articles/articles_add.js?${random}"></script>
<script type="text/javascript" src="${ctx}/js/articles/webUploader.js?${random}"></script> 
</body>
</html>
