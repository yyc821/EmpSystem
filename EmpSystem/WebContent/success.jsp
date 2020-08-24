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
<form action="./ByEmpNameServlet"  onSubmit="return checkFind(this)" method="post">
<input type="text" name="ename" id="ename"   />
<input type="submit" value="根据员工名称查询"   style="background-color:#009688;color:#FFF;"/>
</form>
<span id="msg" style="color:red;">${msg}</span>

</div> 

<div><a href="./addEmp.jsp" style=""><button class="btn1">添加员工</button></a></div>
 <a href="./login.jsp" ><button class="btn btn-primary btn-sm">退出账号</button></a>
<a href="main.jsp"><button class="btn btn-primary btn-sm">返回主页</button></a>
</div>
<table id="backViewTable" class="table table-bordered" style="margin:30px auto;">
	<tr><th>员工编号</th><th>员工姓名</th><th>员工工作</th><th>员工工资</th><th>员工奖金</th><th>雇佣时间</th><th>领导编号</th><th>部门编号</th><th style="width:180px;">操作</th></tr>
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
			<a href="./DeleteServlet?empno=${emp.empno}" style="color:#000;"><button onclick="return del()" style="background-color:red;color:#fff;">删除</button></a>
			</td>
		</tr>
		
	</c:forEach>
</table>
<c:if test="${pageNos>1 }">
<a href="MainServlet?pageNos=1" >首页</a>
<a href="MainServlet?pageNos=${pageNos-1 }">上一页</a>
</c:if>
<c:if test="${pageNos <recordCount }">
<a href="MainServlet?pageNos=${pageNos+1 }">下一页</a>
<a href="MainServlet?pageNos=${recordCount }">末页</a>
</c:if>
<form action="./MainServlet">
<h4 align="center">共${recordCount}页  
<input type="text" value="${pageNos}" name="pageNos" size="1">页
<input type="submit" value="到达" style="background-color:red;color:#fff;">

</center>




</body>
<script>

 function del() {
	 var delMsg = "您真的确定要删除吗？";
	 if (confirm(delMsg)){
		 return true;
		 
	
	
	 }else{
	 return false;
	 }
	
	}




    
</script>

</html>