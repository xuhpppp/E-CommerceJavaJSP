<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EShop</title>
	<link rel="stylesheet" href="./css/main/style.css">
	<link rel="stylesheet" href="./css/myaccount/title.css">
	<link rel="stylesheet" href="./css/myaccount/avatar.css">
	<link rel="stylesheet" href="./css/myaccount/option.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<link rel="stylesheet" href="./fontawesome-free-6.1.1-web/css/all.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="./scroll.jsp"></jsp:include>

	<jsp:include page="./header.jsp"></jsp:include>
	
	<div class="title">Personal Information</div>
	
	<form action="changeavatar" method="post" class="avatar" enctype="multipart/form-data">
		<img alt="" src="${sessionScope.user.getImgPic() }" class="avatar-img">
		
		<input type="file" name="file" class="avatar-input">
		
		<input type="submit" value="CHANGE" class="avatar-button">
		
		<div class="avatar-warn">${changeAvatarCondition }</div>
	</form>
	
	<div class="option">
		<a class="option-link" href="./changepassword">
			<span class="option-link-text">Change password</span>
			
			<i class="fa-solid fa-key option-link-icon"></i>
		</a>
		
		<a class="option-link" href="#">
			<span class="option-link-text">Your cart</span>
			
			<i class="fa-solid fa-cart-shopping option-link-icon"></i>
		</a>
		
		<a class="option-link" href="#">
			<span class="option-link-text">Purchase history</span>
			
			<i class="fa-solid fa-cash-register option-link-icon"></i>
		</a>
		
		<a class="option-link" href="#">
			<span class="option-link-text">Shop management</span>
			
			<i class="fa-solid fa-shop option-link-icon"></i>
		</a>
	</div>
</body>

<script type="text/javascript" src="./js/main.js"></script>

</html>