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
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@include file="/include/css.jsp"%>
</head>
<body>
<!-- zkm 2018-8-29 菜单选择时显示 菜单层级-->
<%@include file="/include/nav.jsp"%>
<table class="table">
	<tr>
		<td width="200" class="va-t"><ul id="treeDemo" class="ztree"></ul></td>
		<td class="va-t" style="text-align:left;">
			<div class="cl pd-5 bg-1 bk-gray mt-20">
				<span class="l">
					<a href="javascript:;" id="batchDel" class="btn btn-danger radius">
						<i class="Hui-iconfont">&#xe6e2;</i> 删除
					</a>
					<a href="javascript:;" id="add" class="btn btn-primary radius">
						<i class="Hui-iconfont">&#xe600;</i> 添加
					</a>
				</span>
			</div>
			<article class="page-container">
				<form class="form form-horizontal" id="form-admin-add">
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							<span class="c-red">*</span>区域名称：</label>
						<div class="formControls col-xs-6 col-sm-6">
							<input type="text" class="input-text" placeholder="区域名称" name="name">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							<span class="c-red">*</span>上级区域：</label>
						<div class="formControls col-xs-6 col-sm-6">
							<input type="text" class="input-text" placeholder="上级区域" id="aName" name="pName" readonly="readonly" style="width:150px;">
							<input id="arId" name="pId" type="hidden" />
							<a href="javascript:selectArea();" class="btn btn-primary radius">选择</a>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							区域层级：</label>
						<div class="formControls col-xs-6 col-sm-2">
							<span class="select-box" style="width:150px;">
								<select class="select" name="layer" size="1">
									<option value="1">省</option>
									<option value="2">市</option>
									<option value="3">区</option>
									<option value="4">县</option>
									<option value="5">镇</option>
								</select>
							</span>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							区域CODE：</label>
						<div class="formControls col-xs-6 col-sm-6">
							<input type="text" class="input-text" placeholder="区域CODE" name="code">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							状态：</label>
						<div class="formControls col-xs-6 col-sm-4">
								<input name="status" value="1" type="radio" id="sex-1" checked>
								<label for="sex-1">启用</label>
								<input name="status" value="0" type="radio" id="sex-2">
								<label for="sex-2">禁用</label>
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">
							排序：</label>
						<div class="formControls col-xs-6 col-sm-6">
							<input type="text" class="input-text" placeholder="排序" name="iIndex">
						</div>
					</div>
					<div class="row cl">
						<label class="form-label col-xs-4 col-sm-2">备注：</label>
						<div class="formControls col-xs-6 col-sm-6">
							<textarea name="remark" cols="" rows="" class="textarea"  placeholder="100个字符以内" ></textarea>
						</div>
					</div>
					<div class="row cl">
						<div class="col-9 col-offset-2">
							<input name="id" type="hidden" />
							<input class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
						</div>
					</div>
				</form>
			</article>
		</td>
	</tr>
</table>
<!-- zkm 2018-8-29 js 公共部分引用  -->
<%@include file="/include/javascript.jsp"%>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${ctx}/js/area/area.js?${random}"></script>
</body>
</html>
