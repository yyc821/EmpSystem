<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<title>员工管理系统</title>
<style>
.btn1{background-color:#009688;color:#fff;}
.nav{margin-left:-70px;width:800px;display:flex;flex-direction:row;justify-content: space-around;align-items:stretch;}
.btn-sm{background-color:blue;color:#fff;}
</style>
</head>
<body>
<center><h1 style="color:#009688">员工管理系统</h1>
<br>
<div class="nav">
<div>


</div> 
<div>
<a href="./MainServlet" style=""><button class="btn1" >返回主页面</button></a></div>
<div><a href="./addEmp.jsp" style=""><button class="btn1">添加员工</button></a></div>
<!--  <button class="btn btn-primary btn-sm" onclick="tablesToExcel(['backViewTable'], ['ProductDay1'], 'TestBook.xls', 'Excel')">导出 Excel表格</button> -->
</div>
<table id="backViewTable" class="table table-hover table-sm table2excel" style="margin:30px auto;">
	<tr><th>员工编号</th><th>员工姓名</th><th>员工工作</th><th>员工工资</th><th>员工奖金</th><th>工作时间</th><th>领导编号</th><th>部门编号</th><th style="width:180px;">操作</th></tr>
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
			
			<td style="text-align:center;">
			<a href="./QueryServlet?empno=${emp.empno}" style="color:#000;"><button  style="background-color:#009688;color:#fff;">更改</button></a>
			<a href="./DeleteServlet?empno=${emp.empno}" style="color:#000;"><button style="background-color:red;color:#fff;">删除</button></a>
			</td>
		</tr>
		
	</c:forEach>
</table>

</center>
<!--分页参考网址 https://blog.csdn.net/weixin_41655541/article/details/83745321 -->
<!--参考网址 https://www.jb51.net/article/87274.htm -->
<!--ajax验证用户名是否存在  https://blog.csdn.net/jsh458046505/article/details/78712850 -->
<script type="text/javascript">
   
</script>
</body>
</html>