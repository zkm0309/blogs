$(function(){
	
	$("#form-admin-add").validate({
		rules:{
			displaylp:{
				required:true,
				minlength:6,
				maxlength:16
			},
			password2:{
				required:true,
				minlength:6,
				maxlength:16,
				equalTo: "#password"
			}
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/account/reset.do";
			$("input[name=password]").val(hex_md5($("input[name=displaylp]").val()));
			$(form).ajaxSubmit({
				type: 'post',
				url:  url,
				async : false,
    			dataType : "json",
				success: function(data){
					if(data.success){
						layer.msg('保存成功!',{icon:1,time:2000},function(){
							parent.layer.closeAll();
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

});


