<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>form page</title>
<link rel="stylesheet"
	href="<%= application.getContextPath() %>/CSS/style.css">
</head>
<body>

	<div class="form-container">
		<h1>My Form</h1>
		<form action="RegisterServlet" method="post">
			<!-- Name -->
			<div class="mb-3">
				<label for="name" class="form-label">Name:</label> <input
					type="text" class="form-control" placeholder="Enter your name"
					name="name" required>
			</div>
			<!-- Email -->
			<div class="mb-3">
				<label for="email" class="form-label">Email:</label> <input
					type="email" class="form-control" id="email"
					placeholder="Enter your email" name="email" required>
			</div>
			<!-- Password -->
			<div class="mb-3">
				<label for="pwd" class="form-label">Password:</label> <input
					type="password" class="form-control" id="pwd"
					placeholder="Enter your password" name="pswd" required>
			</div>
			<!-- Gender -->
			<div class="mb-3">
				<label class="form-label">Select Gender:</label>
				<div class="gender-radio-group">
					<div class="form-check">
						<input type="radio" id="male" name="gender" value="Male"
							class="form-check-input" required> <label for="male"
							class="form-check-label">Male</label>
					</div>
					<div class="form-check">
						<input type="radio" id="female" name="gender" value="Female"
							class="form-check-input" required> <label for="female"
							class="form-check-label">Female</label>
					</div>
					<div class="form-check">
						<input type="radio" id="other" name="gender" value="Other"
							class="form-check-input" required> <label for="other"
							class="form-check-label">Other</label>
					</div>
				</div>
			</div>
			<!-- Course Selection -->
			<div class="mb-3">
				<label for="courses" class="form-label">Select your course:</label>
				<select id="courses" name="course" class="form-select" required>
					<option value="Java Development">Java Development</option>
					<option value="Machine Learning">Machine Learning</option>
					<option value="Web Development">Web Development</option>
					<option value="Data Science">Data Science</option>
					<option value="Cloud Computing">Cloud Computing</option>
				</select>
			</div>
			<!-- Terms and Conditions -->
			<div class="form-check mb-3">
				<input type="checkbox" class="form-check-input" name="condition"
					required> <label class="form-check-label">Agree to
					Terms and Conditions</label>
			</div>
			<!-- Buttons -->
			<div class="button-container">
				<button type="submit" class="submit-btn">Register</button>
				<button type="reset" class="reset-btn">Reset</button>
			</div>
		</form>
	</div>


</body>
</html>
