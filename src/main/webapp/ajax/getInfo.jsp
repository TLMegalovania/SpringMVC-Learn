<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.util.Random" %>
<%@ page import="java.io.PrintWriter" %>
<ul>
<%
	PrintWriter myOut = response.getWriter();
	Random r = new Random();
	int x = r.nextInt(10);
	if (x > 5) {
		myOut.print("<li>公告1</li>");
		myOut.print("<li>公告2</li>");
		myOut.print("<li>公告3</li>");
		myOut.println("<li>公告4</li>");
		myOut.println("<li>公告5</li>");
	}
	else {
		myOut.println("<li>暂无公告信息！</li>");
	}
%>

</ul>