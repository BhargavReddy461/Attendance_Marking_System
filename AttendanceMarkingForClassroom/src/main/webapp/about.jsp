<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<body>
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
<main id="main">
    <!-- ======= About Section ======= -->
    <section id="about" class="about">

      <div class="container" data-aos="fade-up">
        <div class="row gx-0">

          <div class="col-lg-6 d-flex flex-column justify-content-center" data-aos="fade-up" data-aos-delay="200">
            <div class="content">
              <h3>Who We Are</h3>
              <h2>Expedita voluptas omnis cupiditate totam eveniet nobis sint iste. Dolores est repellat corrupti reprehenderit.</h2>
              <p>
                Quisquam vel ut sint cum eos hic dolores aperiam. Sed deserunt et. Inventore et et dolor consequatur itaque ut voluptate sed et. Magnam nam ipsum tenetur suscipit voluptatum nam et est corrupti.
              </p>
              <div class="text-center text-lg-start">
                <a href="#" class="btn-read-more d-inline-flex align-items-center justify-content-center align-self-center">
                  <span>Read More</span>
                  <i class="bi bi-arrow-right"></i>
                </a>
              </div>
            </div>
          </div>

          <div class="col-lg-6 d-flex align-items-center" data-aos="zoom-out" data-aos-delay="200">
            <img src="${contextPath}/resources/img/about.jpg" class="img-fluid" alt="about image">
          </div>

        </div>
      </div>

    </section>

</body>
</html>