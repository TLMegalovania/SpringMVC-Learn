<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一个Struts2程序</title>
</head>
<body>
	第二个Struts2程序!访问默认方法
	<br>

	<form action="greeting.action" method="post">
		请输入你的姓名：<input type="text" name="username">
		<input type="submit" value="提交">
	</form>

	<br>
	第三个Struts2程序!访问指定方法
	<br>
	<a href="userAction!add.action">添加用户</a>
	<br>
	<a href="userAction!update.action">更新用户</a>
	<br>

	<br>
	第四个Struts2程序!访问动态方法
	<br>
	<a href="userAction_add.action">添加用户</a>
	<br>
	<a href="userAction_update.action">更新用户</a>
	<br>

	<br>
	第五个Struts2程序!访问动态方法->提交数据
	<s:form action="productAction_add.action" method="post">
		<s:textfield name ="product.name" label= "产品名称" > </s:textfield>
		<s:textfield name ="product.price" label= "价格" > </s:textfield>
		<s:textfield name ="product.factory" label= "厂家" > </s:textfield>
		<s:submit value="增加产品"></s:submit>
	</s:form>

	<br>
	第五个Struts2程序!访问动态方法->获取数据
	<s:form action="productAction_get.action" method="get">
		<s:submit value="获取产品"></s:submit>
	</s:form>
</body>
</html>