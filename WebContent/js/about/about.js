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
			aboutme:{
				required:true,
				minlength:20,
				maxlength:200
			},
			domainname:{
				required:true,
				minlength:10,
				maxlength:50
			},
			servers:{
				required:true,
				minlength:20,
				maxlength:80
			},
			record:{
				required:true,
				minlength:10,
				maxlength:40
			},
			remark:{
				required:true,
				minlength:20,
				maxlength:200
			},
			qq:{
				required:true,
				minlength:9,
				maxlength:20
			},
			git:{
				required:true,
				minlength:10,
				maxlength:40
			},
			email:{
				required:true,
				email: true, 
				minlength:10,
				maxlength:20
			},
			remark:{
				maxlength:200
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/about/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/about/update.do";
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
			url: $("#ctx").val()+"/about/getById.do",
			dataType: 'json',
			data:{id:$("input[name=id]").val()},
			success: function(data){
				$("textarea[name=aboutme]").val(data.aboutme);
				$("input[name=domainname]").val(data.domainname);
				$("input[name=servers]").val(data.servers);
				$("input[name=record]").val(data.record);
				$("textarea[name=remark]").val(data.remark);
				$("input[name=qq]").val(data.qq);
				$("input[name=git]").val(data.git);
				$("input[name=email]").val(data.email);
			}
		});	
	}
});





