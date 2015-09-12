<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Brian Suther">
    <link rel="icon" href="${pageContext.request.contextPath}/img/OneStopFitnessNavLogo.png">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
    
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	<title>One Stop Fitness</title>
  </head>
  <body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
			    <a class="navbar-brand" rel="home" href="${pageContext.request.contextPath}/app/summary/view">
        			<img style="max-width:35px; vertical-align: middle; max-height:35px; margin-top: -7px;" src="${pageContext.request.contextPath}/img/OneStopFitnessNavLogo.png">
    			</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${pageContext.request.contextPath}/app/summary/view"><span class="glyphicon glyphicon-home"></span>&nbsp;Home</a></li>
					<li><a href="#about"><span class="glyphicon glyphicon-book"></span>&nbsp;Diary</a></li>
					<li><a href="#contact"><span class="glyphicon glyphicon-th-list"></span>&nbsp;Exercises</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right" style="padding-right:10px;">
					<li><a href="${pageContext.request.contextPath}/app/calendar/view"><span class="glyphicon glyphicon-calendar"></span></a></li>
					<li class="dropdown">
          			<a href="#" class="dropdown-toggle navbar-right" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-cog"></span><span class="caret"></span></a>
          				<ul class="dropdown-menu" role="menu">
				            <li><a href="#">Calorie Maintenance</a></li>
				            <li><a href="#">BMI Calculator</a></li>
				            <li><a href="#">Body Fat</a></li>
				            <li><a href="${pageContext.request.contextPath}/app/calculator/jimwendler">Jim Wendler 5/3/1</a></li>
          				</ul>
        			</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

