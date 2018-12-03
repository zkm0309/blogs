$(function(){
	$("#form-admin-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			accountName:{
				required:true,
				minlength:4,
				maxlength:16
			},
			displaylp:{
				required:function(){
					return $("input[name=id]").val()!=""?false:true;
				},
				minlength:6,
				maxlength:16
			},
			password2:{
				required:function(){
					return $("input[name=id]").val()!=""?false:true;
				},
				minlength:6,
				maxlength:16,
				equalTo: "#password"
			},
			username:{
				required:true
			},
			aName:{
				required:true
			},
			useremail:{
				required: true,  
			    email: true, 
			    minlength:1,
				maxlength:90
			},
			roId:{
				required:true
			},
			telphone:{
				required: true, 
				isMobile:true,
				min:11
			},
			remark:{
				maxlength:100
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/account/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/account/update.do";
			}
			$("input[name=password]").val(hex_md5($("input[name=displaylp]").val()));
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
			url: $("#ctx").val()+"/account/getById.do",
			dataType: 'json',
			data:{id:$("input[name=id]").val()},
			success: function(data){
				$("input[name=username]").val(data.username);
				$("input[name=accountName]").val(data.accountName);
				$(".password").hide();
				$("select[name=roId]").val(data.roId);
				$("input[name=arId]").val(data.arId);
				$("input[name=iindex]").val(data.iIndex);
				$("input[name=useremail]").val(data.useremail);
				$("input[name=aName]").val(data.aname);
				$("input[name=sex]").val(data.sex);
				$("input[name=status]").val(data.status);
				$("input[name=telphone]").val(data.telphone);
				$("textarea[name=remark]").val(data.remark);
				if(data.fileName != null && data.fileName != ""){
					loadImg(data.fileName,data.fileUrl);
				}
			}
		});	
	}

});

function loadRole(){
	$.ajax({
		type: 'POST',
		url: $("#ctx").val()+"/role/selectRole.do",
		dataType: 'json',
		async:false,
		success: function(data){
			var html = "";
			for(var index in data){
				html += "<option value='"+data[index].id+"'>"+data[index].name+"</option>";
			}
			$("select[name=roId]").html(html);
		}
	});	
}


//重置
function loadcz(){
	 var msg = "您真的确定要重置吗？\n\n请确认！";   
	 if (confirm(msg)==true){    
		 $.ajax({
				type: 'POST',
				url: $("#ctx").val()+"/account/resetPhoneid.do",
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




