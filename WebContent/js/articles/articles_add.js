$(function(){
	$("#form-admin-add").validate({
		rules:{
			title:{
				required:true,
				minlength:2,
				maxlength:90
			},
			assName:{
				required:true
			},
			keywords:{
				required:true,
				maxlength:30
			},
			abstract:{
				required:true,
				maxlength:200
			},
			remark:{
				maxlength:100
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/articles/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/articles/update.do";
			}
			$(form).ajaxSubmit({
				type: 'post',
				url:  url,
				async : false,
    			dataType : "json",
				success: function(data){
					if(data.success){
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
	
	loadRole();
	if($("input[name=id]").val() != ""){
		$.ajax({
			type: 'POST',
			url: $("#ctx").val()+"/articles/getById.do",
			dataType: 'json',
			data:{id:$("input[name=id]").val()},
			success: function(data){
				$("input[name=title]").val(data.title);
				$("input[name=keywords]").val(data.keywords);
				$("textarea[name=abstracts]").val(data.abstracts);
				$("input[name=authors]").val(data.authors);
				$("input[name=sources]").val(data.sources);
				$("input[name=iindex]").val(data.iindex);
				$("input[name=auditstatus]").val(data.auditstatus);
				$("script[name=content]").val(data.content);
				$("input[name=assId]").val(data.assortmentid);
				$("input[name=assName]").val(data.assortmentname);
				if(data.fileName != null && data.fileName != ""){
					loadImg(data.fileName,data.fileUrl);
				}
			}
		});	
	}

	// 实例化富文本编辑器
	var ue = UE.getEditor( 'container', {
	        autoHeightEnabled: true,
	        autoFloatEnabled: true,
	        initialFrameWidth: 549,
	        initialFrameHeight:300
	    });

});

// zkm 2018-9-11 加载tags 标签
function loadRole(){
	$.ajax({
		type: 'POST',
		url: $("#ctx").val()+"/tags/selectTags.do",
		dataType: 'json',
		async:false,
		success: function(data){
			var html = "";
			for(var index in data){
				html += "<li><input type='checkbox' checked='checked' name='articlesTagIds' value='"+data[index].id+"'>&nbsp;"+data[index].tagname+"</li>&nbsp;&nbsp;";
			}
			$("ul[id=articlesTagIds]").html(html);
		}
	});	
}


// 重置
function loadcz(){
	 var msg = "您真的确定要重置吗？\n\n请确认！";   
	 if (confirm(msg)==true){    
		 $.ajax({
				type: 'POST',
				url: $("#ctx").val()+"/articles/resetPhoneid.do",
				data:{id:$("input[name=id]").val()},
				dataType: 'json',
				async:false,
				success: function(data){
					if(data.success==true){
						layer.msg('重置成功!',{icon:1,time:2000});
					}else{
						layer.msg('重置失败!',{icon:1,time:2000});
					}
				}
			});
		}else{
			return false; 
		} 	
}




