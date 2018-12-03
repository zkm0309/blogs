$(function() {
	$("#form-t_news-add").validate({
		rules:{
			pname:{
				required:true,
				minlength:1,
				maxlength:100
			},
			psketch:{
				required:true,
				minlength:1,
				maxlength:200
			},
			purl:{
				required:true,
				url:true,
				minlength:1,
				maxlength:90
			},
			
			messages: {
				pname: "请输入图片标题",
				psketch: "请输入图片简述",
				purl: "请输入图片url"
			},
			wxlj:{
				isUrl:true
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/t_picture/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/t_picture/update.do";
			}
			$(form).ajaxSubmit({
				type: 'post',
				url:  url,
				async : false,
    			dataType : "json",
				success: function(data){
					if(data.flag>0){
						layer.msg('保存成功!',{icon:1,time:2000},function(){
							var index = parent.layer.getFrameIndex(window.name);
							parent._table.draw();
							parent.layer.close(index);
						});
					}else{
						layer.msg('保存失败!',{icon:1,time:1000});
					}
				},
                error: function(XmlHttpRequest, textStatus, errorThrown){
					layer.msg('error!',{icon:1,time:1000});
				}
			});
			
		}
	});
	
	
	if($("input[name=id]").val() != ""){
		$.ajax({
			type: 'POST',
			url: $("#ctx").val()+"/t_picture/getById.do",
			dataType: 'json',
			data:{id:$("input[name=id]").val()},
			success: function(data){
				$("input[name=pname]").val(data.map.pname);
				$("input[name=psketch]").val(data.map.psketch);
				$("input[name=purl]").val(data.map.purl);
				$("input[name=piindex]").val(data.map.piindex);
				$("input[name=pstatus]").val(data.map.pstatus);
				if(data.file.NAME != null && data.file.NAME != ""){
					loadImg(data.file.NAME,data.file.FILEURL);
				}
				
			}
		});	
	}
	
	
	//实例化富文本编辑器
	var ue = UE.getEditor( 'container', {
	        autoHeightEnabled: true,
	        autoFloatEnabled: true,
	        initialFrameWidth: 549,
	        initialFrameHeight:300
	    });
	$.fn.zTree.init($("#treeDemo"), setting);
});

//打开窗口权限页面
function selectArea(data){
	if(data==1){
		layer_show("选择区域","../ywxw/selectArea.jsp",300,400);
	}
	if(data==2){
		layer_show("选择区域","../ywxw/selectArea1.jsp",300,400);
	}
}
//点击镇显示权限选择
function showareaid(data){
	if(data==1){
		$('#xuanze').attr('href','javascript:selectArea('+1+');'); 
		$("#areaNames").show();
		$("#xuanze").show();
		$("#areaNames").val("");
		$("#areaid").val("");
	}
	if(data==2){
		$('#xuanze').attr('href','javascript:selectArea('+2+');'); 
		$("#areaNames").show();
		$("#xuanze").show();
		$("#areaNames").val("");
		$("#areaid").val("");
	}
	
}
//点击全部取消
function deleteareaid(){
	$("#areaNames").hide();
	$("#xuanze").hide();
	$("#areaNames").val("");
	$("#areaid").val("");
}

