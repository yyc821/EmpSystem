<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title> - 注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
<style type="text/css">
			.m-t{
				background-image: url(img/0031200027.jpg);
				width:600px;
				height: 350px;
				border: 3px solid #0599F9;
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
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>


<body class="gray-bg">

    <div class="middle-box ">
        <div>
           
            <form style="margin:0 auto;" class="m-t" role="form" action="RegisterServlet">
            	 <div class="logo-name">

                <h1 >员工管理系统</h1>
                   <h3>欢迎注册 E+</h3>
            </div>
            
            
            <div class="zheng">
                <div class="form-group">
                    <input type="text" name="userName" id="userName" class="" placeholder="请输入用户名" required="" style=" width:200px; height:20px;margin-top:20px;">
                </div>
                <div class="form-group">
                    <input type="password" name="userPwd" id="userPwd" class="" placeholder="请输入密码" required="" style=" width:200px; height:20px;margin-top:20px;">
                </div>
               <div><span id="error"></span></div>
                <div class="form-group text-left">
                    <div class="checkbox i-checks"  style="	margin-top: 20px;">
                        
                            <input type="checkbox"><i></i> 我同意注册协议
                    </div>
                </div>
                <button type="submit" class="btn " style="margin-top:20px; width:100px; height:25px;">注 册</button>

                <p class=" text-center"><small>已经有账户了？</small><a href="login.jsp" style=" text-decoration:none;">点此登录</a>
                </p>
               </div>
            </form>
        </div>
    </div>
    

    
    <script>
    function checkForm(){
		var userName=document.getElementById("userName").value;
		var userName=document.getElementById("userPwd").value;
		if(userName==""||userName==""){
			document.getElementById("error").innerHTML="信息填写不完整！";
			return false;
		} 
		return true;
	}
	
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    
    

</body>

</html>
