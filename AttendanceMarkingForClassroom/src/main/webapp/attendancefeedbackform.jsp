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



	<nav class="navbar navbar-expand-sm home-navbar mb-5">
		<div class="container">
			<a class="navbar-brand"
				style="font-size: 33px; font-family: monospace; color: #4c44a9; fot-weight: bolder"
				href="${contextPath}/login"><img src="/resources/img/logo.png"
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

	
	<div class="container">

        <form:form method="POST" modelAttribute="addfeedback"  action="${contextPath}/markattendance" class="form-signin">
            <h2 class="form-signin-heading">Feedback form</h2>
            
            <spring:bind path="id">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                
                    <form:input type="number" path="id" class="form-control" placeholder="Session Enrolled Id"
                                autofocus="true"></form:input>
                    <form:errors path="id"></form:errors>
                </div>
            </spring:bind>
            
           
            <spring:bind path="feedback">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label path="feedback">${session.feedbackform}</form:label>
                    <form:input type="text" path="feedback" class="form-control" placeholder="Enter your feedback"
                                autofocus="true"></form:input>
                    <form:errors path="feedback"></form:errors>
                </div>
            </spring:bind>
            
            
            
            

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
            
        </form:form>
        <h4>${message}</h4>

    </div>
	


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

