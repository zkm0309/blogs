<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>${sysTitle}</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@ include file="/include/css.jsp" %>
<style>
    *{margin: 0;padding: 0;}
    ul, li{list-style: none;}
    .js-mask{width: 98%;height: 132px;border: 1px solid black;position: relative;overflow: hidden;margin:10px;}
    .js-mask ul{position: absolute; left:0; top:0;}
    .js-mask ul li{float:left; width:198px; height: 132px;}
    .js-mask ul li img{width: 198px; height: 132px;}
</style>

</head>
<body>
<!-- zkm 2018-9-3 顶部公共引用 -->
<%@ include file="/include/header.jsp" %>

<section class="container pt-20">
	  <div class="col-sm-9 col-md-9">
	  <!-- zkm 2018-9-4 轮播图 -->
		<div class="js-mask">
		    <ul>
		        <li><img src="${ctx}/images/banner1_2018_9_2.png"/> </li>
		        <li><img src="${ctx}/images/banner2_2018_9_2.png"/> </li>
		        <li><img src="${ctx}/images/banner1_2018_9_2.png"/> </li>
		        <li><img src="${ctx}/images/banner2_2018_9_2.png"/> </li>
		    </ul>
		</div>
		
		<div class="mt-20 bg-fff box-shadow radius mb-5">
			<div class="tab-category">
				<a href=""><strong class="current">最新发布</strong></a>
			</div>
		</div>
		
		<div class="art_content">
			<ul class="index_arc">
				<li class="index_arc_item">
					<a href="#" class="pic">
						<img class="lazyload" data-original="temp/art.jpg" alt="应该选" />
					</a>
					<h4 class="title"><a href="${ctx}/article_detail.jsp">个人博客应该选择什么样的域名和域名后缀</a></h4>
					<div class="date_hits">
						<span>老王</span>
						<span>2017-02-24</span>
						<span><a href="/article-lists/10.html">程序人生</a></span>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
						<p class="commonts"><i class="Hui-iconfont" title="点击量">&#xe622;</i> <span class="cy_cmt_count">20</span></p>
					</div>
					<div class="desc">不论搭建什么样的网站，选择一个好的域名都是很有必要的，选择一个好的域名对网站的意义也是不言而喻的。每一个网站都有之对应的域名，就像人的名字一样。每个人都想自己有个好听的名字，网站也是一样。一个网站可以有多个域名，但是一个域名只能对应一个网站。&nbsp;一、域名要好记，方便输入&nbsp; &nbsp; &nbsp; &nbsp;域名本身的意义就是为了人们方便记忆才使用的，不然都用IP地址就好了。所以，网站域名一定要选择好记忆的。因为域名是</div>
				</li>

				<li class="index_arc_item no_pic">
					<h4 class="title"><a href="/article/5.html">个人博客应该选择什么样的域名和域名后缀</a></h4>
					<div class="date_hits">
						<span>老王</span>
						<span>2个月前</span>
						<span><a href="/article-lists/10.html">建站</a></span>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276 °</p>
						<p class="commonts"><i class="Hui-iconfont" title="点击量">&#xe622;</i> <span id="sourceId::105" class="cy_cmt_count">20</span></p>
					</div>
					<div class="desc"> 不论搭建什么样的网站，选择一个好的域名都是很有必要的，选择一个好的域名对网站的意义也是不言而喻的。每一个网站都有之对应的域名，就像人的名字一样。每个人都想自己有个好听的名字，网站也是一样。一个网站可以有多个域名，但是一个域名只能对应一个网站。&nbsp;一、域名要好记，方便输入&nbsp; &nbsp; &nbsp; &nbsp;域名本身的意义就是为了人们方便记忆才使用的，不然都用IP地址就好了。所以，网站域名一定要选择好记忆的。因为域名是</div>
				</li>
				
				<li class="index_arc_item">
	            	<a href="/article/4" class="pic">
	                	<img class="lazyload" data-original="temp/art.jpg" alt="centos 6.5 nginx安装及配置" >
	            	</a>
	        		<h4 class="title"><a href="/article/4">centos 6.5 nginx安装及配置</a></h4>
	        		<div class="date_hits">
			            <span>老王</span>
			            <span>2017-3-15</span>
			            <span>
			                <a href="/article?t=1">程序人生</a>
			            </span>
		            	<p class="hits"><i class="Hui-iconfont" title="点击量"></i> 13° </p>
		            	<p class="commonts"><i class="Hui-iconfont" title="评论"></i> <span class="cy_cmt_count">0</span></p>
	        		</div>
	        		<div class="desc">linux环境中nginx安装及配置简要概述。。。</div>
	   		  </li>
		</ul>
		
  		<div class="text-c mb-20" id="moreBlog">
	        <a class="btn  radius btn-block " href="javascript:;" onclick="moreBlog();">点击加载更多</a>
	        <a class="btn  radius btn-block hidden" href="javascript:;">加载中……</a>
	    </div>
	    
	</div>
  </div>
  
  <!--right-->
  <div class="col-sm-3 col-md-3">
  	<!--站点声明-->
    <div class="panel panel-default mb-20">
        <div class="panel-body">
            <i class="Hui-iconfont" style="float: left;">&#xe62f;&nbsp;</i>
            <div class="slideTxtBox">
                <div class="bd">
                    <ul>
                        <li><a href="javascript:void(0);">Lao张博客测试版上线，欢迎访问</a></li>
                        <li><a href="javascript:void(0);">内容如有侵犯，请立即联系管理员删除</a></li>
                        <li><a href="javascript:void(0);">本站内容仅供学习和参阅，不做任何商业用途</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
        
  	<!--博主信息-->
    <div class="bg-fff box-shadow radius mb-20">
        <div class="tab-category">
            <a href=""><strong>博主信息</strong></a>
        </div>
        <div class="tab-category-item">
            <ul class="index_recd">
                <li class="index_recd_item"><i class="Hui-iconfont">&#xe653;</i>姓名：蓝精灵</li>
                <li class="index_recd_item"><i class="Hui-iconfont">&#xe70d;</i>职业：Java开发</li>
                <li class="index_recd_item"><i class="Hui-iconfont">&#xe63b;</i>邮箱：<a href="mailto:543059662@qq.com">543059662@qq.com</a></li>
                <li class="index_recd_item"><i class="Hui-iconfont">&#xe671;</i>定位：陕西 &middot;西安</li>
            </ul>
        </div>
    </div>
  	
  	<!--热门推荐-->
  	<div class="bg-fff box-shadow radius mb-20">
			<div class="tab-category">
				<a href=""><strong>热门推荐</strong></a>
			</div>
			<div class="tab-category-item">
				<ul class="index_recd">
					<li>
						<a href="#">阻止a标签href默认跳转事件</a>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
					</li>
					<li >
						<a href="#">PHP面试题汇总</a>
						<p class="hits"><i class="Hui-iconfont" title="点击量">&#xe622;</i> 276 </p>
					</li>
					
				</ul>
			</div>
		</div>
		
		<!--点击排行-->
        <div class="bg-fff box-shadow radius mb-20">
            <div class="tab-category">
                <a href=""><strong>点击排行</strong></a>
            </div>
            <div class="tab-category-item">
                <ul class="index_recd clickTop">
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                    <li>
                        <a href="#">AJAX的刷新和前进后退问题解决</a>
                        <p class="hits"><i class="Hui-iconfont" title="点击量">&#xe6c1;</i> 276° </p>
                    </li>
                </ul>
            </div>
        </div>
        
		<!--标签-->
		<div class="bg-fff box-shadow radius mb-20">
			<div class="tab-category">
				<a href=""><strong>标签云</strong></a>
			</div>
			<div class="tab-category-item">
				<div class="tags"> 
					<a href="http://www.h-ui.net/">H-ui前端框架</a> 
					<a href="http://www.h-ui.net/websafecolors.shtml">Web安全色</a> 
					<a href="http://www.h-ui.net/Hui-4.4-Unslider.shtml">jQuery轮播插件</a> 
					<a href="http://www.h-ui.net/site.shtml">IT网址导航</a> 
					<a href="http://www.h-ui.net/icon/index.shtml">网站常用小图标</a> 
					<a href="http://www.h-ui.net/tools/jsformat.shtml">web工具箱</a> 
					<a href="http://www.h-ui.net/bg/index.shtml">网站常用背景素材</a> 
					<a href="http://www.h-ui.net/easydialog-v2.0/index.html">弹出层插件</a> 
					<a href="http://www.h-ui.net/SuperSlide2.1/demo.html">SuperSlide插件</a> 
					<a href="http://www.h-ui.net/TouchSlide1.1/demo.html">TouchSlide</a>
				</div>
			</div>
		</div>
		
		<!--图片-->
		<div class="bg-fff box-shadow radius mb-20">
			<div class="tab-category">
				<a href=""><strong>扫我关注</strong></a>
			</div>
			<div class="tab-category-item">
				<img src="${ctx}/images/ljl_ewm_2018_9_3.jpg" class="img-responsive lazyload" alt="扫我关注">
			</div>
		</div>
		
		<!--友情链接-->
		<div class="bg-fff box-shadow radius mb-20">
			<div class="tab-category">
				<a href=""><strong>友情链接</strong></a>
			</div>
			<div class="tab-category-item">
				<span><i class="Hui-iconfont">&#xe6f1;</i><a href="#" class="btn-link">腾讯</a></span>
				<span><i class="Hui-iconfont">&#xe6f1;</i><a href="#" class="btn-link">慕课网</a></span>
			</div>
		</div>
		<!--最近访客-->
		<div class="bg-fff box-shadow radius mb-20">
            <div class="tab-category">
                <a href=""><strong>最近访客</strong></a>
            </div>
            <div class="panel-body">
                <ul class="recent">
                    <div class="item"><img src="${ctx}/css/wilco/img/40.jpg" alt=""></div>
                    <div class="item"><img src="${ctx}/css/wilco/img/40.jpg" alt=""></div>
                </ul>
            </div>
        </div>
        
		<!--分享-->
        <div class="bg-fff box-shadow radius mb-20">
            <div class="tab-category">
                <a href=""><strong>站点分享</strong></a>
            </div>
            <div class="panel-body">
                <div class="bdsharebuttonbox Hui-share"><a href="#" class="bds_weixin Hui-iconfont" data-cmd="weixin" title="分享到微信">&#xe694;</a><a href="#" class="bds_qzone Hui-iconfont" data-cmd="qzone" title="分享到QQ空间">&#xe6c8;</a> <a href="#" class="bds_sqq Hui-iconfont" data-cmd="sqq" title="分享到QQ好友">&#xe67b;</a> <a href="#" class="bds_tsina Hui-iconfont" data-cmd="tsina" title="分享到新浪微博">&#xe6da;</a> <a href="#" class="bds_tqq Hui-iconfont" data-cmd="tqq" title="分享到腾讯微博">&#xe6d9;</a></div>
            </div>
        </div>
  </div>
</section>

<!-- zkm 2018-9-3 底部公共引用 -->
<%@include file="/include/foot.jsp"%>
<!-- zkm 2018-9-3 js公共引用 -->
<%@include file="/include/javascript.jsp"%>
</body>
</html>
