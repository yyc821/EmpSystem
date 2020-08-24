<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<title>员工信息</title>
<style>
.btn1{background-color:#009688;color:#fff;}
.nav{margin-left:-70px;width:800px;display:flex;flex-direction:row;justify-content: space-around;align-items:stretch;}
.btn-sm{background-color:blue;color:#fff;}
</style>
 
</head>
<body>
<center><h1 style="color:#009688">员工信息</h1>
<a href="main.jsp" style="color:#009688">返回主页</a>
<br>

<table id="backViewTable" class="table table-bordered" style="margin:30px auto;">
	<tr><th>员工编号</th><th>员工姓名</th><th>员工工作</th><th>员工工资</th><th>员工奖金</th><th>雇佣时间</th><th>领导编号</th><th>部门编号</th>
	<c:forEach items="${list}" var="emp">
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.sal}</td>
			<td>${emp.comm}</td>
			<td>${emp.hiredate}</td>
			<td>${emp.mgr}</td>
			<td>${emp.deptno}</td>
			
			
		</tr>
		
	</c:forEach>
</table>
<c:if test="${pageNos>1 }">
<a href="ListEmpServlet?pageNos=1" >首页</a>
<a href="ListEmpServlet?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <recordCount }">
<a href="ListEmpServlet?pageNos=${pageNos+1 }">下一页</a>
<a href="ListEmpServlet?pageNos=${recordCount }">末页</a>
</c:if>
<form action="./ListEmpServlet">
<h4 align="center">共${recordCount}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="到达" style="background-color:red;color:#fff;">

</center>




</body>
<!-- <script>

 function del() {
	 var delMsg = "您真的确定要删除吗？";
	 if (confirm(delMsg)){
		 return true;
		 
	
	
	 }else{
	 return false;
	 }
	
	}




    
</script> -->

</html>