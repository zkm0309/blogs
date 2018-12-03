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
var areaId = 1;
function click(event,treeId, treeNode){
	areaId = treeNode.id;
	_table.draw();
}

function selectArea(){
	layer_show("选择区域",$("#ctx").val()+"/area/selectArea.jsp",300,400);
}

//zkm 2018-9-2 添加用户选择区域
function selectAreaNotLayer(){
	layer_show("选择区域",$("#ctx").val()+"/area/selectAreaNotLayer.jsp",300,400);
}

