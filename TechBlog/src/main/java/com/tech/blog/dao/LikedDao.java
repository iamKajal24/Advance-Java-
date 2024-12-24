package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikedDao {
	private Connection con;

	public LikedDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean insertLike(int pid, int uid) {
		boolean f = false;
		try {
			String query = "insert into liked (pid,uid) values(?,?)";
			PreparedStatement p = this.con.prepareStatement(query);
			// values set
			p.setInt(1, pid);
			p.setInt(2, uid);
			p.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

    public int countLikeOnPost(int pid) throws SQLException {
		int count=0;
    	
		String query = "select count(*) from liked where pid=?";
		PreparedStatement p = this.con.prepareStatement(query);
		p.setInt(1, pid);
		ResultSet set=p.executeQuery();
		if(set.next()) {
		  count=set.getInt("count(*)");
		}    	
    	return count;	
    }

    public boolean isLikedByUser(int pid, int uid) throws SQLException {
    	boolean f= false;
    	PreparedStatement p= this.con.prepareStatement("select * from liked where pid=? And uid=?");
    	p.setInt(1, pid);
    	p.setInt(2, uid);
    	ResultSet set = p.executeQuery();
    	if(set.next()) {
    		f=true;
    	}
    	return f;
    }

     public boolean deleteliked(int pid,int uid) throws SQLException {
    	 boolean f= false;
    	 PreparedStatement p = this.con.prepareStatement("delete from liked where pid=? And uid=?");
    	 p.setInt(1, pid);
    	 p.setInt(2, uid);
    	 p.executeUpdate();
    	 f=true;
    	 return false;
    	 
     }
}
