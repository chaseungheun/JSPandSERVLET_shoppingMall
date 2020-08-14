package model;

import java.sql.Date;

public class Order {
	private int num;
	private int pro_num;
	private int order_num;
	private int total_price;
	private String o_id;
	private Date o_date;
	private int o_state;
	private int d_state;
	private String prod_name;
	private String prod_img;

	public Order() {
	}

	public Order(int num, int pro_num, int order_num, int total_price,
			String o_id, Date o_date, int o_state, int d_state) {
		this.num = num;
		this.pro_num = pro_num;
		this.order_num = order_num;
		this.total_price = total_price;
		this.o_id = o_id;
		this.o_date = o_date;
		this.o_state = o_state;
		this.d_state = d_state;
	}

	public String getProd_img() {
		return prod_img;
	}

	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}

	public int getNum() {
		return num;
	}
	
	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getPro_num() {
		return pro_num;
	}

	public void setPro_num(int pro_num) {
		this.pro_num = pro_num;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getO_id() {
		return o_id;
	}

	public void setO_id(String o_id) {
		this.o_id = o_id;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public int getO_state() {
		return o_state;
	}

	public void setO_state(int o_state) {
		this.o_state = o_state;
	}

	public int getD_state() {
		return d_state;
	}

	public void setD_state(int d_state) {
		this.d_state = d_state;
	}

	@Override
	public String toString() {
		return "Order [num=" + num + ", pro_num=" + pro_num + ", order_num="
				+ order_num + ", total_price=" + total_price + ", o_id=" + o_id
				+ ", o_date=" + o_date + ", o_state=" + o_state + ", d_state="
				+ d_state + "]";
	}

}
