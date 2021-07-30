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
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">

<title>Attendance Marking</title>
</head>


<body background="${contextPath}/resources/img/intro-bg.jpg">





	<!-- NAVBAR WITH DROPDOWN -->
	<nav class="navbar navbar-expand-sm home-navbar mb-5">
		<div class="container">
			<a class="navbar-brand"
				style="font-size: 33px; font-family: monospace; color: #4c44a9; fot-weight: bolder"
				href="${contextPath}/welcome"><img src="/resources/img/logo.png"
				style="height: 30px; width: 30px">Attendance Tracker</a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="${contextPath}/welcome">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					style="font-size: 24px" href="#">About</a></li>

				<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Sessions</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/viewsessiondetails" class="dropdown-item"
							style="font-size: 18px">View Sessions</a> <a
							href="${contextPath}/viewenrolledsessions" class="dropdown-item"
							style="font-size: 18px">View Enrolled Sessions</a>

					</div></li>
								<li class="nav-item dropdown"><a href="#"
					class="nav-link dropdown-toggle" style="font-size: 24px"
					data-toggle="dropdown">Session Report</a>
					<div class="dropdown-menu">
						<a href="${contextPath}/viewsessionreportsuser"
							class="dropdown-item" style="font-size: 18px">View Session
							Reports</a>

					</div></li>
					<li class="nav-item dropdown"><a class="nav-link"
					style="font-size: 24px"
					href="/usernotification?userId=${user.id}"><img style="width: 40px; height: 40px" src="${contextPath}/resources/img/notificationicon.png"></a></li>
					


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
						<a href="${contextPath}/viewsessiondetails"
							style="text-decoration: none;">
							<div class="card-body cardheight " style="height: 250px;">
								<img src="${contextPath}/resources/img/viewsessions.png"
									style="max-width: 150px">

								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Available Sessions</h4>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5 mb-5"
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">

					<div class="card  cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">

						<a href="${contextPath}/viewenrolledsessions"
							style="text-decoration: none;">
							<div class="card-body cardheight">
								<img src="${contextPath}/resources/img/enrollsessions.png"
									style="max-width: 150px">
								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Enrolled Sessions</h4>
							</div>
						</a>
					</div>

				</div>
				<div class="col-lg-5 "
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">
					<div class="card  cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">
						<a href="${contextPath}/usernotification?userId=${ruser.id }"
							style="text-decoration: none;">
							<div class="card-body cardheight">
								<img src="${contextPath}/resources/img/notification.jpg"
									style="max-width: 150px"> <i
									class="fas fa-cloud-upload-alt fa-3x  dashboardicons"></i>
								<h4 class="card-title"
									style="color: black; font-size: 30px; text-decoration: none; margin-top: 40px;">Notifications</h4>
							</div>
						</a>
					</div>
				</div>
				<div class="col-lg-5"
					style="padding-right: 0; padding-left: 50px; margin-right: 0;">
					<div class="card  cardstyling"
						style="background-image: linear-gradient(315deg, #ffffff 0%, #d7e1ec 74%); border: none;">

						<a href="${contextPath}/viewsessionreportsuser"
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
	
	

	<%-- <div class="container">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<form id="logoutForm" method="POST" action="${contextPath}/logout">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
			<h2>
				Welcome ${pageContext.request.userPrincipal.name} | <a
					onclick="document.forms['logoutForm'].submit()">Logout</a>
			</h2>
		</c:if>
		<form:form method="POST" modelAttribute="search" action="/welcome"
			class="form-signin">
			<h2 class="form-signin-heading">Search sessions</h2>
			<spring:bind path="id">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:input type="text" path="id" class="form-control"
						placeholder="Search Sessions" autofocus="true" required="required"></form:input>
					<form:errors path="id"></form:errors>
				</div>
			</spring:bind>
			<spring:bind path="option">
				<div>
					<form:radiobutton path="option" value="sessionId" />
					<label>session Id</label>
					<form:radiobutton path="option" value="skillId" autofocus="true" />
					<label>skill id</label>
					<form:errors path="option"></form:errors>
				</div>
			</spring:bind>


			<div class="form-group">
				<input class="btn btn-success" style="font-size: 1.5em;"
					type="submit" id="submit" value="go">
			</div>
		</form:form>
		${message }
		<table>
			<tr>
				<th>${one}</th>
				<th>${two }</th>
				<th>${three }</th>
				<th>${four }</th>
				<th>${five }</th>
				<th>${six }</th>
			</tr>
			<c:forEach items="${sessionlist}" var="l">
				<tr class="table-secondary">
					<td>${l.sessionId}</td>
					<td>${l.sessionDesc}</td>
					<td>${l.skillSet}</td>
					<td>${l.sessionTime}</td>
					<td>${l.sessionDate}</td>
					<td>${l.availableSlots}</td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<br> --%>


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

