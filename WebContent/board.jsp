<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${sysTitle}</title>
<!-- zkm 2018-8-29 css公共样式引用 -->
<%@ include file="/include/css.jsp" %>
</head>
<body>
<!-- zkm 2018-9-3 顶部公共引用 -->
<%@ include file="/include/header.jsp" %>

<!--导航条-->
<nav class="breadcrumb">
    <div class="container"> <i class="Hui-iconfont">&#xe67f;</i> <a href="index.html" class="c-primary">首页</a> <span class="c-gray en">&gt;</span>  <span class="c-gray">留言板</span> </div>
</nav>

<section class="container">
    <div class="col-xs-12 col-md-10 col-md-offset-1 mt-20">
        <!--用于评论-->
        <div class="mt-20" id="ct">
            <div id="err" class="Huialert Huialert-danger hidden radius">成功状态提示</div>
            <textarea id="textarea1" name="comment" style="height:200px;" placeholder="看完不留一发？"> </textarea>
            <div class="text-r mt-10">
                <button onclick="getPlainTxt()" class="btn btn-primary radius" > 发表评论</button>
            </div>
        </div>

        <div class="line"></div>

        <ul class="commentList mt-50">

          <li class="item cl"> <a href="#"><i class="avatar size-L radius"><img alt="" src="http://q.qlogo.cn/qqapp/101388738/1CF8425D24660DB8C3EBB76C03D95F35/100"></i></a>
                <div class="comment-main">
                    <header class="comment-header">
                        <div class="comment-meta"><a class="comment-author" href="#">老张</a>
                            <time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20" class="f-r">2014-8-31 15:20</time>
                        </div>
                    </header>
                    <div class="comment-body">
                        你是猴子派来的救兵吗？

                        <ul class="commentList">
                            <li class="item cl"> <a href="#"><i class="avatar size-L radius"><img alt="" src="http://qzapp.qlogo.cn/qzapp/101388738/1CF8425D24660DB8C3EBB76C03D95F35/100"></i></a>
                                <div class="comment-main">
                                    <header class="comment-header">
                                        <div class="comment-meta"><a class="comment-author" href="#">老张</a>
                                            <time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20" class="f-r">2014-8-31 15:20</time>
                                        </div>
                                    </header>
                                    <div class="comment-body">
                                        <p> 是的</p>
                                    </div>
                                </div>
                            </li>
                            <li class="item cl"> <a href="#"><i class="avatar size-L radius"><img alt="" src="http://qzapp.qlogo.cn/qzapp/101388738/696C8A17B3383B88804BA92ECBAA5D81/100"></i></a>
                                <div class="comment-main">
                                    <header class="comment-header">
                                        <div class="comment-meta"><a class="comment-author" href="#">老张</a>
                                            <time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20" class="f-r">2014-8-31 15:20</time>
                                        </div>
                                    </header>
                                    <div class="comment-body">
                                        <p> +1</p>
                                    </div>
                                </div>
                            </li>

                        </ul>

                        <button class="hf f-r btn btn-default size-S mt-10" name="2">回复</button>

                    </div>
                </div>
            </li>
            <li class="item cl"> <a href="#"><i class="avatar size-L radius"><img alt="" src="http://qzapp.qlogo.cn/qzapp/101388738/1CF8425D24660DB8C3EBB76C03D95F35/100"></i></a>
                <div class="comment-main">
                    <header class="comment-header">
                        <div class="comment-meta"><a class="comment-author" href="#">老张</a>
                            <time title="2014年8月31日 下午3:20" datetime="2014-08-31T03:54:20" class="f-r">2014-8-31 15:20</time>
                        </div>
                    </header>
                    <div class="comment-body">
                        你是猴子派来的救兵吗？

                        <button class="hf f-r btn btn-default size-S mt-10" name="3">回复</button>

                    </div>
                </div>
            </li>

        </ul>
        <!--用于回复-->
        <div class="comment hidden mt-20">
            <div id="err2" class="Huialert Huialert-danger hidden radius">成功状态提示</div>
            <textarea class="textarea" style="height:100px;" > </textarea>
            <button onclick="hf(this);" type="button" class="btn btn-primary radius mt-10">回复</button>
            <a class="cancelReply f-r mt-10">取消回复</a>
        </div>

    </div>
</section>


<!-- zkm 2018-9-3 底部公共引用 -->
<%@include file="/include/foot.jsp"%>
<!-- zkm 2018-9-3 js公共引用 -->
<%@include file="/include/javascript.jsp"%>
</body>
</html>
