
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
			<a class="navbar-brand" style="font-size: 30px ;font-family: MONOSPACE, SANS-SERIF;" href="${contextPath}/">Attendance
				Marking System</a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="${contextPath}/">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="#">About</a></li>
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


	<h1 class="text-center" style="color:red; margin-top:250px">Oops!,Your application is still Pending</h1>

	<div class="footer-container" id="footer">
      <div class="copyright">
        &copy; Copyright 2021. All Rights Reserved by
      </div>
      <div class="credits">
   
         <a href="${contextPath}/"><strong>Attendance
							Tracker</strong></a>
      </div>
    </div>










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
