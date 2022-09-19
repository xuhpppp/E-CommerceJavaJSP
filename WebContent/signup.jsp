<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sign Up</title>
	<link rel="stylesheet" href="./css/main/style.css">
	<link rel="stylesheet" href="./css/signup/title.css">
	<link rel="stylesheet" href="./css/signup/form.css">
	<link rel="stylesheet" href="./css/signup/link.css">
	<link rel="stylesheet" href="./css/signup/warn.css">
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
		<div class="title-text">REGISTER</div>
		
		<div class="title-description">Please register in order to checkout more quickly</div>
	</div>
	
	<form action="signup" method="post" class="form">
		<div class="form-text">Your Name</div>
		
		<input class="form-input" name="name" type="text" value="${name }" required="required">
	
		<div class="form-text">Your Email</div>
		
		<input class="form-input" name="email" type="email" value="${email }" required="required">
		
		<div class="form-text">Your Password</div>
		
		<input class="form-input" name="password" type="password" value="${password }" required="required">
		
		<div class="form-text">Confirm Your Password</div>
		
		<input class="form-input" name="rePassword" type="password" value="${rePassword }" required="required">
		
		<div class="form-remember">
			<input class="form-remember-checkbox" name="remember" type="checkbox">
			
			<label class="form-remember-text">Receive News From Our Website</label>
		</div>
		
		<input class="form-btn" type="submit" value="SIGN UP">
	</form>
	
	<div class="link">
		<a class="link-text" href="./login.jsp">Already have an account?</a>
	</div>
	
	<div class="warn">${signupCondition }</div>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>

<style>
	.footer {
		margin-top: 55%;
	}
</style>

</html>