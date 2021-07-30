<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous" />
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<title>Attendance Marking</title>
</head>


<body background="${contextPath}/resources/img/intro-bg.jpg">
	<nav class="navbar home-navbar navbar-expand-sm ">
		<div class="container">
			<a class="navbar-brand" style="font-size: 33px ;font-family: monospace; color:#4c44a9;fot-weight:bolder" href="${contextPath}/"><img src="/resources/img/logo.png" style="height:30px;width:30px">Attendance
				Tracker</a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="${contextPath}/">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="${contextPath}/about">About</a></li>
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Register</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/admin_registration" class="dropdown-item" style="font-size: 18px">Admin
							Registration</a> <a href="${contextPath}/registration"
							class="dropdown-item" style="font-size: 18px">User Registration</a>

					</div></li>
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Login</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/admin_login" class="dropdown-item" style="font-size: 18px">Admin
							Login</a> <a href="${contextPath}/login" class="dropdown-item" style="font-size: 18px">User
							Login</a>

					</div></li>

			</ul>
		</div>
	</nav>
	
	<section id="hero" class="clearfix">
    <div class="container  h-100" style="margin-top:200px">
      <div class="row justify-content-center align-self-center" data-aos="fade-up">
        <div class="col-lg-6 intro-img order-lg-last order-first" data-aos="zoom-out" data-aos-delay="200">
        <img src="${contextPath}/resources/img/userlogin.png" 
		alt="Attendance Marking Image" class="img-fluid">
        </div>

        <div class="col-lg-6 intro-img order-lg-last order-first" style="margin-right:0; padding-right:0;margin-bottom:80px" data-aos="zoom-out" data-aos-delay="200">
<form method="POST" action="${contextPath}/login" class="form-signin">
			<h1 class="form-heading">User login</h1>

			<div class="form-group ${error != null ? 'has-error' : ''}">
				<span>${message}</span> <input name="username" type="text"
					class="form-control" placeholder="Username" autofocus="true" />
				<h5>
					<a href="${contextPath}/forgotuserusername">forgot username?</a>
				</h5>
				<input name="password" type="password" class="form-control"
					placeholder="Password" /> <span>${error}</span> <input
					type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<h5 >
					<a href="${contextPath}/resetuserpassword">forgot password?</a>
				</h5>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Log
					In</button>
				<h4 class="text-center mt-3">
					Don't have one? <a href="${contextPath}/registration">Signup</a>
				</h4>

			</div>
		</form>
        </div>
      </div>

    </div>
    </section>

	

	<div class="footer-container" id="footer">
      <div class="copyright">
        &copy; Copyright 2021. All Rights Reserved by
      </div>
      <div class="credits">
   
         <a href="${contextPath}/"><strong>Attendance
							Tracker</strong></a>
      </div>
    </div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>




</body>
</html>
