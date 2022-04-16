<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td>
			序号
		</td>
		<td>
			名称
		</td>
		<td>
			价格
		</td>
		<td>
			操作
		</td>
	</tr>
	<c:forEach items="${listProduct}" var ="list">
		<tr>
			<td>
				${list.id }
			</td>
			<td>
				${list.name }
			</td>
			<td>
				${list.price }
			</td>
			<td>
				<input type="button" value="修改" onclick="toUpd(${list.id})"/>
				<input type="button" value="删除" onclick="toDelete(${list.id})"/>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html> 
<script>
	function toUpd(id){
		
		location.href="/productController/getProductById?pId="+id;
	}

    function toDelete(id){

        location.href="/productController/deleteProduct?pId="+id;
    }
</script>