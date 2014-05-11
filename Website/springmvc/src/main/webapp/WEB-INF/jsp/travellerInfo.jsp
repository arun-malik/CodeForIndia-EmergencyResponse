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
================================================== -->

<!-- Basic Page Needs ==================================================
================================================== -->

<meta charset="utf-8">
<title>Proximet Responsive Site Template</title>
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
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		var role = $("#role").val();
		console.log(role);

		if (role != "admin") {
			$(this).find('#notify').hide();
			$(this).find('#location').hide();
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
	<!-- Contact Content Part - Contact Form ==================================================
================================================== -->
	<div class="container">
		<div class="blankSeparator"></div>
		<div class="two_third lastcolumn contact1">
			<div id="contactForm">
				<h2>Traveller's Info</h2>
				<div class="sepContainer"></div>
				<form:form method="post" modelAttribute="traveller">
				  	<div class="name">
						<label for="name">Name:</label>
						<p>Please enter your full name</p>
						<form:input type="text" path="name"  />
					</div>
					<div class="name">
						<label for="fathersname">Father's Name:</label>
						<form:input type="text" path="fatherName" />
					</div>
					<div class="name">
						<label for="mothersname">Mother's Name:</label>
						<form:input type="text" path="motherName"
							placeholder="e.g. Mr. John Smith"  />
						${user1.name}
					</div>
					<div class="name">
						<label for="name">Mobile Number:</label>
						<form:input type="number" path="mobileNo"
							placeholder="eg. 9876543678"  />
					</div>
					<div class="name">
						<label for="travellers">No of fellow traveller's:</label>
						<form:input type="number" path="noFellow"  />
					</div>
					<div class="name">
						<label for="name">Emergency Contact</label>
						<form:input type="number" path="emergencyNo"
							placeholder="eg. 9876543678" />
					</div>
					<div id="loader">
						<input type="submit" value="Submit" />
					</div>
				</form:form>
			</div>
			<!-- end contactForm -->
		</div>
	</div>
	<div class="blankSeparator2"></div>
	<!--Footer ==================================================
================================================== -->
	<div id="footer">
		<div class="container footer">
			<div class="one_fourth">
				<h3>Latest Tweets</h3>
				<div id="tweets"></div>
			</div>
			<div class="one_fourth">
				<h3>Blogroll</h3>
				<ul>
					<li class="lines"><a href="#" title="">Development Blog</a></li>
					<li class="lines"><a href="#" class="">New Freebies</a></li>
					<li class="lines"><a href="#" class="">Themeforest Theme</a></li>
					<li class="lines"><a href="#" class=""> Design News</a></li>
					<li class="lines"><a href="#" class="">WordPress Theme</a></li>
				</ul>
			</div>
			<div class="one_fourth">
				<h3>Archive</h3>
				<ul>
					<li class="lines"><a href="#" class=""> August 2012</a></li>
					<li class="lines"><a href="#" class="">July 2012</a></li>
					<li class="lines"><a href="#" class="">Juny 2012</a></li>
					<li class="lines"><a href="#" class=""> May 2012</a></li>
					<li class="lines"><a href="#" class="">April 2012</a></li>
				</ul>
			</div>
			<div class="one_fourth lastcolumn">
				<h3>About</h3>
				<p>Proximet is responsive, simple and clean template with a lot
					attention to detail. Get it now!</p>
				<p>
					Visit <a href="http://anarieldesign.com/" rel="nofollow">Anariel
						Design</a> and find more interesting things.
				</p>
			</div>
		</div>
		<!-- container ends here -->
	</div>
	<!-- footer ends here -->
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

<!-- Scripts ==================================================
================================================== -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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
