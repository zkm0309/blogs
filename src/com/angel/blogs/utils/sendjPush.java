package com.angel.blogs.utils;
import net.sf.json.JSONObject;
import cn.jpush.api.common.APIConnectionException;
import cn.jpush.api.common.APIRequestException;
import cn.jpush.api.push.PushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class sendjPush {
	
	 private static final String appKey ="5a11acd6f53c7628fa2e1e55" ;
	 private static final String masterSecret = "eb5cd14264ec07a5211a211d";
	 private static final int cssStyle=2;
	
	 
	 
	 
	 
	 public static String send(String params){
		 
		 JSONObject obj = JSONObject.fromObject(params);
		 System.out.println("发送消息:"+obj.toString());
		 int  sendNo =obj.getInt("sendNo");
		 
		 String title=obj.getString("title");
		 
		 String content=obj.getString("content");
		   
		 int cssStyle=2;
		 
		 String sendtype =obj.getString("sendtype");
		 
		 String receiverValue=obj.getString("receiverValue");
		 String url="";
		 url= obj.getString("url");
		 PushPayload payload =null;
		 //别名
		 if(sendtype.equals("ALIAS")){
			 payload=PushPayload
	         .newBuilder()
	         .setPlatform(Platform.all())
	         .setAudience(Audience.alias(receiverValue.split(",")))
	         .setNotification(Notification.newBuilder()
			        		                   .setAlert(content)
			        		                   .addPlatformNotification(
			        		                   IosNotification.newBuilder().setAlert(content)
			        		                   .setSound("default")
			        		                   .addExtra("url",url).addExtra("title",title)
			        		                   .build()).addPlatformNotification(
			        		                		   AndroidNotification.newBuilder().setAlert(content)
			        		                		  .setTitle(title).setBuilderId(cssStyle)
			        		                		   .addExtra("url",url).build()).build())
			       .setOptions(Options.newBuilder()
			        		 .setSendno(1)
			        		 .setTimeToLive(86400)
			        		 .setApnsProduction(true)
			        		 .build()).build();
			 
		 }else if(sendtype.equals("APPKEYS")){
			//广播
			 
			 payload=PushPayload
	         .newBuilder()
	         .setPlatform(Platform.all())
	         .setAudience(Audience.all())
	         .setNotification(Notification.newBuilder()
			        		                   .setAlert(content)
			        		                   .addPlatformNotification(
			        		                   IosNotification.newBuilder().setAlert(content)
			        		                   .setSound("happy")
			        		                   .addExtra("url",url).addExtra("title",title)
			        		                   .build()).addPlatformNotification(
			        		                		   AndroidNotification.newBuilder().setAlert(content)
			        		                		  .setTitle(title).setBuilderId(cssStyle)
			        		                		   .addExtra("url",url).build()).build())
			       .setOptions(Options.newBuilder()
			        		 .setSendno(sendNo)
			        		 .setTimeToLive(86400)
			        		 .setApnsProduction(true)
			        		 .build()).build();
			 
		 }else if(sendtype.equals("TAG")){
			//标签
			 payload=PushPayload
	         .newBuilder()
	         .setPlatform(Platform.all())
	         .setAudience(Audience.tag(receiverValue))
	         .setNotification(Notification.newBuilder()
			        		                   .setAlert(content)
			        		                   .addPlatformNotification(
			        		                   IosNotification.newBuilder().setAlert(content)
			        		                   .setSound("happy")
			        		                   .addExtra("url",url).addExtra("title",title)
			        		                   .build()).addPlatformNotification(
			        		                		   AndroidNotification.newBuilder().setAlert(content)
			        		                		  .setTitle(title).setBuilderId(cssStyle)
			        		                		   .addExtra("url",url).build()).build())
			       .setOptions(Options.newBuilder()
			        		 .setSendno(sendNo)
			        		 .setTimeToLive(86400)
			        		 .setApnsProduction(true)
			        		 .build()).build();
		 
		 } 
		 PushClient pushClient = new PushClient(masterSecret, appKey);
		 
		 System.err.println(pushClient+"------pushClient----");
		 try {
			 PushResult msgResult= pushClient.sendPush(payload);
			 
			 System.out.println("ok");
			 return "ok";
		 } catch (APIConnectionException e) {
			System.out.println(e);
			return "error";
		} catch (APIRequestException e) {
			System.out.println(e);
			return "error";
		}
	 }
	 
	public static String getAppkey() {
		return appKey;
	}

	public static void main(String[] args) {
		JSONObject json=new JSONObject(); 
		json.put("sendNo", "1917");
		json.put("title", "天气变暖注意添加衣物");
		json.put("content", "天气变暖注意添加衣物");
		json.put("sendtype", "ALIAS");
		json.put("url", "#"); 
		json.put("receiverValue", "u_1042414");//u_1234440,u_1234420 ma :u_1227784  u_1049539   comm_13338
		sendjPush.send(json.toString());
	}

}
