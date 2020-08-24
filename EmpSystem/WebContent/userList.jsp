<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<title>用户信息</title>
<style>
.btn1{background-color:#009688;color:#fff;}
.nav{margin-left:-70px;width:800px;display:flex;flex-direction:row;justify-content: space-around;align-items:stretch;}
.btn-sm{background-color:blue;color:#fff;}
</style>
 
</head>
<body>
<center><h1 style="color:#009688">用户信息</h1>
<a href="main.jsp" style="color:#009688">返回主页</a>
<br>

<table id="backViewTable" class="table table-bordered" style="margin:30px auto;">
	<tr><th>用户编号</th><th>用户名</th><th>用户密码</th>
	<c:forEach items="${list}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.userName}</td>
		<td>${user.userPwd}</td>
			
			
		</tr>
		
	</c:forEach>
</table>
<c:if test="${pageNos>1 }">
<a href="ListUserServlet?pageNos=1" >首页</a>
<a href="ListUserServlet?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <recordCount }">
<a href="ListUserServlet?pageNos=${pageNos+1 }">下一页</a>
<a href="ListUserServlet?pageNos=${recordCount }">末页</a>
</c:if>
<form action="./ListUserServlet">
<h4 align="center">共${recordCount}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="到达" style="background-color:red;color:#fff;">
</center>
</body>
</html>