<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EShop</title>
	<link rel="stylesheet" href="./css/main/style.css">
	<link rel="stylesheet" href="./css/index/category.css">
	<link rel="stylesheet" href="./css/index/collection.css">
	<link rel="stylesheet" href="./css/index/trending.css">
	<link rel="stylesheet" href="./css/index/adseller.css">
	<link rel="stylesheet" href="./css/index/blog.css">
	<link rel="stylesheet" href="./css/index/service.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
	<link rel="stylesheet" href="./fontawesome-free-6.1.1-web/css/all.min.css">
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
</head>
<body>
	<jsp:include page="./scroll.jsp"></jsp:include>

	<jsp:include page="./header.jsp"></jsp:include>

	<div class="category">
		<div class="category-option">
			<a class="category-option-click" href="#">New Arrivals</a>
			
			<a class="category-option-click" href="#">Best Selling</a>
			
			<a class="category-option-click" href="#">Top 100 Offer</a>
			
			<a class="category-option-click" href="#">Man's Product</a>
			
			<a class="category-option-click" href="#">Ladies</a>
			
			<a class="category-option-click" href="#">Accessories</a>
			
			<a class="category-option-click" href="#">Kid's</a>
			
			<a class="category-option-click" href="#">Sport Shoes</a>
			
			<a class="category-option-click" href="#">Suit</a>
			
			<a class="category-option-click" href="#">Glasses</a>
		</div>
		
		<div class="category-banner">
			<div class="category-banner-content">
				<p class="category-banner-content-sale">UP TO 50% OFF</p>
				
				<p class="category-banner-content-title">Shirt For Man</p>
				
				<p class="category-banner-content-description">Maboriosam in a nesciung eget magnaedapibus disting tloctio in the find it pereriodiy maboriosm.</p>
				
				<a class="category-banner-content-button" href="#">SHOP NOW!</a>
			</div>
			
			<img alt="index_img" src="./images/mainImages/index_category_png.png" class="category-banner-img">
		</div>
	</div>
	
	<div class="collection">
		<div class="collection-banner">
			<img alt="" src="./images/mainImages/mini-banner1.jpg" class="collection-banner-img">
			
			<div class="collection-banner-text">
				<p class="collection-banner-text-type">Man's Collections</p>
				
				<p class="collection-banner-text-title">Summer Travel Collection</p>
				
				<a class="collection-banner-text-click" href="#">DISCOVER NOW</a>
			</div>
		</div>
		
		<div class="collection-banner">
			<img alt="" src="./images/mainImages/mini-banner2.jpg" class="collection-banner-img">
			
			<div class="collection-banner-text">
				<p class="collection-banner-text-type">Bag Collections</p>
				
				<p class="collection-banner-text-title">Awesome Bag 2022</p>
				
				<a class="collection-banner-text-click" href="#">DISCOVER NOW</a>
			</div>
		</div>
		
		<div class="collection-banner">
			<img alt="" src="./images/mainImages/mini-banner3.jpg" class="collection-banner-img">
			
			<div class="collection-banner-text">
				<p class="collection-banner-text-type">Flash Sale</p>
				
				<p class="collection-banner-text-title">Mid Season Up To 40% Off</p>
				
				<a class="collection-banner-text-click" href="#">DISCOVER NOW</a>
			</div>
		</div>
	</div>
	
	<div class="trending">
		<div class="trending-title">
			Trending Item
		</div>
		
		<div class="trending-list">
			<c:forEach var = "i" begin = "0" end = "${trendingList.size()-1 }" >
				<div class="trending-list-item">
					<a class="trending-list-item-container" href="#">
						<img alt="" src="${trendingList.get(i).getImgPath() }" class="trending-list-item-container-img">
					</a>
				
					<a class="trending-list-item-name" href="#"><c:out value="${trendingList.get(i).getName() }" /></a>
				
					<div class="trending-list-item-price">
						<p class="trending-list-item-price-cost ${trendingList.get(i).getSalePercentage() == 0 ? 'not-appear' : '' }"><c:out value="${trendingList.get(i).getCost() }$" /></p>
					
						<p class="trending-list-item-price-sale"><c:out value="${trendingList.get(i).getCost() * (100 - trendingList.get(i).getSalePercentage())/100 }$" /></p>
					</div>
				
					<a class="trending-list-item-wishlist" href="#">Add to cart</a>
				
					<p class="trending-list-item-salelabel ${trendingList.get(i).getSalePercentage() == 0 ? 'not-appear' : '' }">SALE</p>
				
					<p class="trending-list-item-hotlabel not-appear">HOT</p>
				
					<p class="trending-list-item-newlabel not-appear">NEW</p>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<div class="adseller">
		<p class="adseller-question">Wanna Sell Your Products?</p>
		
		<div class="adseller-title">Let's Become One Of Our Sellers</div>
		
		<p class="adseller-description">Please, purchase full version of the template to get all pages, features and commercial license.</p>
		
		<a class="adseller-button" href="#">Register Now</a>
	</div>
	
	<div class="blog">
		<div class="blog-title">From Our Blog</div>
		
		<div class="blog-list">
			<div class="blog-list-item">
				<img alt="" src="./images/mainImages/blog1.jpg" class="blog-list-item-img">
				
				<div class="blog-list-item-img-text">
					<p class="blog-list-item-text-time">22 July , 2020. Monday</p>
				
					<a class="blog-list-item-text-title" href="#">Sed adipiscing ornare.</a>
				</div>
			</div>
			
			<div class="blog-list-item">
				<img alt="" src="./images/mainImages/blog2.jpg" class="blog-list-item-img">
				
				<div class="blog-list-item-img-text">
					<p class="blog-list-item-text-time">22 July , 2020. Monday</p>
				
					<a class="blog-list-item-text-title" href="#">Man’s Fashion Winter Sale</a>
				</div>
			</div>
			
			<div class="blog-list-item">
				<img alt="" src="./images/mainImages/blog3.jpg" class="blog-list-item-img">
				
				<div class="blog-list-item-img-text">
					<p class="blog-list-item-text-time">22 July , 2020. Monday</p>
				
					<a class="blog-list-item-text-title" href="#">Women Fashion Festive</a>
				</div>
			</div>
		</div>
	</div>
	
	<div class="service">
		<div class="service-item">
			<i class="fa-solid fa-rocket service-item-icon"></i>
			
			<div class="service-item-text">
				<p class="service-item-text-title">FREE SHIPING</p>
			
				<p class="service-item-text-detail">Orders over $100</p>
			</div>
		</div>
		
		<div class="service-item">
			<i class="fa-solid fa-arrows-spin service-item-icon"></i>
			
			<div class="service-item-text">
				<p class="service-item-text-title">FREE RETURN</p>
			
				<p class="service-item-text-detail">Within 30 days returns</p>
			</div>
		</div>
		
		<div class="service-item">
			<i class="fa-solid fa-lock service-item-icon"></i>
			
			<div class="service-item-text">
				<p class="service-item-text-title">SECURE PAYMENT</p>
			
				<p class="service-item-text-detail">100% secure payment</p>
			</div>
		</div>
		
		<div class="service-item">
			<i class="fa-solid fa-tag service-item-icon"></i>
			
			<div class="service-item-text">
				<p class="service-item-text-title">BEST PRICE</p>
			
				<p class="service-item-text-detail">Guaranteed price</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="./footer.jsp"></jsp:include>
</body>

<script type="text/javascript" src="./js/main.js"></script>

</html>