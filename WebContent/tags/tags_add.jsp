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
</head>
<body>
	<article class="page-container">
		<form class="form form-horizontal" id="form-admin-add">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标签标题：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value=""   id="adminName" placeholder="标签标题" name="tagname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>标签URL：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value=""  id="url" placeholder="标签URL" name="tagurl">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">标签code：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="标签code" name="code">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">排序：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="排序" name="iindex">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input name="status" value="0" type="radio" id="sex-1" >
				<label for="sex-1">禁用</label>
				<input name="status" value="1" type="radio" id="sex-2" checked>
				<label for="sex-2">启用</label>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3">备注：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<textarea name="remark" cols="" rows="" class="textarea"  placeholder="100个字符以内" ></textarea>
			</div>
		</div>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input name="id" type="hidden" value="${param.id}" />
				<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
			</div>
		</div>
		</form>
	</article>
<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
<script type="text/javascript" src="${ctx}/js/tags/tags_add.js?${random}"></script>
</body>
</html>
