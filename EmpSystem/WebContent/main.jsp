<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 主界面</title>
 
<style type="text/css">
			
			.btn{
				
				display: flex;
				 margin-top:100px;
			}
			h1{
			
				color: white;
				text-align: center;
			}
			.btne{
				margin-left:30px;
				
			}
			.btn1{
				 width:80px;
				height: 50px;
			}
 </style>
</head>
<body>
<center>
	<div id="bei" style="width: 600px; height: 300px; background-image:url(img/bei.jpg);">
		
		
		<div><h1>欢迎来到员工管理系统</h1></div>
		
		<div class="btn">
		
		<div class="btne"><a href="./ListEmpServlet" style=""><button class="btn1">员工信息</button></a></div>
		<div class="btne"><a href="./MainServlet" style=""><button class="btn1" >员工管理</button></a></div>
		<div class="btne"><a href="./addEmp.jsp" style=""><button class="btn1">添加员工</button></a></div>
		<div class="btne"><a href="./ListUserServlet" style=""><button class="btn1">用户信息</button></a></div>
		<div class="btne"><a href="./login.jsp" style=""><button class="btn1">退出登录</button></a></div>
	</div>
	</div>
	</center>
</body>
</html>