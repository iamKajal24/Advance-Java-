<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Module Project | Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<!-- Form start -->
				<form action="Operation.jsp" method="post">
					<div class="card">
						<div class="card-header text-center bg-dark text-white">
							<h3>Provide Two Numbers</h3>
						</div>
						<div class="card-body bg-secondary">
							<div class="form-group">
								<label for="n1">Enter n1:</label> <input type="number"
									class="form-control" id="n1" name="n1"
									placeholder="Enter first number" required>
							</div>
							<div class="form-group">
								<label for="n2">Enter n2:</label> <input type="number"
									class="form-control" id="n2" name="n2"
									placeholder="Enter second number" required>
							</div>
						</div>
						<div class="card-footer text-center bg-dark text-white">
							<button type="submit" class="btn btn-outline-light mt-3">Divide</button>
						</div>
					</div>
				</form>
				<!-- Form end -->
			</div>
		</div>
	</div>

	<!-- Bootstrap JS and dependencies -->


</body>
</html>
