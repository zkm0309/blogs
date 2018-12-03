$(function(){

	$("#login_btn").click(function(){
		var ln = $("input[name=ln]").val();
		var lp = $("input[id=displaylp]").val();
		if(ln == ""){
			layer.msg("请输入账户",{icon:0,time:3000});
			return;
		}
		if(ln != "" && (ln.length < 4 || ln.length > 16)){
			layer.msg("账户长度必须是4~16个字符",{icon:0,time:3000});
			return;
		}
		if(lp == ""){
			layer.msg("请输入密码",{icon:0,time:3000});
			return;
		}
		if(lp != "" && (lp.length < 6 || lp.length > 16)){
			layer.msg("密码长度必须是6~16个字符",{icon:0,time:3000});
			return;
		}
		$("input[name=lp]").val(hex_md5(lp));
		$("form").ajaxSubmit({
			type: 'POST',
			url: $("#ctx").val()+"/account/login.do",
			dataType: 'json',
			async : false,
			success: function(data){
				if(data.success){
					location.href=$("#ctx").val()+data.path;
				}else{
					layer.msg(data.msg,{icon:0,time:1000});
				}
			},error: function(XmlHttpRequest, textStatus, errorThrown){
				layer.msg('error!',{icon:2,time:1000});
			}
			
		});
	});
});