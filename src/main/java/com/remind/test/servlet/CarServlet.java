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
	private CarService cs = new CarService();
	/*
	 * 조회 : car-list, car-view, car-update
	 * 나머지 : car-insert, car-update, car-delete
	 */
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // /car/car-list, /car/car-update , /car/car-veiw
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		// cmd = ? car-list, car-view, car-update
		/* /WEB-INF/views/car/car-list.jsp
		 * /WEB-INF/views/car/car-view.jsp
		 * /WEB-INF/views/car/car-update.jsp
		 */
		if("car-list".equals(cmd)) {
		List<CarVO> cars = cs.getCars(null);
		request.setAttribute("cars", cars);
		}else if("car-view".equals(cmd) || "car-update".equals(cmd)) {
			int ciNum = Integer.parseInt(request.getParameter("ciNum"));
			CarVO car = cs.getCar(ciNum);
			request.setAttribute("car", car);			
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri + ".jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // /car/car-insert ,/car/car-update , /car/car-delete
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		CarVO car = new CarVO();
		
		String ciNumStr = request.getParameter("ciNum");
		if(ciNumStr != null && !"".equals(ciNumStr)) {
			car.setCiNum(Integer.parseInt(ciNumStr));
		}
		car.setCiName(request.getParameter("ciName"));
		car.setCiYear(request.getParameter("ciYear"));
		
		if("car-insert".equals(cmd)) {
			request.setAttribute("msg", "등록이 실패하였습니다");
			request.setAttribute("uri", "/views/car/car-insert");
			if(cs.insertCar(car)==1) {
				request.setAttribute("msg", "등록이 성공하였습니다");
				request.setAttribute("uri", "/car/car-list");
			}
		}else if("car-update".equals(cmd)) {
			request.setAttribute("msg", "수정이 실패하였습니다");
			request.setAttribute("uri", "/car/car-update?ciNum="+car.getCiNum());
			if(cs.updateCar(car)==1) {
				request.setAttribute("msg", "수정이 성공하였습니다");
				request.setAttribute("uri", "/car/car-view?ciNum="+car.getCiNum());
			}
		}else if("car-delete".equals(cmd)) {
			request.setAttribute("msg", "삭제가 실패하였습니다");
			request.setAttribute("uri", "/car/car-delete?ciNum="+car.getCiNum());
			if(cs.deleteCar(car)==1) {
				request.setAttribute("msg", "삭제 성공하였습니다");
				request.setAttribute("uri", "/car/car-list");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
	}

}
