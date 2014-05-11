<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>

<!-- Basic Page Needs ================================================== 
================================================== -->

<meta charset="utf-8">
<title>Emergency Response Website</title>
<meta name="description" content="Place to put your description text">
<meta name="author" content="">
<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

<!-- Mobile Specific Metas ================================================== 
================================================== -->

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">

<!-- CSS ==================================================
================================================== -->

<link rel="stylesheet" href="css/base.css">
<link rel="stylesheet" href="css/skeleton.css">
<link rel="stylesheet" href="css/screen.css">
<link rel="stylesheet" href="css/prettyPhoto.css" type="text/css"
	media="screen" />

<!-- Favicons ==================================================
================================================== -->

<link rel="shortcut icon" href="images/favicon.png">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="images/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="images/apple-touch-icon-114x114.png">

<!-- Google Fonts ==================================================
================================================== -->

<link
	href='http://fonts.googleapis.com/css?family=PT+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var role = $("#role").val();
		console.log(role);

		if (role != "admin") {
			$(this).find('#notify').hide();
			$(this).find('#location').hide();
		} else {
			$(this).find('#travellerinfo').hide();
		}
	});
</script>
</head>
<body>

	<!-- Home - Content Part ==================================================
================================================== -->
	<div id="header">
		<div class="container header">
			<!-- Header | Logo, Menu
		================================================== -->
			<header>
				<div class="logo">
					<a href="index.html"><img src="images/logo.png" alt="" /></a>
				</div>
				<div class="mainmenu">
					<div id="mainmenu">
						<ul class="sf-menu">
							<li><a href="index.jsp" id="visited"><span class="home"><img
										src="images/home.png" alt="" /></span>Home</a></li>
							<li><a href="travellerInfo.htm" id ="travellerinfo"><span class="home"><img
										src="images/about.png" alt="" /></span>Traveller Info</a></li>
							<li><a href="reportIncident.htm"><span class="home"><img
										src="images/portfolio.png" alt="" /></span>Report Incident</a>
							<li><a href="adminLogin.htm"><span class="home"><img
										src="images/about.png" alt="" /></span>Admin Login</a></li>
							<li><a href="userLocation.htm" id ="location"><span class="home"><img
										src="images/about.png" alt="" /></span>User Location</a></li>
										<li><a href="heatMap.html" id ="notify"><span class="home"><img
										src="images/about.png" alt="" /></span>Heat Map</a></li>
							<li><a href="adminLogin.htm" id ="notify"><span class="home"><img
										src="images/about.png" alt="" /></span>Notify Users</a></li>

						</ul>
					</div>

					
				</div>
			</header>
		</div>
	</div>
	<!-- Home Content Part - Slider ==================================================
================================================== -->
	<div class="flexslider">
		<ul class="slides">
			<li><a href="#"><img src="images/flexslider/3.jpg" alt="" /></a>
			</li>
			<li><img src="images/flexslider/6.jpg" alt="" /></li>
			<li><a href="#"><img src="images/flexslider/4.jpg" alt="" /></a>
				<p class="flex-caption">Welcome to Proximet Site. This is
					example of the Caption Title.</p></li>
		</ul>
	</div>
	<!-- Home Content Part - Box One ==================================================
================================================== -->
	<div class="blankSeparator"></div>
	<div class="container">
		<div class="info">
			<div class="one_third">
				<h2>New Freebie</h2>
				<p>
					Proximet is my latest <span class="red">responsive</span> Site
					Template freebie. Proximet Template is simple and clean template
					with a lot attention to detail. It is suitable for a lot of <span
						class="green">different</span> business and private uses.
				</p>
				<a
					href="http://themeforest.net/item/positivo-responsive-and-fresh-wp-theme/2700306?ref=anariel7"
					title="" class="buttonhome">&rarr; download</a>
			</div>
			<div class="two_third lastcolumn">
				<div class="one_half">
					<h2>Portfolio News</h2>
					<p>
						Proximet is my latest <span class="red">responsive</span> Site
						Template freebie. Proximet Template is simple and clean template
						with a lot attention to detail. It is suitable for a lot of <span
							class="green">different</span> business and private uses.
					</p>
					<a
						href="http://themeforest.net/item/positivo-responsive-and-fresh-wp-theme/2700306?ref=anariel7"
						title="" class="buttonhome">&rarr; download</a>
				</div>
				<div class="one_half lastcolumn">

					<h2>Login</h2>
					<form:form method="post" modelAttribute="user">
						<div id="contactForm">
							<div class="name">
								<label>Username:</label>
								<form:input type="text" path="name" />
							</div>
							<div class="name">
								Password:
								<form:input type="text" path="email" />
							</div>
							<input type="submit" />
						</div>
					</form:form>

					 <input type="hidden" id="role"
						value="${use.role}">

				</div>
			</div>
		</div>
	</div>
	<!-- container ends here -->
	<!-- Home Content Part - Box Two ==================================================
================================================== -->
	<div class="container clients"></div>
	<!-- end container -->


	<!-- Copyright ==================================================
================================================== -->
	<div id="copyright">
		<div class="container">
			<div class="eleven columns alpha">
				<p class="copyright">
					&copy; Copyright 2012. &quot;Proximet&quot; by <a
						href="http://www.anarieldesign.com/" rel="nofollow">Anariel
						Design</a>. All rights reserved.
				</p>
			</div>
			<div class="five columns omega">
				<section class="socials">
					<ul class="socials fr">
						<li><a href="#"><img src="images/socials/twitter.png"
								class="poshytip" title="Twitter" alt="" /></a></li>
						<li><a href="#"><img src="images/socials/facebook.png"
								class="poshytip" title="Facebook" alt="" /></a></li>
						<li><a href="#"><img src="images/socials/google.png"
								class="poshytip" title="Google" alt="" /></a></li>
						<li><a href="#"><img src="images/socials/dribbble.png"
								class="poshytip" title="Dribbble" alt="" /></a></li>
					</ul>
				</section>
			</div>
		</div>
		<!-- container ends here -->
	</div>
	<!-- copyright ends here -->
	<!-- End Document
================================================== -->
	<!-- Scripts ==================================================
================================================== -->

	<script src="js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<!-- Main js files -->
	<script src="js/screen.js" type="text/javascript"></script>
	<!-- Tooltip -->
	<script src="js/poshytip-1.0/src/jquery.poshytip.min.js"
		type="text/javascript"></script>
	<!-- Tabs -->
	<script src="js/tabs.js" type="text/javascript"></script>
	<!-- Tweets -->
	<script src="js/jquery.tweetable.js" type="text/javascript"></script>
	<!-- Include prettyPhoto -->
	<script src="js/jquery.prettyPhoto.js" type="text/javascript"></script>
	<!-- Include Superfish -->
	<script src="js/superfish.js" type="text/javascript"></script>
	<script src="js/hoverIntent.js" type="text/javascript"></script>
	<!-- Flexslider -->
	<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/modernizr.custom.29473.js"></script>

</body>
</html>