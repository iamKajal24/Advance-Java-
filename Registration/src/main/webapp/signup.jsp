<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>

<!-- materlize css link -->
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>

<body
	style="background: url('Image/img.jpg'); background-size: cover; background-attachment: fixed;">

	<div class="container">
		<div class="row">
			<div class="col col-m6 offset-m3 ">
				<div class="card">
					<div class="card-content">
						<h3 style="margin-top: 10px;" class="center-align">Register
							here!!</h3>
						<h5 id="msg" class="center align"></h5>

						<!-- form -->

						<div class="form center-align">
							<!-- creating from -->

							<form action="Register" method="post" enctype="multipart/form-data" id="myform">
								<input type="text" name="user_name"
									placeholder="enter user name" /> <input type="email"
									name="user_email" placeholder="enter user email" /> <input
									type="password" name="user_password"
									placeholder="enter user password" />

								<!-- Image -->
								<div class="file-field input-field">
									<div class="btn">
										<span>File</span> 
										<input name="image" type="file">
									</div>
									<div class="file-path-wrapper">
										<input class="file-path validate" type="text">
									</div>
								</div>

								<!-- button -->
								<button type="submit" class="btn">Submit</button>
								<button type="reset" class="btn">Reset</button>
							</form>

						</div>

						<!-- loader -->

						<div class="loader center-align"
							style="margin-top: 10px; display: none;">

							<div class="preloader-wrapper big active">
								<div class="spinner-layer spinner-blue">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>

								<div class="spinner-layer spinner-red">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>

								<div class="spinner-layer spinner-yellow">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>

								<div class="spinner-layer spinner-green">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>
							</div>

							<h5>Please wait...</h5>

						</div>
					</div>


				</div>

			</div>

		</div>

	</div>

	<!-- Jquery tag -->
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"
		integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
		crossorigin="anonymous"></script>

	<!-- Script tag -->
	<script>
  $(document).ready(function() {
    console.log("Page is ready...");

    $("#myform").on('submit', function(event) {
      // Prevent default form submission
      event.preventDefault();

      // Serialize the form data
      let f = new FormData(this); // Prepare form data for file upload
      console.log(f);

      // Show loader and hide form
      $(".loader").show();
      $(".form").hide();

      // Perform AJAX request
      $.ajax({
        url: "Register", // Servlet URL
        data: f,
        type: 'POST',
        processData: false, // Prevent jQuery from automatically transforming the data
        contentType: false, // Prevent setting of the content-type header
        success: function(data, textStatus, jqXHR) {
          console.log("Success: ", data);
          $(".loader").hide();
          $(".form").show();

          // Update the message based on the response
          if (data.trim() === 'success') {
            $('#msg').html("Successfully Registered!!").css("color", "green");
          } else {
            $('#msg').html("Something went wrong on the server").css("color", "red");
          }
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log("Error: ", errorThrown);
          $(".loader").hide();
          $(".form").show();
          $('#msg').html("Something went wrong on the server").css("color", "red");
        }
      });
    });
  });
</script>



</body>
</html>