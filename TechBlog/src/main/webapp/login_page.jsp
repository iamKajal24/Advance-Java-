<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tech.blog.entities.Message"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
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

	<main
		class="d-flex align-items-center primary-background banner-background"
		style="height: 80vh">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 col-lg-4">
					<div class="card login-card">
						<div class="card-header primary-background text-white text-center">
							<span class="fa fa-user-plus fa-3x"></span><br>Login Here
						</div>


						<!-- Invalid msg -->
						<%
						
					    Message m = (Message) session.getAttribute("msg");
					    if (m != null) {
					%>
						<div class="alert <%=m.getCssClass() %>" role="alert">
							<%= m.getContent() %>
						</div>
						<%
					    session.removeAttribute("msg"); // Clear the message after displaying it
					    }
					%>



						<div class="card-body">
							<form action="loginServlet" method="post">
								<div class="mb-3">
									<label for="exampleInputEmail1" class="form-label">Email
										Address</label> <input type="email" required class="form-control"
										id="exampleInputEmail1" name="email"
										placeholder="Enter your email" aria-describedby="emailHelp">
									<div id="emailHelp" class="form-text">We'll never share
										your email with anyone else.</div>
								</div>
								<div class="mb-3">
									<label for="exampleInputPassword1" class="form-label">Password</label>
									<input type="password" required class="form-control"
										id="exampleInputPassword1" name="password"
										placeholder="Enter your password">
								</div>
								<div class="forgot-password mb-3">
									<a href="#">Forgot Password?</a>
								</div>
								<div class="mb-3 form-check">
									<input type="checkbox" class="form-check-input"
										id="exampleCheck1" name="rememberMe"> <label
										class="form-check-label" for="exampleCheck1">Remember
										Me</label>
								</div>
								<div class="container text-center">
									<button type="submit" class="btn btn-primary">Login</button>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</main>





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