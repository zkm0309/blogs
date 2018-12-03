$(function(){
	var url = $("#ctx").val()+"/area/findAll.do";
	var setting = {
			treeId:"tree",
			check: {
				enable: false
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
	
});

function click(event,treeId, treeNode){
	var id = treeNode.id;
	var name = treeNode.name;
	var index = parent.layer.getFrameIndex(window.name);
	parent.document.getElementById("arId").value = id;
	parent.document.getElementById("aName").value = name;
	parent.layer.close(index);
}


