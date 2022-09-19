<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<link rel="stylesheet" href="./css/main/style.css">
	<link rel="stylesheet" href="./css/login/title.css">
	<link rel="stylesheet" href="./css/login/form.css">
	<link rel="stylesheet" href="./css/login/link.css">
	<link rel="stylesheet" href="./css/login/warn.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<link rel="stylesheet" href="./fontawesome-free-6.1.1-web/css/all.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="./scroll.jsp"></jsp:include>

	<jsp:include page="./header.jsp"></jsp:include>
	
	<div class="title">
		<div class="title-text">LOGIN</div>
		
		<div class="title-description">Please register in order to checkout more quickly</div>
	</div>
	
	<form action="login" method="post" class="form">
		<div class="form-text">Your Email</div>
		
		<input class="form-input" name="email" type="email">
		
		<div class="form-text">Your Password</div>
		
		<input class="form-input" name="password" type="password">
		
		<div class="form-remember">
			<input class="form-remember-checkbox" name="remember" type="checkbox">
			
			<label class="form-remember-text">Remember me</label>
		</div>
		
		<input class="form-btn" type="submit" value="LOGIN">
	</form>
	
	<div class="link">
		<a class="link-text" href="#">Forgot your password?</a>
		
		<a class="link-text" href="./signup">Sign up an account</a>
	</div>
	
	<div class="warn">${loginCondition }</div>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>

<style>
	.footer {
		margin-top: 41%;
	}
</style>

</html>