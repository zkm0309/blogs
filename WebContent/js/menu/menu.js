$(function(){
	var url = $("#ctx").val()+"/menu/findAll.do";
	var setting = {
			treeId:"tree",
			check: {
				enable: true,
				chkStyle: "checkbox", 
				chkboxType: { "Y" : "", "N" : "ps" }
			},
			view: {
				selectedMulti: true
			},
			data: {
				keep: {
					parent:true,
					leaf:true
				},
				simpleData: {
					enable: true
				}
			},
			async: {
				enable: true,
				url:url,
				autoParam:["id","name"]
			},
			callback: {
				onClick : click
			}
			
	};
	
	$.fn.zTree.init($("#treeDemo"), setting);
	
	$("#add").click(function(){
		reset();
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		nodes = zTree.getChangeCheckedNodes();
		if(nodes.length == 1){
			$("input[name=pId]").val(nodes[0].id);
			$("input[name=pName]").val(nodes[0].name);			
		}else{
			layer.msg('请选择一个上级菜单!',{icon:0,time:1000});
		}
	});
	
	$("#batchDel").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getChangeCheckedNodes();
		if(nodes.length == 0){
			layer.msg('请选择一个菜单!',{icon:0,time:1000});
			return;
		}
		var ids = "";
		for(var i = 0; i < nodes.length; i++){
			ids += nodes[i].id+",";
		}
		ids = ids.substring(0, ids.length-1);
		layer.confirm('确认要删除吗？',function(index){
			$.ajax({
				type : "POST",
				url : $("#ctx").val()+"/menu/del.do",
				data : {ids:ids},
				async : false,
				dataType : "json",
				success : function(data) {
					if(data.success){
						refreshNode();
						reset();
						layer.msg('删除成功!',{icon:1,time:1000});						
					}else{
						layer.msg('删除区域中有子菜单,请先删除菜单信息!',{icon:2,time:2000});
					}
				}
			});
		});
	});
	
	
	$("#form-admin-add").validate({
		rules:{
			name:{
				required:true,
				minlength:1,
				maxlength:16
			},
			pName:{
				required:true,
				minlength:1,
				maxlength:16
			},
			menuUrl:{
				required:function(){
					if($("input[name=pId]").val() == ""){
						return true;
					}else if($("input[name=pId]").val()==0){
						return false;
					}
				},
				minlength:1,
				maxlength:100
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
			var url = $("#ctx").val()+"/menu/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/menu/update.do";
			}
			$(form).ajaxSubmit({
				type: 'post',
				url:  url,
				async : false,
    			dataType : "json",
				success: function(data){
					if(data.success){
						layer.msg('保存成功!',{icon:1,time:2000},function(){
							refreshNode();
							reset();
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

function click(event,treeId, treeNode){
    var id=treeNode.id;
	$.ajax({
		type : "POST",
		url : $("#ctx").val()+"/menu/getById.do",
		data : {id:id},
		async : false,
		dataType : "json",
		success : function(data) {
			$("input[name=id]").val(data.id);
			$("input[name=pId]").val(data.pId);
			$("input[name=name]").val(data.name);
			$("input[name=menuUrl]").val(data.menuUrl);
			$("input[name=status][value='"+data.status+"']").prop("checked",true);
			$("input[name=iIndex]").val(data.iIndex);
			$("select[name=openType]").val(data.openType);
			$("textarea[name=remark]").val(data.remark);
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var parentZNode = zTree.getNodeByParam("id", data.pId, null); //获取父节点
			if(parentZNode != null){
				$("input[name=pName]").val(parentZNode.name);				
			}else{
				$("input[name=pName]").val("");
			}
			
		}
	});
}


function refreshNode(){
	var zTree = $.fn.zTree.getZTreeObj("treeDemo"),  
    type = "refresh",  
    silent = false;
    var parentNode = zTree.getNodeByTId(0);
    zTree.selectNode(parentNode);
    zTree.reAsyncChildNodes(parentNode, type, silent);
}


function reset(){
	$("input[name=id]").val("");
	$("input[name=pId]").val("");
	document.getElementById("form-admin-add").reset();
}


