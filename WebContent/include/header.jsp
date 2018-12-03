<%@ page pageEncoding="UTF-8"%>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container cl">
            <a class="navbar-logo hidden-xs" href="index.html">
                <img class="logo" src="${ctx}/images/logo_2018_9_2.png" alt="Lao王博客" />
            </a>
            <a class="logo navbar-logo-m visible-xs" href="index.html">Lao王博客</a>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:void(0);" onclick="showSide();">&#xe667;</a>
            <nav class="nav navbar-nav nav-collapse w_menu" role="navigation">
                <ul class="cl">
                    <li class="active"> <a href="${ctx}/init/init.do" data-hover="首页">首页</a> </li>
                    <li> <a href="${ctx}/about.jsp" data-hover="关于我">关于我</a> </li>
                    <li> <a href="${ctx}/mood.jsp" data-hover="碎言碎语">碎言碎语</a> </li>
                    <li><a href="${ctx}/article.jsp" data-hover="学无止尽">学无止尽</a></li>
                    <li> <a href="${ctx}/board.jsp" data-hover="留言板">留言板</a> </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
