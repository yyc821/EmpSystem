<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加员工</title>
<style>
.btn1{background-color:#009688;color:#fff;}
</style>
</head>
<body>
<center>
<form action="./AddServlet" method="post" onSubmit="return add(this)" style="line-height:40px;">
	员工编号:<input type="text" name="empno"/><br>
	员工姓名:<input type="text" name="ename"/><br>
	员工工作:<input type="text" name="job"/><br>
	雇佣日期:<input type="date" name="hiredate"/><br>
	员工工资:<input type="text" name="sal"/><br>
	员工奖金:<input type="text" name="comm"/><br>
	领导编号：<input type="text" name="mgr"/><br>
	部门编号:<input type="text" name="deptno"/><br>
	<input type="submit" value="立即添加" class="btn1" />
</form>
<br>
<a href="./main.jsp"><button class="btn1" >取消添加</button></a>
</center>
<script type="text/javascript">
function add(form){
	if(form.empno.value==""){
		alert("员工编号不能为空");
		form.empno.focus();
		return false;
	}
	if(form.ename.value==""){
		alert("员工姓名不能为空");
		form.ename.focus();
		return false;
	}
	if(form.job.value==""){
		alert("工作不能为空");
		form.job.focus();
		return false;
	}
	if(form.hiredate.value==""){
		alert("员工日期不能为空");
		form.hiredate.focus();
		return false;
	}
	if(form.sal.value==""){
		alert("员工工资不能为空");
		form.sal.focus();
		return false;
	}
	if(form.sal.value<0){
		alert("员工工资不能为负值");
		form.sal.focus();
		return false;
	}
	
	if(form.comm.value==""){
		alert("员工奖金不能为空");
		form.comm.focus();
		return false;
	}
	if(form.comm.value<0){
		alert("员工奖金不能为负值");
		form.comm.focus();
		return false;
	}
	if(form.mgr.value==""){
		alert("经理编号不能为空");
		form.mgr.focus();
		return false;
	}
	if(form.deptno.value==""){
		alert("部门编号不能为空");
		form.deptno.focus();
		return false;
	}
	
}
</script>

</body>
</html>