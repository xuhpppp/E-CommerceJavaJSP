<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EShop</title>
	<link rel="stylesheet" href="./css/main/style.css">
	<link rel="stylesheet" href="./css/changepassword/title.css">
	<link rel="stylesheet" href="./css/changepassword/form.css">
	<link rel="stylesheet" href="./css/changepassword/warn.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<link rel="stylesheet" href="./fontawesome-free-6.1.1-web/css/all.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="./scroll.jsp"></jsp:include>

	<jsp:include page="./header.jsp"></jsp:include>
	
	<div class="title">CHANGE YOUR PASSWORD</div>
	
	<form action="" method="post" class="form">
		<div class="form-text">Current password</div>
		
		<input class="form-input" name="current-password" type="password" required="required">
		
		<div class="form-text">New password</div>
		
		<input class="form-input" name="new-password" type="password" required="required">
		
		<div class="form-text">Re-enter new password</div>
		
		<input class="form-input" name="re-enter-new-password" type="password" required="required">
		
		<input class="form-btn" type="submit" value="CHANGE">
	</form>
	
	<div class="warn">${changeCondition }</div>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="./js/main.js"></script>

<style>
	.footer {
		margin-top: 41%;
	}
</style>

</html>