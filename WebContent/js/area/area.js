$(function(){

	var url = $("#ctx").val()+"/area/findAll.do";
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
		
	});
	
	$("#batchDel").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var nodes = zTree.getChangeCheckedNodes();
		if(nodes.length == 0){
			layer.msg('请选择一个区域!',{icon:0,time:1000});
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
				url : $("#ctx").val()+"/area/del.do",
				data : {ids:ids},
				async : false,
				dataType : "json",
				success : function(data) {
					if(data.success){
						refreshNode();
						reset();
						layer.msg('删除成功!',{icon:1,time:1000});						
					}else{
						layer.msg('删除区域中有子区域,请先删除区域信息!',{icon:2,time:2000});
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
			code:{
				minlength:2,
				maxlength:16
			},
			iIndex:{
				number:true
			},
			remark:{
				maxlength:100
			},
			areaArea:{
				number:true
			}
			
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
		submitHandler:function(form){
			var url = $("#ctx").val()+"/area/add.do";
			if($("input[name=id]").val()!=""){
				url = $("#ctx").val()+"/area/update.do";
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
		url : $("#ctx").val()+"/area/getById.do",
		data : {id:id},
		async : false,
		dataType : "json",
		success : function(data) {
			$("input[name=id]").val(data.id);
			$("input[name=pId]").val(data.pId);
			$("input[name=code]").val(data.code);
			$("input[name=name]").val(data.name);
			$("input[name=status][value='"+data.status+"']").prop("checked",true);
			$("input[name=iIndex]").val(data.iIndex);
			$("select[name=layer]").val(data.layer);
			$("textarea[name=remark]").val(data.remark);
			$("input[name=areaArea]").val(data.areaArea);
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


