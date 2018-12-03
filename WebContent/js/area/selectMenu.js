$(function(){
	var url = $("#ctx").val()+"/menu/findAllByRole.do";
	var setting = {
			treeId:"tree",
			check: {
				enable: true,
				chkStyle: "checkbox", 
				chkboxType: { "Y" : "ps", "N" : "ps" }
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
				onAsyncSuccess: function(event, treeId, treeNode){
					var menuIds = parent.document.getElementById("menuIds").value;
					var menuName = parent.document.getElementById("menuName").value;
					if(menuIds != ""){
						var zTree = $.fn.zTree.getZTreeObj("treeMenu");
						var menuIds_Array = menuIds.split(",");
						for(var index in menuIds_Array){
							var node = zTree.getNodeByParam("id", menuIds_Array[index], null);
							zTree.checkNode(node,true);
						}
						
					}
				}
			}
			
	};
	
	$.fn.zTree.init($("#treeMenu"), setting);
	
	
	
});

function changeMenu(){
	var zTree = $.fn.zTree.getZTreeObj("treeMenu"),
	nodes = zTree.getChangeCheckedNodes();
	var menuIds = "";
	var menuName = "";
	if(nodes.length > 0){
		for(var i = 0; i < nodes.length; i++){
			menuIds += nodes[i].id+",";
			menuName += nodes[i].name+",";
		}
		menuIds = menuIds.substring(0, menuIds.length-1);
		menuName = menuName.substring(0, menuName.length-1);
		var index = parent.layer.getFrameIndex(window.name);
		parent.document.getElementById("menuIds").value = menuIds;
		parent.document.getElementById("menuName").value = menuName;
		parent.layer.close(index);	
	}else{
		layer.msg('请选择权限!',{icon:0,time:1000});
	}
}


