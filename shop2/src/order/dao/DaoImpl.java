package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Order;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Order o) {
		Connection conn = db.getConnection();
		String sql = "insert into shop_order values(seq_shop_order.nextval,?,?,?,?,sysdate,?,0)";
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, o.getPro_num());
			p.setInt(2,  o.getOrder_num());
			p.setInt(3,  o.getTotal_price());
			p.setString(4,  o.getO_id());
			p.setInt(5,  o.getO_state());
			p.executeUpdate();
		}catch (Exception e) {
			
		}finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}

	@Override
	public Order select(int num) {
		Order o = null;
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from shop_order where num=?";
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			p.setInt(1, num);
			rs = p.executeQuery();
			while(rs.next()) {
				return new Order(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getString(5),rs.getDate(6), rs.getInt(7),rs.getInt(8));
			}
		}catch(Exception e) {}
		finally {
			
		}
		return o;
	}

	@Override
	public ArrayList<Order> selectAll(String o_id, int o_state) {
		ArrayList<Order> list = new ArrayList<Order>();
		ResultSet rs = null;
		Connection conn = db.getConnection();
		String sql = "select * from shop_order where o_id=? and o_state=?";
		try {
			PreparedStatement p = conn.prepareStatement(sql);
			p.setString(1, o_id);
			p.setInt(2, o_state);
			rs = p.executeQuery();
			while(rs.next()) {
				list.add(new Order(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),
						rs.getString(5),rs.getDate(6), rs.getInt(7),rs.getInt(8)));
			}
		}catch (Exception e) {}
		finally {
			try {
				conn.close();
			}catch (Exception e) {
				
			}
		}
		return list;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String type, int num) {
		// TODO Auto-generated method stub
		
	}
}
