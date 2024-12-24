<%@page import="com.tech.blog.helper.connectionProvider"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- CSS Link -->
<link rel="stylesheet" href="CSS/style.css">

<!-- Font awesome link -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	rel="stylesheet">

<style>
/* Ensure the banner has width and height set */
.banner-background {
	width: 100%; /* Ensure full width */
	height: 300px; /* Adjust height as needed */
	background-color: #007bff; /* Add a background color for visibility */
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 92%, 72% 89%, 39% 94%, 0 91%, 0 0);
}
</style>


</head>
<body>
	<!-- navbar -->
	<%@include file="normal_navbar.jsp"%>

	<!-- Banner -->
	<div class="container-fluid p-0">
		<div
			class="jumbotron primary-background text-white m-auto py-5-center banner-background">
			<div class="container">
				<h3 class="display-4">Welcome to TechBlog</h3>
				<p>Welcome to the technical blog, a world of technology. A
					programming language is a system of notation for writing computer
					programs. Programming languages are described in terms of their
					syntax (form) and semantics (meaning), usually defined by a formal
					language.</p>
				<p>Languages usually provide features such as a type system,
					variables, and mechanisms for error handling. An implementation of
					a programming language is required to execute programs, namely an
					interpreter or a compiler.</p>
				<button class="btn btn-outline-light btn-lg mb-4">
					<span class="fa fa-user-plus"></span>Start! It's Free
				</button>
				<a href="login_page.jsp" class="btn btn-outline-light btn-lg mb-4">
					<i class="fas fa-user-circle fa-spin" style="font-size: 18px;"></i>
					Login
				</a>
			</div>
		</div>
	</div>

	<!-- cards -->

	<div class="container">
		<div class="row mt-3">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row mt-2">

			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Java Programming language</h5>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="btn primary-background text-white">Read
							More</a>
					</div>
				</div>
			</div>
		</div>
	</div>








	<!-- jQuery Link -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<!-- Bootstrap JS Links -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>

	<!-- JS Script -->
	<script src="JS/script.js"></script>


</body>
</html>
