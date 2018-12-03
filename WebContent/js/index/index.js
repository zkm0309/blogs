$(function(){
	setInterval(infoRefresh,15000);
	$.ajax({
		type: 'POST',
		url: $("#ctx").val()+"/menu/myMenu.do",
		dataType: 'json',
		success: function(data){
			var rHtml="",pHtml="",cHtml="",pSeparatorStart="<dl>",pSeparatorEnd="</dl>",
			cSeparatorStart="<dd><ul>",cSeparatorEnd="</ul></dd>",count=0;
			for(var index in data){
				rHtml += pSeparatorStart+'<dt>'+data[index].name
					+'<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>'
					+cSeparatorStart;
				var children = data[index].children;
				for(var i in children){
					rHtml += '<li><a data-href="'+children[i].menuUrl+'?m='+children[i].id+'" data-title="'
						+children[i].name+'" href="javascript:void(0)">'+children[i].name+'</a></li>';
				}
				rHtml += cSeparatorEnd+pSeparatorEnd;
			}
			$(".bk_2").html(rHtml);
		    $(".Hui-aside").Huifold({
		    	titCell:'.menu_dropdown dl dt',
		    	mainCell:'.menu_dropdown dl dd',
		    });
			
		}
	});	
	
});

//zkm 2018-8-29 注销退出
function loginOut(){
	layer.confirm('确定要退出？',function(index){
		location.href=$("#ctx").val()+"/account/loginOut.do";
	});
}

function infoRefresh(){
	$.ajax({
		type:'post',
		url: 'task/promptTask.do',
		success:function(data){
			if(data>0){
				var title = '';
				var message = '';
				title = '任务消息';
				message = '<a   href="javascript:Hui_admin_tabx()">您有'+data+'条新的任务</a>  ';
				
				//右下角弹框
				$.messager.show({
	       			title:title,
	       			height:'50px',
	       			msg:message,
	       			timeout:15000,		//5秒超时关闭
	       			showType:'slide'
	       		});
			}
		}
	});
}

function reset_pwd(title,url,w,h){
	layer_show(title,url,w,h);
}


function Hui_admin_tabx(obj){
		bStopIndex = 0,
		href ='task/index.jsp?m=42',
		title = '管护任务',
		topWindow = $(window.parent.document),
		show_navLi = topWindow.find("#min_title_list li"),
		iframe_box = topWindow.find("#iframe_box");
	show_navLi.each(function() {
		if($(this).find('span').attr("data-href")==href){
			bStop=true;
			bStopIndex=show_navLi.index($(this));
			return false;
		}
	});

		creatIframe(href,title);
		min_titleList();
}
/*最新tab标题栏列表*/
function min_titleList(){
	var topWindow = $(window.parent.document),
		show_nav = topWindow.find("#min_title_list"),
		aLi = show_nav.find("li");
}
/*创建iframe*/
function creatIframe(href,titleName){
	var topWindow=$(window.parent.document),
		show_nav=topWindow.find('#min_title_list'),
		iframe_box=topWindow.find('#iframe_box'),
		iframeBox=iframe_box.find('.show_iframe'),
		$tabNav = topWindow.find(".acrossTab"),
		$tabNavWp = topWindow.find(".Hui-tabNav-wp"),
		$tabNavmore =topWindow.find(".Hui-tabNav-more");
	var taballwidth=0;
		
	show_nav.find('li').removeClass("active");	
	show_nav.append('<li class="active"><span data-href="'+href+'">'+titleName+'</span><i></i><em></em></li>');
	if('function'==typeof $('#min_title_list li').contextMenu){
		$("#min_title_list li").contextMenu('Huiadminmenu', {
			bindings: {
				'closethis': function(t) {
					var $t = $(t);				
					if($t.find("i")){
						$t.find("i").trigger("click");
					}
				},
				'closeall': function(t) {
					$("#min_title_list li i").trigger("click");
				},
			}
		});
	}else {
		
	}	
	var $tabNavitem = topWindow.find(".acrossTab li");
	if (!$tabNav[0]){return}
	$tabNavitem.each(function(index, element) {
        taballwidth+=Number(parseFloat($(this).width()+60))
    });
	$tabNav.width(taballwidth+25);
	var w = $tabNavWp.width();
	if(taballwidth+25>w){
		$tabNavmore.show()}
	else{
		$tabNavmore.hide();
		$tabNav.css({left:0})
	}	
	iframeBox.hide();
	iframe_box.append('<div class="show_iframe"><div class="loading"></div><iframe frameborder="0" src='+href+'></iframe></div>');
	var showBox=iframe_box.find('.show_iframe:visible');
	showBox.find('iframe').load(function(){
		showBox.find('.loading').hide();
	});
}