$(function(){

	if($("#m").val() != undefined){
		$.ajax({
			type: 'POST',
			url: $("#ctx").val()+"/menu/getNav.do",
			dataType: 'json',
			data:{id:$("#m").val()},
			success: function(data){
				$("#pName").html(data.pName);
				$("#name").html(data.name);
			}
		});
	}
	
});