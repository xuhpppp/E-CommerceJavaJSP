<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="./css/main/header.css">
</head>
<body>
	<div class="header">
		<div class="topbar">
			<div class="topbar-container">
				<div class="topbar-container-left">
					<div class="topbar-container-left-item">
						<i class="fa-solid fa-phone topbar-container-icon"></i>
						+060 (800) 801-582
					</div>
					
					<div class="topbar-container-left-item">
						<i class="fa-solid fa-envelope topbar-container-icon"></i>
						support@shophub.com
					</div>
				</div>
				
				<div class="topbar-container-right">
					<div class="topbar-container-right-item">
						<i class="fa-solid fa-location-dot topbar-container-icon"></i>
						<a class="topbar-container-right-item-link" target="blank" href="https://www.google.com/maps/place/Oxford+St,+London,+V%C6%B0%C6%A1ng+Qu%E1%BB%91c+Anh/@51.5152576,-0.1442282,17z/data=!3m1!4b1!4m5!3m4!1s0x48761ad554c335c1:0xda2164b934c67c1a!8m2!3d51.5152543!4d-0.1420395?hl=vi">Store location</a>
					</div>
					
					<div class="topbar-container-right-item">
						<i class="fa-solid fa-bag-shopping topbar-container-icon"></i>
						<a class="topbar-container-right-item-link" href="#">Daily deal</a>
					</div>
					
					<c:if test="${sessionScope.user == null }">
						<div class="topbar-container-right-item">
							<i class="fa-solid fa-user-large topbar-container-icon"></i>
							<a class="topbar-container-right-item-link" href="./login">My account</a>
						</div>
						
						<div class="topbar-container-right-item">
							<i class="fa-solid fa-power-off topbar-container-icon"></i>
							<a class="topbar-container-right-item-link" href="./login">Login</a>
						</div>
					</c:if>
					
					<c:if test="${sessionScope.user != null }">
						<div class="topbar-container-right-item">
								<i class="fa-solid fa-user-large topbar-container-icon"></i>
								<a class="topbar-container-right-item-link" href="./myaccount"><c:out value="${sessionScope.user.name }" /></a>
							</div>
					
						<div class="topbar-container-right-item">
							<i class="fa-solid fa-power-off topbar-container-icon"></i>
							<a class="topbar-container-right-item-link" href="./logout">Logout</a>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		
		<div class="midbar">
			<div class="midbar-left">
				<a class="midbar-left-gobackhome" href="./home">
					<img alt="logo" src="./images/mainImages/logo.png" class="midbar-left-gobackhome-img">
				</a>
			</div>
			
			<div class="midbar-middle">
				<form action="" class="midbar-middle-form">
					<input type="text" class="midbar-middle-form-input" name="" placeholder="Type to search...">
					
					<button type="submit" class="midbar-middle-form-button">
						<i class="fa-solid fa-magnifying-glass midbar-middle-form-button-icon"></i>
					</button>
				</form>
			</div>
			
			<div class="midbar-right">
				<a class="midbar-right-click" href="#">
					<i class="fa-solid fa-cart-shopping midbar-right-click-icon"></i>
				</a>
				<!-- Handle by backend -->
				<div class="midbar-right-click-number">3</div>
			</div>
		</div>
		
		<div class="postbar">
			<div class="postbar-title">
				<i class="fa-solid fa-bars postbar-title-icon"></i>
				
				<p class="postbar-title-text">CATEGORIES</p>
			</div>
			
			<div class="postbar-options">
				<a class="postbar-options-click" href="./home">Home</a>
				
				<a class="postbar-options-click" href="">Product</a>
				
				<div class="postbar-options-scroll">
					<div class="postbar-options-click">
						<p class="postbar-options-click-text">Shop</p>
					
						<i class="fa-solid fa-angle-down postbar-options-click-icon"></i>
					</div>
					
					<div class="postbar-options-scroll-list">
						<a class="postbar-options-scroll-list-link" href="#">Cart</a>
						
						<a class="postbar-options-scroll-list-link" href="#">Checkout</a>
					</div>
				</div>
				
				<a class="postbar-options-click" href="">Blog</a>
				
				<a class="postbar-options-click" href="">Contact Us</a>
			</div>
		</div>
	</div>
</body>
</html>