package order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Order;
import model.Product;
import order.service.Service;
import order.service.ServiceImpl;

/**
 * Servlet implementation class MyListController
 */
@WebServlet("/order/myList")
public class MyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service service =new ServiceImpl();
		product.service.Service service_prod = new product.service.ServiceImpl();
		int o_state = Integer.parseInt(request.getParameter("o_state"));
		HttpSession session = request.getSession(false);
		String o_id = (String) session.getAttribute("id");
		ArrayList<Order> list = service.orderList(o_id, o_state);
		
		for(Order o :list) {
			Product p = service_prod.getProduct(o.getPro_num());
			o.setProd_name(p.getName());
			o.setProd_img(p.getImg());
		}
		request.setAttribute("list", list);
		request.setAttribute("o_state", o_state);
		String path = "/view/order/myList.jsp";
		RequestDispatcher dis = request.getRequestDispatcher(path);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
