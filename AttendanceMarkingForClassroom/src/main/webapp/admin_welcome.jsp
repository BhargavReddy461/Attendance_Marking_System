<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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






	<!-- NAVBAR WITH DROPDOWN -->
	<nav class="navbar navbar-expand-sm home-navbar mb-5 mb-5">
		<div class="container">
			<a class="navbar-brand"
				style="font-size: 33px; font-family: monospace; color: #4c44a9; fot-weight: bolder"
				href="${contextPath}/admin_welcome"><img
				src="/resources/img/logo.png" style="height: 30px; width: 30px">Attendance
				Tracker</a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="${contextPath}/admin_welcome">Home</a></li>

				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Sessions</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/addsessiondetails" class="dropdown-item"
							style="font-size: 18px">Add Sessions</a> <a
							href="${contextPath}/sessionslist" class="dropdown-item"
							style="font-size: 18px">Update Sessions</a>

					</div></li>
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Trainer</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/addtrainerdetails" class="dropdown-item"
							style="font-size: 18px">Add trainer</a> <a
							href="${contextPath}/trainerlist" class="dropdown-item"
							style="font-size: 18px">Update Trainer</a>

					</div></li>

				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Skills</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/addskills" class="dropdown-item"
							style="font-size: 18px">Add Skills</a>

					</div></li>
				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Skill-Session</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/skillsessionmapping" class="dropdown-item"
							style="font-size: 18px">Skill-Session-Mapping</a>

					</div></li>

				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Session Report</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/sessionsreportsadmin"
							class="dropdown-item" style="font-size: 18px">View Session
							Reports</a>

					</div></li>
				<li class="nav-item"><a class="nav-link btn btn-primary"
					style="width: 100px ;color:white"
					onclick="document.forms['logoutForm'].submit()">Logout</a></li>



			</ul>
		</div>
	</nav>



	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<form id="logoutForm" method="POST" action="${contextPath}/logout">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>

	</c:if>



	<div class="container mt-5">
		<div class="row mt-5 mb-5">
			<div class="col-lg-4" style="height: 500px; margin-top: 70px">
				<div>
					<h1 style="color: #8b8888;">
						Welcome back,<br>
						<h1 id=username
							style="color: #1bb1dc; padding-left: 6px; padding-top: 10px;">${pageContext.request.userPrincipal.name}</h1>
					</h1>
					<img src="${contextPath}/resources/img/adminwelcome.svg"
						style="padding-top: 120px; padding-right: 20px;" width="110%">

				</div>

			</div>

			<div class="col-lg-8 ml-2 row " style="margin-top: 70px">
				<div class="col-lg-5  mb-5 cardcol"
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">
					<div class="card cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">
						<a href="${contextPath}/addsessiondetails"
							style="text-decoration: none;">
							<div class="card-body cardheight " style="height: 250px;">
								<img src="${contextPath}/resources/img/addsessions.png"
									style="max-width: 150px">

								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Add
									Sessions</h4>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5 mb-5"
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">

					<div class="card  cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">

						<a href="${contextPath}/addtrainerdetails"
							style="text-decoration: none;">
							<div class="card-body cardheight">
								<img src="${contextPath}/resources/img/addtrainer.png"
									style="max-width: 150px"> <i
									class="fas fa-address-card fa-3x dashboardicons "></i>
								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Add
									Trainer</h4>
							</div>
						</a>
					</div>

				</div>
				<div class="col-lg-5 "
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">
					<div class="card  cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">
						<a href="${contextPath}/enrollmentrequest"
							style="text-decoration: none;">
							<div class="card-body cardheight">
								<img src="${contextPath}/resources/img/approve.png"
									style="max-width: 150px"> <i
									class="fas fa-cloud-upload-alt fa-3x  dashboardicons"></i>
								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Approve
									Enrollment</h4>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5"
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">
					<div class="card  cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">

						<a href="${contextPath}/sessionsreportsadmin"
							style="text-decoration: none;">
							<div class="card-body cardheight">
								<img src="${contextPath}/resources/img/report.png"
									style="max-width: 150px"> <i
									class="fas fa-file-medical fa-3x  dashboardicons "></i>
								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Sessions
									Report</h4>
							</div>
						</a>
					</div>
				</div>

			</div>

		</div>
	</div>




	<div class="footer-container" id="footer">
		<div class="copyright">&copy; Copyright 2021. All Rights
			Reserved by</div>
		<div class="credits">

			<a href="${contextPath}/"><strong>Attendance Tracker</strong></a>
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

