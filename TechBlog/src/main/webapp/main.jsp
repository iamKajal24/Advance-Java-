<%@page import="com.tech.blog.helper.connectionProvider"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tech.blog.entities.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.tech.blog.dao.PostDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
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
</head>
<body>
	<!-- main body start -->
	<main>

		<div class="container">
			<div class="row mt-4">
				<!-- first col -->
					<!-- Categories -->
					
				<div class="col-md-4">
					<div class="list-group">
						<a href="#" onclick="getPosts(0,this)" class="c-link list-group-item list-group-item-action active"aria-current="true"> All Posts </a>
						<!-- Categories -->
						<%
			
							PostDao d= new PostDao(connectionProvider.getConnection());
						    ArrayList<Category> list1 =d.getAllCategories();
						    for(Category cc:list1){
						    	
						   %>
						    	<a href="#" onclick="getPosts(<%=cc.getCid() %>,this)" class="c-link list-group-item list-group-item-action"><%=cc.getName() %></a>
						    
						    <%
						    }
						    
						    %>
						
					
						
						
					</div>





				</div>
				<!-- second col -->
				<div class="col-md-8">
					<!-- Posts -->
					
					<div class="container text-center" id="loader">
					<i class="fa fa-refresh fa-3x fa-spin"></i>
					<h3 class="text-center">Loading...</h3>
					</div>
					
					<div class="container-fluid" id="post_container">
					
					
					
					</div>







				</div>
			</div>
		</div>
	</main>






	<!-- main body end -->
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
	
	<!-- loading post using ajax -->
	<script>
	//ye function ko jab hum call karege to function call hoga 
	function getPosts(catId,temp){
		
		$("#loader").show();
		$('#post_container').hide();
		
		//active class
		$(".c-link").removeClass('active')
		
		//alert("loading")
		
		$.ajax({
			url:"load_posts.jsp",
			data: {cid:catId},
			success : function (data, textStatus, jqXHR){
				console.log(data);
				$("#loader").hide()
				$('#post_container').show();
				//ajax ke through data ko main page per laya gya
				$('#post_container').html(data)
				//active class
				$(temp).addClass('active');
			}
		})
	}
	$(document).ready(function(e){
		// active 
		let allPostRef=$('.c-link')[0]
	    getPosts(0,allPostRef)
	})
	
	
	</script>
</body>
</html>