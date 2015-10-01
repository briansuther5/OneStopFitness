<nav class="navbar navbar-default navbar-fixed-top">
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
					<li><a href="${pageContext.request.contextPath}/app/summary/view"><i class="fa fa-home fa-lg"></i>&nbsp;Home</a></li>
					<li><a href="#about"><i class="fa fa-book"></i>&nbsp;Workout Log</a></li>
					<li><a href="#contact"><span class="glyphicon glyphicon-th"></span>&nbsp;My Exercises</a></li>
					<li class="dropdown">
          			<a href="#" class="dropdown-toggle navbar-right" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-cogs"></i>&nbsp;Tools<span class="caret"></span></a>
          				<ul class="dropdown-menu" role="menu">
				            <li><a href="#">Calorie Maintenance</a></li>
				            <li><a href="#">BMI Calculator</a></li>
				            <li><a href="#">Body Fat</a></li>
				            <li><a href="${pageContext.request.contextPath}/app/calculator/jimwendler">Jim Wendler 5/3/1</a></li>
          				</ul>
        			</li>
				</ul>
				<ul class="nav navbar-nav navbar-right" style="padding-right:10px;">
					<li><a href="${pageContext.request.contextPath}/app/summary/contact">Contact</a></li>
					<li class="dropdown">
          			<a href="#" class="dropdown-toggle navbar-right" data-toggle="dropdown" role="button" aria-expanded="false">${userProfile.firstName}&nbsp;${userProfile.lastName}<span class="caret"></span></a>
          				<ul class="dropdown-menu" role="menu">
				            <li><a href="${pageContext.request.contextPath}/app/account/profile"><i class="fa fa-user"></i>&nbsp;My Profile</a></li>
				            <li><a href="${pageContext.request.contextPath}/app/account/logout"><i class="fa fa-sign-out"></i>&nbsp;Logout</a></li>
          				</ul>
        			</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>