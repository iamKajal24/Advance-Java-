package com.tech.blog.dao;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;
import com.tech.blog.helper.connectionProvider;

public class PostDao {
	Connection con;

	public PostDao(Connection con) {
		super();
		this.con = con;
	}
    
	// category function jisko baar baar use kar sakte hai 
	public ArrayList<Category> getAllCategories() {
		ArrayList<Category> list = new ArrayList();

		try {

			String query = "select * from categories";
			Statement st = this.con.createStatement();
			ResultSet set = st.executeQuery(query);
			while (set.next()) {
				int cid = set.getInt("cid");
				String name = set.getString("name");
				String description = set.getString("description");

				Category c = new Category(cid, name, description);
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean savePost(Post p) {
		boolean f = false;
		try {
			String query = "insert into posts (pTitle,pContent,pCode,pPic,catId,userId) values(?,?,?,?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			psmt.setString(1, p.getpTitle());
			psmt.setString(2, p.getpContent());
			psmt.setString(3, p.getpCode());
			psmt.setString(4, p.getpPic());
			psmt.setInt(5, p.getcatId());
			psmt.setInt(6, p.getUserId());
            
			psmt.executeUpdate();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
     
	
	
	//get all posts saare post nikal ke de rha hoga ...jitne list mei rakhe hoge
    public List<Post> getAllPosts(){
		
    	List<Post> list= new ArrayList<Post>();
    	//fetch all the post
    	try {
    		PreparedStatement psmt= con.prepareStatement("select * from posts order by pid desc");
    		ResultSet set= psmt.executeQuery();
    		while(set.next()) {
    			int pid=set.getInt("pid");
    			String pTitle=set.getString("pTitle");
    			String pContent= set.getString("pContent");
    			String pCode=set.getString("pCode");
    			String pPic=set.getString("pPic");
    			Timestamp date=set.getTimestamp("pDate");
    			int catId=set.getInt("catId");
    		    int userId=set.getInt("userId");
    		    Post post = new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);
    			list.add(post);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return list;
    }


    // list of post ko return kar rha hoga
    //get all post by id
    public List<Post> getPostByCatId(int catId){
    	
    	List<Post> list= new ArrayList<Post>();
    	//fetch all the post
    	try {
    		PreparedStatement psmt= con.prepareStatement("select * from posts where catId=?");
    		psmt.setInt(1, catId);
    		
    		ResultSet set= psmt.executeQuery();
    		while(set.next()) {
    			int pid=set.getInt("pid");
    			String pTitle=set.getString("pTitle");
    			String pContent= set.getString("pContent");
    			String pCode=set.getString("pCode");
    			String pPic=set.getString("pPic");
    			Timestamp date=set.getTimestamp("pDate");
    		    int userId=set.getInt("userId");
    		    Post post = new Post(pid,pTitle,pContent,pCode,pPic,date,catId,userId);
    			list.add(post);
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	return list;
    }

     public Post getPostByPostId(int postId) throws SQLException {
		Post post = null;
    	 String query = "select * from posts where pid=?";
    	 PreparedStatement psmt = this.con.prepareStatement(query);
    	 psmt.setInt(1, postId);
    	 ResultSet set=psmt.executeQuery();
    	 if(set.next()) {
    		
    		 int pid=set.getInt("pid");
 			String pTitle=set.getString("pTitle");
 			String pContent= set.getString("pContent");
 			String pCode=set.getString("pCode");
 			String pPic=set.getString("pPic");
 			Timestamp date=set.getTimestamp("pDate");
 			int cid= set.getInt("catId");
 		   
 			int userId=set.getInt("userId");
 		     post = new Post(pid,pTitle,pContent,pCode,pPic,date,cid,userId);
	
    	 }
    	 return post;
     }

}
