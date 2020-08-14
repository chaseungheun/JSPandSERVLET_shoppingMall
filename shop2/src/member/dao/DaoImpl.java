package  member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import conn.DBConnect;
import model.Member;


public class DaoImpl implements Dao {
	
	
	private DBConnect db;
	 
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

		
	
	public void insert(Member m) {
		Connection conn = null;
		String sql= "insert into shop_member values(?,?,?,?,?,?)";
		PreparedStatement p = null;
		try {
			conn = db.getConnection();
			p = conn.prepareStatement(sql);
			p.setString(1, m.getId());
			p.setString(2, m.getPwd());
			p.setString(3, m.getName());
			p.setString(4, m.getEmail());
			p.setString(5, m.getAddr());
			p.setInt(6, m.getType());
			p.executeUpdate();
			
		}catch(Exception e) {}
		finally {
			try {
				conn.close();
				p.close();
			}catch(Exception e) {}
		}
	}

	public Member select(String id) {
		Connection c = null;
		ResultSet rs = null;
		Member m =null;
		String sql = "select * from shop_member where id = ?";
		PreparedStatement p = null;
		
		try {
			c = db.getConnection();
			p = c.prepareStatement(sql);
			p.setString(1, id);
			rs=p.executeQuery();
			if(rs.next()) {
				m = new Member(rs.getString(1),rs.getString(2),rs.getString(3)
						,rs.getString(4),rs.getString(5),rs.getInt(6));
			
			}
		}catch(Exception e) {
			
		}finally {
			try {
				rs.close();
				p.close();
				c.close();
			}catch(Exception e) {}
		}
		
		return m;
	}

	
	
	public void update(Member m) {
		Connection conn = null;
		String sql = "update shop_member set pwd=?, email=?, addr=? where id=?";
		PreparedStatement p = null;
		try {
			conn = db.getConnection();
			p = conn.prepareStatement(sql);
			p.setString(1, m.getPwd());
			p.setString(2, m.getEmail());
			p.setString(3, m.getAddr());
			p.setString(4, m.getId());
			p.executeUpdate();
		}catch (Exception e) {
			
		}finally{
			try {
				p.close();
				conn.close();
			}catch (Exception e) {
				
			}
		}
	}

	
	
	public void delete(String id) {

		Connection conn = null;
		String sql = "delete shop_member where id=?";
		PreparedStatement p = null;
		try {
			conn = db.getConnection();
			p = conn.prepareStatement(sql);
			p.setString(1, id);
			p.executeUpdate();
		}catch (Exception e) {
			
		}
	}

}
