<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎</title>
<style type="text/css">
	*{font-size: 12px;}
</style>
</head>
<body>
	<font color="red">
		<s:label value="产品名称"></s:label>
		<s:property value="product.name" /><br>
		<s:label value="产品价格"></s:label>
		<s:property value="product.price" /><br>
		<s:label value="产品厂家"></s:label>
		<s:property value="product.factory" /><br>
	</font>
</body>
</html>