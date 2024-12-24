<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.helper.connectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tech.blog.entities.Message"%>
<%@ page import="java.text.SimpleDateFormat, java.sql.Timestamp"%>
<%@ page import="com.tech.blog.entities.User"%>
<%@ page errorPage="error.jsp"%>
<%@ page import="com.tech.blog.dao.PostDao"%>
<%@page errorPage="error.jsp" %>

<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
	response.sendRedirect("login_page.jsp");
	return; // Ensure no further code executes after redirect
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Page</title>
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
body{
background:url(Image/background1.jpg);
background-size:cover;
background-attachment:fixed;
}

</style>
</head>
<body>
	<!-- navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark primary-background">
		<div class="container-fluid">
			<a class="navbar-brand" href="HomePage.jsp"><span
				class="fa fa-asterisk"></span> Techblog</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item" style="font-size: 18px;"><a
						class="nav-link active" aria-current="page" href="#"><span
							class="fa fa-bell"></span> LearnCode for Kajal</a></li>
					<li class="nav-item dropdown" style="font-size: 18px;"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							<span class="fa fa-check-square"></span> Catergories
					</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#">Programming
									Language</a></li>
							<li><a class="dropdown-item" href="#">Project
									Implementation</a></li>
							<!--  <li><hr class="dropdown-divider"></li> -->
							<li><a class="dropdown-item" href="#">Data Structure</a></li>
							<li><a class="dropdown-item" href="#">Machine Learning</a></li>
						</ul></li>
					<li class="nav-item" style="font-size: 18px;"><a
						class="nav-link" href="#"><span class="fas fa-phone"></span>
							Contact</a></li>

					<li class="nav-item" style="font-size: 18px;"><a
						class="nav-link" href="#" data-bs-toggle="modal"
						data-bs-target="#add-post-modal"> <i class="fas fa-asterisk"></i>
							Do Post
					</a></li>

				</ul>

				<ul class="navbar-nav me-right">

					<li class="nav-item" style="font-size: 18px;"><a
						class="nav-link" href="#" data-bs-toggle="modal"
						data-bs-target="#profile-modal"> <span
							class="fas fa-user-circle"></span> <%=user.getName()%>
					</a></li>


					<li class="nav-item" style="font-size: 18px;"><a
						class="nav-link" href="LogoutServlet"> <span
							class="fas fa-user-plus"></span> Logout
					</a></li>

				</ul>

			</div>
		</div>
	</nav>
	<!-- end of navbar-->

	<%
	Message m = (Message) session.getAttribute("msg");
	if (m != null) {
	%>
	<div class="alert <%=m.getCssClass()%>" role="alert">
		<%=m.getContent()%>
	</div>
	<%
	session.removeAttribute("msg"); // Clear the message after displaying it
	}
	%>
	
	<!-- start main body of the page -->
	<!-- navbar -->
	<%@include file="main.jsp"%>
	
	<!-- end main body of the page -->

	<!-- Start profile modal  -->
	<!-- Modal -->
	<div class="modal fade" id="profile-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header primary-background text-white">
					<h5 class="modal-title" id="exampleModalLabel">TechBlog</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="container text-center">
						<!-- profile image -->
						<img src="<%=user.getProfile()%>" alt="User Profile"
							class="img-fluid" style="border-radius: 50%; max-width: 100px;" />
						<h5 class="modal-title mt-3" id="exampleModalLabel"><%=user.getName()%></h5>

						<!-- details -->

						<div id="profile-details">

							<table class="table">
								<tbody>
									<tr>
										<th scope="row">ID :</th>
										<td><%=user.getId()%></td>

									</tr>
									<tr>
										<th scope="row">Email :</th>
										<td><%=user.getEmail()%></td>

									</tr>
									<tr>
										<th scope="row">Gender :</th>
										<td colspan="2"><%=user.getGender()%></td>

									</tr>
									<tr>
										<th scope="row">Status :</th>
										<td colspan="2"><%=user.getAbout()%></td>

									</tr>

									<%
									// Retrieve the attribute set in the servlet
									Timestamp registerDate = (Timestamp) request.getAttribute("registerDate");

									// Format the date (optional)
									String formattedDate = "Not Available";
									if (registerDate != null) {
										SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										formattedDate = dateFormat.format(registerDate);
									}
									%>
									<tr>
										<th scope="row">Registerd on :</th>
										<td colspan="2"><%=formattedDate%></td>
									</tr>
								</tbody>
							</table>
						</div>

						<!-- profile edit -->
						<div id="profile-edit" style="display: none">
							<h3 class="mt-3">Please Edit Carefully</h3>
							<form action="EditServlet" method="post"
								enctype="multipart/form-data">
								<table class="table">
									<tr>
										<td>ID :</td>
										<td><%=user.getId()%></td>
									</tr>
									<tr>
										<td>Email :</td>
										<td><input type="email" class="form-control"
											name="user_email" value=<%=user.getEmail()%>></td>

									</tr>
									<tr>
										<td>Name :</td>
										<td><input type="text" class="form-control"
											name="user_name" value=<%=user.getName()%>></td>
									</tr>
									<tr>
										<td>Password :</td>
										<td><input type="password" class="form-control"
											name="user_password" value=<%=user.getPassword()%>></td>
									</tr>
									<tr>
										<td>Gender :</td>
										<td><%=user.getGender().toUpperCase()%></td>
									</tr>
									<tr>
										<td>Status :</td>
										<td><textarea class="form-control" name="user_about"><%=user.getAbout()%></textarea></td>
									</tr>
									<tr>
										<td>New Profile Pic:</td>
										<td><input type="file" class="form-control" name="image" />
										</td>
									</tr>
								</table>
								<div class="container">
									<button type="submit" class="btn btn-outline-success">Save</button>
								</div>
							</form>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button id="edit-profile-button" type="button"
						class="btn btn-primary">Edit</button>
				</div>
			</div>
		</div>
	</div>
	<!-- end of profile modal -->


	<!-- start post modal -->

	<!-- Modal -->
	<div class="modal fade" id="add-post-modal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Provide the
						post details...</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<!-- do post form -->

					<form id="add-post-form" action="AddPostServlet" method="post">

						<!-- select option start -->
						<div class="form-group">
							<select class="form-control mb-2" name="cid">
								<option selected disabled>---Select categories---</option>
								<%
								PostDao postd = new PostDao(connectionProvider.getConnection());
								ArrayList<Category> list = postd.getAllCategories();
								for (Category c : list) {
								%>
								<option value="<%=c.getCid()%>"><%=c.getName()%></option>
								<%
								}
								%>
							</select>
						</div>

						<!-- select option end -->

						<div class="form-group">
							<input name="pTitle" type="text" placeholder="Enter post Title"
								class="form-control" />
						</div>
						<div class="form-group">
							<textarea name="pContent" placeholder="Enter your content"
								style="height: 120px;" class="form-control mt-2"></textarea>
						</div>
						<div class="form-group">
							<textarea name="pCode" placeholder="Enter your program (if any)"
								style="height: 120px;" class="form-control mt-2"></textarea>
						</div>
						<div class="form-group">
							<label class="mt-1">Select your Image :</label> <input name="Pic"
								type="file" class="form-control mt-1" />
						</div>

						<div class="container text-center mt-2">
							<button type="submit" class="btn btn-outline-primary">Post</button>

						</div>

					</form>

					<!-- form end -->

				</div>

			</div>
		</div>
	</div>

	<!-- end post modal -->


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

	<!-- SweetAlert CDN link -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!-- JS Script -->
	<script src="JS/script.js"></script>
	<!-- edit  -->
	<script>
		$(document).ready(function() {
			let editStatus = false;

			$('#edit-profile-button').click(function() {
				//			alert("button clicked")
				//            $('#profile-details').hide()
				//            $('#profile-edit').show()
				if (editStatus == false) {
					$('#profile-details').hide()
					$('#profile-edit').show()
					editStatus = true;
					$(this).text("Back")
				} else {
					$('#profile-details').show()
					$('#profile-edit').hide()
					editStatus = false;
					$(this).text("Edit")
				}
			})
		})
	</script>
	<!-- now add post js -->
	<script>
		$(document).ready(function() {
			//
			$("#add-post-form").on("submit", function() {
				//this code gets called when form is submitted
				event.preventDefault();
				console.log("you have clicked on submit...")

				let form = new FormData(this);

				//now request to servlet
				$.ajax({
					url : "AddPostServlet",
					type : "POST",
					data : form,
					success : function(data, textStatus, jqXHR) {
						//success
						console.log(data)
						if (data.trim() == 'done') {
							swal("Good job!", "saved successfully", "success");
						}
						else{
							swal("error", "Something went wrong try again!", "danger");
						}
                         
					},
					error : function(jqXHR, textStatus, errorThrown) {
						//error	

						swal("error", "Something went wrong try again!", "danger");

					},
					
					processData : false,
					contentType : false
				})

			})
		})
	</script>
</body>
</html>
