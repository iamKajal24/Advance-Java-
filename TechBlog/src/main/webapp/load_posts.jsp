<%@page import="com.tech.blog.dao.LikedDao"%>
<%@page import="com.tech.blog.helper.connectionProvider"%>
<%@page import="com.tech.blog.dao.PostDao"%>
<%@page import="com.tech.blog.entities.Post"%>
<%@page import="com.tech.blog.entities.User"%>
<%@page import="java.util.*"%>

<!-- Font Awesome link -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

<div class="row">
    <%
        // Retrieve current user from session
        User uuu = (User) session.getAttribute("currentUser");
        if (uuu == null) {
            out.println("<h5 class='display-4 text-center'>Please log in to view or interact with posts.</h5>");
            return; // Prevent further execution if user is not logged in
        }

        // Fetch posts based on the category ID
        PostDao d = new PostDao(connectionProvider.getConnection());
        int cid = Integer.parseInt(request.getParameter("cid"));
        List<Post> posts = (cid == 0) ? d.getAllPosts() : d.getPostByCatId(cid);

        if (posts.isEmpty()) {
            out.println("<h5 class='display-4 text-center'>No posts available in this category</h5>");
            return;
        }

        for (Post p : posts) {
            LikedDao ld = new LikedDao(connectionProvider.getConnection());
            int likeCount = ld.countLikeOnPost(p.getPid());
    %>
        <div class="col-md-6 mt-3">
            <div class="card">
                <img src="blog_pics/<%=p.getpPic()%>" 
                    class="card-img-top me-2 d-flex flex-wrap gap-3"
                    alt="Card image cap"
                    style="object-fit: cover; height: 400px; width: 390px">

                <div class="card-body">
                    <b><%=p.getpTitle()%></b>
                    <p><%=p.getpContent()%></p>
                </div>
                <div class="card-footer text-center primary-background">
                    <a href="#!" 
                        onclick="doLike(<%=p.getPid()%>, <%=uuu.getId()%>)" 
                        class="btn btn-outline-light btn-sm">
                        <i class="fas fa-thumbs-up"></i> 
                        <span id="like-counter-<%=p.getPid()%>"><%=likeCount %></span>
                    </a>
                    <a href="show_blog_page.jsp?post_id=<%=p.getPid() %>" class="btn btn-outline-light btn-sm">Read more...</a>
                    <a href="#!" class="btn btn-outline-light btn-sm">
                        <i class="fas fa-comment"></i> <span>20</span>
                    </a>
                </div>
            </div>
        </div>
    <%
        }
    %>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // JavaScript function for handling "like" action
    function doLike(pid, uid) {
        console.log(pid + "," + uid);

        const d = {
            uid: uid,
            pid: pid,
            Operation: 'like'
        };

        // AJAX call to the server
        $.ajax({
            url: "LikedServlet", // URL of the servlet handling the like operation
            data: d,             // Data to be sent to the server
            method: 'POST',      // It's a good practice to specify the HTTP method
            success: function(data, textStatus, jqXHR) {
                console.log(data); // This will now log the plain text response (e.g., "Like added")
                if (data.trim() == 'true') {
                    let c = parseInt($(".like-counter").text()); // Get the current count
                    c++; // Increment the count
                    $('.like-counter').text(c); // Update the text with the new count
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                // Handle error
                console.log("Error: " + textStatus + " - " + errorThrown);
            }
        });
    }
</script>
