package com.remind.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remind.test.service.CarService;
import com.remind.test.vo.CarVO;

public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * 조회 : car-list, car-view, car-update
	 * 나머지 : car-insert, car-update, car-delete
	 */
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // /car/car-list, /car/car-update , /car/car-veiw
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx);
		// cmd = ? car-list, car-view, car-update
		/* /WEB-INF/views/car/car-list.jsp
		 * /WEB-INF/views/car/car-view.jsp
		 * /WEB-INF/views/car/car-update.jsp
		 */
		CarService cs = new CarService();
		List<CarVO> cars = cs.getCars(null);
		request.setAttribute("cars", cars);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
