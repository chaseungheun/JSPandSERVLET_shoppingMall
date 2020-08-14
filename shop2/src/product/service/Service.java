package product.service;

import java.util.ArrayList;
import model.Product;

public interface Service {
	void add(Product p);
	ArrayList<Product> getProductsById(String s_id);
	Product getProduct(int num);
	void editProduct(Product p);
	void delProduct(int num);
	int makeNum();
	ArrayList<Product> getProductAll();
	Product editQuantity(int q, int num);
}
