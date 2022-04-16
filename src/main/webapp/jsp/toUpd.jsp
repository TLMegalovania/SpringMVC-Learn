<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/productController/updateProduct" method="post">

		<table>
			<tr>
				<Td>
					序号：<input type="text" name="id" value="${product.id }" disabled="disabled"/>
						<input type="hidden" name="id" value="${product.id }"/>
				</Td>
			</tr>
			<tr>
				<td>
					名称：<input type="text" name="name" value="${product.name }"/>
					
				</td>
			</tr>
			<tr>
				<Td>
					价格：<input type="text" name="price" value="${product.price }"/>
				</Td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>

	</form>
</body>
</html>