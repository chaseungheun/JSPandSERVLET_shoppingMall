package order.dao;

import java.util.ArrayList;

import model.Order;

public interface Dao {
	void insert(Order o);
	Order select(int num);
	ArrayList<Order> selectAll(String o_id, int o_state);
	void delete(int num);
	void update(String type, int num);
}
