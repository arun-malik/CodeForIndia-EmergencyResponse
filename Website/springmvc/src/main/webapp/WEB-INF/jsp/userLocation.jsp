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

<!-- Google Maps Cluster ==================================================
================================================== -->

<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script type="text/javascript" src="js/Fluster2.packed.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		
			$(this).find('#travellerinfo').hide();
		
	});
</script>
<script type="text/javascript">
	// OnLoad function ...
	function initialize() {

		//    var myVar = document.getElementsByName("Locations").value;
		//    var test = myVar[0];
		//    document.write(test.value);
		// Create a new map with some default settings
		var myLatlng = new google.maps.LatLng(21.0000, 78.0000);
		var myOptions = {
			zoom : 4,
			center : myLatlng,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		}
		var map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);

		// Initialize Fluster and give it a existing map
		var fluster = new Fluster2(map);

		var pos = [ [ -33.890542, 151.274856 ], [ -33.923036, 151.259052 ],
				[ -34.028249, 151.157507 ],
				[ -33.80010128657071, 151.28747820854187 ],
				[ -33.890542, 151.274856 ], [ -33.923036, 151.259052 ],
				[ -34.028249, 151.157507 ],
				[ -33.80010128657071, 151.28747820854187 ], ];

		for (var i = 0; i < pos.length; i++) {
			// Create a new marker. Don't add it to the map!
			var marker = new google.maps.Marker({
				position : new google.maps.LatLng(pos[i][0], pos[i][1]),
				title : 'Marker ' + i
			});
			// Add the marker to the Fluster
			fluster.addMarker(marker);
		}

		// Set styles
		// These are the same styles as default, assignment is only for demonstration ...
		fluster.styles = {
			// This style will be used for clusters with more than 0 markers
			0 : {
				image : 'http://gmaps-utility-library.googlecode.com/svn/trunk/markerclusterer/1.0/images/m1.png',
				textColor : '#FFFFFF',
				width : 53,
				height : 52
			},
			// This style will be used for clusters with more than 10 markers
			10 : {
				image : 'http://gmaps-utility-library.googlecode.com/svn/trunk/markerclusterer/1.0/images/m2.png',
				textColor : '#FFFFFF',
				width : 56,
				height : 55
			},
			20 : {
				image : 'http://gmaps-utility-library.googlecode.com/svn/trunk/markerclusterer/1.0/images/m3.png',
				textColor : '#FFFFFF',
				width : 66,
				height : 65
			}
		};

		// Initialize Fluster
		// This will set event handlers on the map and calculate clusters the first time.
		fluster.initialize();

	}
</script>

</head>
<body onload="initialize();">

	<!-- Home - Content Part ==================================================
================================================== -->
	<div id="header">
		<div class="container header">
			<!-- Header | Logo, Menu
		================================================== -->
			<header>
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
		<br />
		<!--    <div id="contactForm">-->

		<!--<select name="Locations">-->
		<!--<option value="28.6100">Delhi</option>-->
		<!--<option value="18.9600,72.8200">Maharashtra</option>-->
		<!--<option value="8.5074,76.9730" selected>Kerala</option>-->
		<!--</select>-->
		<!--<button id="theButton" onclick="initialize()" >Locate</button>-->
		<!--</div>-->
		<div class="blankSeparator"></div>
		<div id="map_canvas" style="width: 600px; height: 400px"></div>
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
