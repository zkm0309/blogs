<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/css/wilco/plugin/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${ctx}/css/wilco/plugin/layer/3.0/layer.js"></script>
<script type="text/javascript" src="${ctx}/css/wilco/plugin/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/css/wilco/plugin/pifu/pifu.js"></script>
<script type="text/javascript" src="${ctx}/css/wilco/js/common.js"></script>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } function showSide(){$('.navbar-nav').toggle();}</script>
<script> $(function(){ $(window).on("scroll",backToTopFun); backToTopFun(); }); </script>
<script type="text/javascript" src="${ctx}/css/wilco/plugin/jquery.SuperSlide/2.1.1/jquery.SuperSlide.min.js"></script>

<script>
/**
 * 首页轮播图
 */
(function(){
    var oUl = document.querySelectorAll('.js-mask ul')[0];
    // 获取ul里的li进行拼接，然后重新赋给ul
    oUl.innerHTML = oUl.innerHTML + oUl.innerHTML // oUl.innerHTML += oUl.innerHTML
    // 由于ul初始时是4张图片的宽度，现在把宽度变成是8张的宽度 获取li，根据li的宽度重新设置ul的宽度
    var oLies = document.querySelectorAll('.js-mask li');   // 获取li
    oUl.style.width = oLies[0].offsetWidth * oLies.length + 'px';   // 设置宽度，li的宽度*li的个数
    var speed = -1;
    setInterval(function(){
        if (oUl.offsetLeft <= -oUl.offsetWidth*.5){
            oUl.style.left = '0px'; 
        }
        oUl.style.left = oUl.offsetLeft + speed + 'px';
    }, 1000/30);
})();
</script>

<script>
$(function(){
//标签
	$(".tags a").each(function(){
		var x = 9;
		var y = 0;
		var rand = parseInt(Math.random() * (x - y + 1) + y);
		$(this).addClass("tags"+rand)
	});
	
	$("img.lazyload").lazyload({failurelimit : 3});
});

</script> 

<script type="text/javascript" src="${ctx}/css/wilco/plugin/wangEditor/js/wangEditor.min.js"></script>
<script type="text/javascript">
    $(function () {
        wangEditor.config.printLog = false;
        var editor1 = new wangEditor('textarea1');
        editor1.config.menus = ['insertcode', 'quote', 'bold', '|', 'img', 'emotion', '|', 'undo', 'fullscreen'];
        editor1.config.emotions = { 'default': { title: '老张表情', data: '../plugin/wangEditor/emotions1.data'}, 'default2': { title: '老张心情', data: '../plugin/wangEditor/emotions3.data'}, 'default3': { title: '顶一顶', data: '../plugin/wangEditor/emotions2.data'}};
        editor1.create();

        //show reply
        $(".hf").click(function () {
            pId = $(this).attr("name");
            $(this).parents(".commentList").find(".cancelReply").trigger("click");
            $(this).parent(".comment-body").append($(".comment").clone(true));
            $(this).parent(".comment-body").find(".comment").removeClass("hidden");
            $(this).hide();
        });
        //cancel reply
        $(".cancelReply").on('click',function () {
            $(this).parents(".comment-body").find(".hf").show();
            $(this).parents(".comment-body").find(".comment").remove();
        });
    });

</script>
<script>
    $(function () {
        $(window).on('scroll', function () {
            $('.cd-timeline-block').each(function () {
                if ($(this).offset().top <= $(window).scrollTop() + $(window).height() * 0.75 && $(this).find('.cd-timeline-img').hasClass('is-hidden')) {
                    $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden').addClass('bounce-in');
                }
                if ($(window).scrollTop() - $(this).offset().top > 0) {
                    $(this).find('.cd-timeline-img, .cd-timeline-content').addClass('is-hidden').removeClass('bounce-in');
                }
                
            });
           $('.cd-timeline-block').each(function(){
                if($(this).offset().top < $(window).scrollTop()+$(window).height()*0.75) {
                    $(this).find('.cd-timeline-img, .cd-timeline-content').removeClass('is-hidden');
                }
            });
        });
    });
</script>
<script src="${ctx}/js/jquery.liMarquee.js"></script>
<script>
$(function(){
	$('.dowebok').liMarquee();
});
</script>
