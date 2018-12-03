$(function(){
	var url = $("#ctx").val()+"/task/getZpArea.do";
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
				autoParam:["ID","NAME"]
			},
			callback: {
				onClick : click
			}
			
	};
	$.fn.zTree.init($("#treeDemo"), setting);
	
});
var areaId = 1;
function click(event,treeId, treeNode){
	areaId = treeNode.id;
	_table.draw();
}

function selectArea(){
	layer_show("选择区域","../area/selectArea1.jsp",300,400);
}

