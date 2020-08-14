package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import conn.DBConnect;
import model.Product;

public class DaoImpl implements Dao {
	
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	

	public void insert(Product p) {
		Connection conn = db.getConnection();
		String sql ="insert into shop_product values(?,?,?,?,?,?,?)";
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, p.getNum());
			pre.setString(2, p.getName());
			pre.setInt(3, p.getQuantity());
			pre.setInt(4, p.getPrice());
			pre.setString(5, p.getImg());
			pre.setString(6, p.getContent());
			pre.setString(7, p.getS_id());
			pre.executeUpdate();
		}catch (Exception e) {}
		finally {
			try {
				pre.close();
				conn.close();
			}catch (Exception e) {}
		}
		
	}

	
	public Product select(int num) {
		ResultSet rs = null;
		Product product = null;
		Connection conn = db.getConnection();
		PreparedStatement pre = null;
		String sql ="select * from shop_product where num=?";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, num);
			rs=pre.executeQuery();
			if(rs.next()) {
				product = new Product(rs.getInt(1), rs.getString(2),
						rs.getInt(3),rs.getInt(4),rs.getString(5),
						rs.getString(6),rs.getString(7));
						
			}
			rs.close();
		}catch(Exception e) {

		}finally {
			try {
				
				pre.close();
				conn.close();
			}catch(Exception e) {}
		}
		return product;
	}
	
	public ArrayList<Product> selectAllById(String s_id) {
		Connection conn = db.getConnection();
		ResultSet rs = null;
		ArrayList<Product> products = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		String sql = "select * from shop_product where s_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)
						,rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		}catch (Exception e) {}
		finally {
			try {
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				
			}
		}
		return products;
	}

	

	public void update(Product p) {
		Connection conn = db.getConnection();
		String sql = "update shop_product set name=?, quantity=?, price=?, content=? where num=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,p.getName());
			pstmt.setInt(2, p.getQuantity());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4,p.getContent());
			pstmt.setInt(5, p.getNum());
			pstmt.executeUpdate();
		}catch (Exception e) {
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {}
		}
		
	}

	public void delete(int num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete shop_product where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
				pstmt.close();
			}
			catch(Exception e) {}
		}
	}

	@Override
	public int selectNum() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select seq_shop_product.nextval from dual";
		int num = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);
			}
			rs.close();
		}catch(Exception e) {
			
		}finally {
			try {
				conn.close();
				pstmt.close();
			}
			catch(Exception e) {}
		}
		
		return num;
	}
	
	
	

	
	public ArrayList<Product> selectAll() {
		ArrayList<Product> products = new ArrayList<Product>();
		ResultSet rs = null;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		String sql = "select * from shop_product";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				products.add(new Product(rs.getInt(1),rs.getString(2),
						rs.getInt(3), rs.getInt(4),rs.getString(5),
						rs.getString(6),rs.getString(7)
						));
				
			}
			rs.close();
		}catch (Exception e) {
			
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch (Exception e) {
				
			}
		}
		
		return products;
	}

	
	
	public void updateQuantity(int q, int num) {
		Connection conn = db.getConnection();
		String sql = "update shop_product set quantity=quantitiy-? where num=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q);
			pstmt.setInt(2, num);
			pstmt.executeUpdate();
		}catch (Exception e) {
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch(Exception e) {}
		}
		
	}



	

}
