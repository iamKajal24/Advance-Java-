<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration From</title>
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

<!-- <style>
/* Ensure the banner has width and height set */
.banner-background {
	width: 100%; /* Ensure full width */
	height: 300px; /* Adjust height as needed */
	background-color: #007bff; /* Add a background color for visibility */
	clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 92%, 72% 89%, 39% 94%, 0 91%, 0 0);
}
</style> -->
</head>
<body>

	<!-- navbar -->
	<%@include file="normal_navbar.jsp"%>
	<!-- Registration form -->

	<main class="d-flex align-items-center banner-background pb-5"
		style="height: 100vh">
		<div class="container">
			<div class="col-md-6 offset-md-3">
				<div class="card">


					<div class="card-header primary-background text-white text-center">
						<span class="fa fa-user-circle fa-3x"></span><br>Register
						here
					</div>

					<div class="card-body">
						<form id="reg-form" action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="user_name" class="form-label">User Name</label> <input
									type="text" class="form-control" id="user_name"
									name="user_name" placeholder="Enter your name"
									aria-describedby="userHelp">
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1" class="form-label">Email
									Address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" name="email"
									aria-describedby="emailHelp" placeholder="Enter your email">
								<div id="emailHelp" class="form-text">We'll never share
									your email with anyone else.</div>
							</div>

							<div class="form-group">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" name="password"
									placeholder="Enter your password">
							</div>

							<div class="form-group">
								<label class="gender">Select Gender</label> <br> <input
									type="radio" id="gender_male" name="gender" value="Male">
								<label for="gender_male">Male</label> <input type="radio"
									id="gender_female" name="gender" value="Female"> <label
									for="gender_female">Female</label>
							</div>

							<div class="form-group">
								<label for="about">About</label>
								<textarea name="about" class="form-control" id="about" rows="2"
									placeholder="Enter something about yourself"></textarea>
							</div>

							<div class="mb-3 form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1" name="agree_terms"> <label
									class="form-check-label" for="exampleCheck1">Agree to
									terms and conditions</label>
							</div>

							<div class="container text-center" id="loader"
								style="display: none">
								<span class="fa fa-refresh fa-spin fa-2x"></span>
								<h5>Please Wait...</h5>
							</div>
							<button id="submit-btn" type="submit" class="btn btn-primary">Submit</button>

						</form>

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

	<!-- SweetAlert CDN link -->
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<!-- JS Script -->
	<script src="JS/script.js"></script>

	<script>
  $(document).ready(function () {
    console.log("loaded...");

    $('#reg-form').on('submit', function (event) {
      event.preventDefault();

      // Prepare form data for file upload
      let form = new FormData(this);

      // Hide submit button and show loader
      $("#submit-btn").hide();
      $("#loader").show();

      // Perform AJAX request
      $.ajax({
        url: "RegisterServlet", // Servlet URL
        data: form,
        type: 'POST',
        processData: false, // Prevent jQuery from automatically transforming the data
        contentType: false, // Prevent setting of the content-type header
        success: function (data, textStatus, jqXHR) {
          console.log("Success: ", data);

          // Show submit button and hide loader
          $("#submit-btn").show();
          $("#loader").hide();

          // Display success alert
          /* swal("Registered Successfully!")
            .then((value) => {
              console.log(`The returned value is: ${value}`);
            });*/
            
            if(data.trim()==='done'){
            	swal("Registered Successfully..We are going to redirect to login page")
                .then((value) => {
                  window.location="login_page.jsp"
                });
            }
            else{
            	swal(data)
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
          console.log("Error: ", errorThrown);

          // Show submit button and hide loader
          $("#submit-btn").show();
          $("#loader").hide();
          swal("something went wrong... please try again");
        }
      });
    });
  });
</script>




</body>
</html>