$(function(){
	var url = $("#ctx").val()+"/task/getZpArea.do";
	var setting = {
			treeId:"tree",
			check: {
				enable: true,
				chkStyle: "checkbox",
			},
			view: {
				selectedMulti: true
			},
			data: {
	 			key:{
	 				name:'NAME'
	 			},
	 			simpleData: {
	 				enable: true,
	 				idKey: "ID",
	 				pIdKey:"PID"
	 			}
	 		},
			async: {
				enable: true,
				url:url,
			},
			callback: {
				onClick : onCheck
			}
			
	};
	
	$.fn.zTree.init($("#treeDemo"), setting);
});

function onCheck(event,treeId, treeNode){
	/*
	var id = treeNode.id;
	var name = treeNode.name;
	var index = parent.layer.getFrameIndex(window.name);
	parent.document.getElementById("arId").value = id;
	parent.document.getElementById("aName").value = name;
	
	parent.layer.close(index);*/
}
function baocundq(){ 
	 var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
     var  nodes=treeObj.getCheckedNodes(true);
     var idx="";
	 var namex="";
     for(var i=0;i<nodes.length;i++){
    	 if(nodes[i].type==1){
	    	 if(idx==""){
	    		 idx=nodes[i].ID;
	    		 namex=nodes[i].NAME;
	    	 }else{
	    		 idx+=","+nodes[i].ID;
	    		 namex+=","+nodes[i].NAME;
	    	 }
    	 }
     }
     parent.document.getElementById("arId").value = idx;
 	 parent.document.getElementById("aName").value = namex;
 	var index = parent.layer.getFrameIndex(window.name);
 	parent.layer.close(index);
}


