<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%> <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>登陆窗口</title>  
<style type="text/css">
			.m-t{
				background-image:url(img/bei.jpg);
				width:600px;
				height: 350px;
				border: 3px solid #0461BE;
			}
			
			.zheng{
				margin-left: 200px;
				margin-top: 30px;
			}
			.logo-name{
				text-align: center;
				color: white;
			}
		</style>
</head>  

<body class="gray-bg">

    <div class="middle-box"  style="width:100%;height:900px;">
        <div style="margin:0 auto;">
            
           
            <form style="margin:0 auto;" class="m-t"  action="LoginServlet" method="post">
            	<div class="logo-name">

                <h1 >员工管理系统</h1>
                <h3>员工登录窗口</h3>
              </div>
              <div class="zheng">
                <div class="form-group">
                    <input type="text" name="userName" class="" placeholder="用户名" required="" style=" width:200px; height:20px;">
                </div>
                <div class="form-group">
                    <input type="password" name="userPwd" class="" placeholder="密码" required="" style=" width:200px; height:20px;margin-top:20px;">
                </div>
                <button type="submit" class="btn "  style="margin-top:20px; width:100px; height:25px;">登 录</button>


                <p class="text-center"><a href="register.jsp" style=" text-decoration:none;">注册一个新账号</a>
                </p>
</div>
            </form>
        </div>
    </div>

    
<script type="text/javascript">  
function tijiao(form){
	if(form.userName.value==""){
		alert("用户名不能为空");
		form.userName.focus();
		return false;
	}
	if(form.userPwd.value==""){
		alert("用户名不能为空");
		form.userPwd.focus();
		return false;
	}
	
}

</script>  
</html>  