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
			name:{
				required:true,
				minlength:2,
				maxlength:50
			},
			code:{
				minlength:1,
				maxlength:20
			},
			iIndex:{
				number:true
			},
			remark:{
				maxlength:100
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/role/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/role/update.do";
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
			url: $("#ctx").val()+"/role/getById.do",
			dataType: 'json',
			data:{id:$("input[name=id]").val()},
			success: function(data){
				$("input[name=name]").val(data.name);
				$("input[name=code]").val(data.code);
				$("input[name=iIndex]").val(data.iIndex);
				$("input[name=status]").val(data.status);
				$("textarea[name=remark]").val(data.remark);
				$("input[name=menuIds]").val(data.menuIds);
				$("textarea[name=menuName]").val(data.menuName);
				 $("#depId option").each(function(){  //遍历所有option  
			          var txt = $(this).val();   //获取option值   
			          if(txt!=''){
			        	  if(txt==data.did){
			        		  str+=" <option selected=\"selected\"  value=\""+$(this).val()+"\">"+$(this).text()+"</option> "; 
			        	  }else{
			        		  str+=" <option   value=\""+$(this).val()+"\">"+$(this).text()+"</option> "; 
			        	  }
			          }  
			     }) 
			      $("#depId").html(str);
			}
		});	
	}
	
});


//zkm 2018-8-30 角色添加菜单选择
function selectMenu(){
	layer_show("选择区域","../menu/selectMenu.jsp",300,400);
}

