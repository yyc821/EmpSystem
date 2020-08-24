<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<form action="./UpdateServlet" method="post" onSubmit="return update(this)" style="line-height:40px;">

	员工编号:<input type="text" name="empno"  value="${emp.empno}"/><br>
	员工姓名:<input type="text" name="ename"  value="${emp.ename}" /><br>
	员工工作:<input type="text" name="job"  value="${emp.job}" /><br>
	雇佣日期:<input type="date" name="hiredate" value="${emp.hiredate}" /><br>
	员工工资:<input type="text" name="sal" value="${emp.sal}" /><br>
	员工奖金:<input type="text" name="comm" value="${emp.comm}" /><br>
	领导编号：<input type="text" name="mgr" value="${emp.mgr}" /><br>
	部门编号:<input type="text" name="deptno" value="${emp.deptno}"/><br>
	<input type="submit" onclick="return gengxin()" value="立即更改" class="btn1" />
</form>
<br>
<a href="./MainServlet"><button class="btn1" >取消更改</button></a>
</center>

</body>
<script>

function update(form){
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
		alert("领导编号不能为空");
		form.mgr.focus();
		return false;
	}
	if(form.deptno.value==""){
		alert("部门编号不能为空");
		form.deptno.focus();
		return false;
	}
	
}
function gengxin(){
	alert("更新成功");
}
</script>
</html>