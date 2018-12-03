<%@ page pageEncoding="UTF-8"%>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${ctx}/css/H-ui-admin/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/js/H-ui.admin.js"></script> 
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="${ctx}/js/base64.js"></script>
<script type="text/javascript" src="${ctx}/js/md5.js"></script>
<script type="text/javascript" src="${ctx}/js/nav/nav.js?${random}"></script>
<script type="text/javascript" src="${ctx}/js/select_assortmet.js?${random}"></script>  
<script type="text/javascript" src="${ctx}/js/select_area.js?${random}"></script>  
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/zTree/v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/zTree/v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/jquery.validation/1.14.0/validate-methods.js?${random}"></script> 
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/jquery.validation/1.14.0/messages_zh.js?${random}"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/ueditor/1.4.3/ueditor.config.js?${random}"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/ueditor/1.4.3/ueditor.all.min.js?${random}"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/ueditor/1.4.3/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/webuploader/0.1.5/webuploader.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/js/easyui1.5.2/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/css/H-ui-admin/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
//首页时间设置
function currentTime(){ 
  var d=new Date(),str=''; 
  str+=d.getFullYear()+'年'; 
  str+=d.getMonth() + 1+'月'; 
  str+=d.getDate()+'日'; 
  str+=d.getHours()+'时'; 
  str+=d.getMinutes()+'分'; 
  str+= d.getSeconds()+'秒'; 
  return str; 
} 
setInterval(function(){$('#time').html(currentTime)},1000); 
</script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8" src="${ctx}/js/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
	var ue = UE.getEditor('editor');
</script>