$(function(){
	$.ajax({
		type: 'POST',
		url: $("#ctx").val()+"/task/findAllDep.do",
		dataType: 'json',
		success: function(data){
			 for(var o in data){  
			        $("#depId").append(" <option value=\""+data[o].ID+"\">"+data[o].NAME+"</option> ");
			      }  
		}
	});	
	$("#form-admin-add").validate({
		rules:{
			tagname:{
				required:true,
				minlength:2,
				maxlength:40
			},
			tagurl:{
				required:true,
				url:true,
				minlength:1,
				maxlength:90
			},
			iindex:{
				number:true
			},
			remark:{
				maxlength:200
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/tags/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/tags/update.do";
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
	
	
	if($("input[name=id]").val() != ""){
		 var str="";
		$.ajax({
			type: 'POST',
			url: $("#ctx").val()+"/tags/getById.do",
			dataType: 'json',
			data:{id:$("input[name=id]").val()},
			success: function(data){
				$("input[name=tagname]").val(data.tagname);
				$("input[name=code]").val(data.code);
				$("input[name=tagurl]").val(data.tagurl);
				$("input[name=status]").val(data.status);
				$("textarea[name=remark]").val(data.remark);
				$("input[name=iindex]").val(data.iindex);
			}
		});	
	}
	
});


//zkm 2018-8-30 角色添加菜单选择
function selectMenu(){
	layer_show("选择区域","../menu/selectMenu.jsp",300,400);
}

