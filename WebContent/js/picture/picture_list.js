var $table,_table;
$(function() {
    
	$table = $('.table-sort');
	_table = $table.dataTable($.extend(true,{},CONSTANT.DATA_TABLES.DEFAULT_OPTION, {
        ajax : function(data, callback, settings) {//ajax配置为function,手动调用异步查询
            //封装请求参数
            $.ajax({
                    type: "POST",
                    url: $("#ctx").val()+"/t_picture/findAll.do",
                    cache : false,  //禁用缓存
                    dataType: "json",
                    data:{start:data.start,arId:areaId,name:$("input[name=name]").val(),begintime:$("input[name=begintime]").val(),endtime:$("input[name=endtime]").val()},
                    success: function(result) {
                    	//setTimeout仅为测试延迟效果
                    	setTimeout(function(){
                            //封装返回数据，这里仅演示了修改属性名
                            var returnData = {};
                            returnData.draw = data.draw;
                            returnData.recordsTotal = result.totalCount;	//数据总数
                            returnData.recordsFiltered = result.totalCount;	//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = result.result;				//当前页数据
                            //调用DataTables提供的callback方法，代表数据已封装完成并传回DataTables进行渲染
                            //此时的数据需确保正确无误，异常判断应在执行此回调前自行处理完毕
                            callback(returnData);
                        },200);
                    },
                    error: function(XMLHttpRequest, textStatus, errorThrown) {
                        $.dialog.alert("查询失败");
                    }
                });
		},
		columns: [
        	CONSTANT.DATA_TABLES.COLUMN.CHECKBOX,
            {data: "pname",render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS},
            {data: null,defaultContent:""},
            {data: "psketch",render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS},
            {data: "pcreatedate",render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS},
            {data: "createName",render : CONSTANT.DATA_TABLES.RENDER.ELLIPSIS},
            {data: null,defaultContent:""}
        ],
        createdRow: function ( row, data, index ) {
            //行渲染回调,在这里可以对该行dom元素进行任何操作
        	var loginId = $("#loginId").val();
        	//赋值给image
        	if(data.fileUrl!=""){
        		var $btnimage = $('<img title="图片" style="height:30px;width:40px;" src="'+data.fileUrl+'" </img>');
                $('td', row).eq(2).append($btnimage);
        	}
        	
             //赋值给编辑(判断是否为当前登录者)
             if(loginId==data.pcreateid){
        		 var $btnEdit = $('<a title="编辑" href="javascript:void(0);" onclick="admin_edit(\'图片编辑\',\'picture_add.jsp\',\''+data.id+'\',\'800\',\'500\')" class="ml-5" style="text-decoration:none"><i class="Hui-iconfont">&#xe6df;</i></a>');
                 $('td', row).eq(6).append($btnEdit);
        	}
            
        		
        },
        drawCallback: function( settings ) {
            //渲染完毕后的回调
            //清空全选状态
            $(":checkbox[name='cb-check-all']",$table).prop('checked', false);
            //默认选中第一行
            $("tbody tr",$table).eq(0).click();
        }
		
	})).api();
	
	$table.on("change",":checkbox",function() {
        if ($(this).is("[name='cb-check-all']")) {
            //全选
            $(":checkbox",$table).prop("checked",$(this).prop("checked"));
        }else{
            //一般复选
            var checkbox = $("tbody :checkbox",$table);
            $(":checkbox[name='cb-check-all']",$table).prop('checked', checkbox.length == checkbox.filter(':checked').length);
        }
    }).on("click",".td-checkbox",function(event) {
        //点击单元格即点击复选框
        !$(event.target).is(":checkbox") && $(":checkbox",this).trigger("click");
    });
	
	//查询
	$("#searchBtn").click(function(){
		_table.draw();
	});
	
	
	//批量删除
	$("#batchDel").click(function(){
        var arrItemId = [];
        $("tbody :checkbox:checked",$table).each(function(i) {
            var item = _table.row($(this).closest('tr')).data();
            arrItemId.push(item.id);
        });
        if(arrItemId.length == 0){
        	layer.msg('请选择一行数据!',{icon:0,time:1000});
        	return;
        }
        layer.confirm('确认要删除吗？',function(index){
    		$.ajax({
    			type: 'POST',
    			url: $("#ctx").val()+"/t_picture/delete.do",
    			dataType: 'json',
    			data:{ids:arrItemId.join(",")},
    			success: function(data){
    				if(data.flag){
    					layer.msg('已删除!',{icon:1,time:2000},function(){
    						_table.draw();					
    					});					
    				}
    			},
    			error:function(data) {
    				console.log(data.msg);
    			},
    		});		
    	});
    });
	
});



/*
	参数解释：
	title	标题
	url		请求的url
	id		需要操作的数据id
	w		弹出层宽度（缺省调默认值）
	h		弹出层高度（缺省调默认值）
*/
/*增加*/
function admin_add(title,url,w,h){
	layer_show(title,url,w,h);
}
/*编辑*/
function admin_edit(title,url,id,w,h){
	url = url+"?id="+id;
	layer_show(title,url,w,h);
}
function findbyid(){
    var arrItemId = [];
    var item =null;
    $("tbody :checkbox:checked",$table).each(function(i) {
        item = _table.row($(this).closest('tr')).data();
        arrItemId.push(item.id);
    });
    if(arrItemId.length == 0){
    	layer.msg('请选择一行数据!',{icon:0,time:1000});
    	return;
    }else if(arrItemId.length > 1){
    	layer.msg('只能选择一行数据!',{icon:0,time:1000});
    	return;
    }else{
    	layer_show("查看详情","../picture/picture_details.jsp",800,500);
    	$("#newstitle111").val(item.id);
    }
}





