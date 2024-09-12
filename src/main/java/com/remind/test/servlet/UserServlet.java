package com.remind.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remind.test.service.UserService;
import com.remind.test.vo.UserVO;

@WebServlet(value = "/user/*", name="UserServlet", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();
 
	/*GET: /user/user-list , /user/user-view, /user/user-update */
	/*POST: /user/user-insert , /user/user-update, /user/user-delete */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI() ;
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		
		if("user-list".equals(cmd)) {
			List<UserVO> users = us.getUsers(null);
			request.setAttribute("users", users);
		}else if("user-view".equals(cmd) || "user-update".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			UserVO user = us.getUser(uiNum);
			request.setAttribute("user", user);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/" + uri + ".jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		UserVO user = new UserVO();
		
		String uiNumStr = request.getParameter("uiNum");
		if(uiNumStr != null && !"".equals(uiNumStr)) {
			user.setUiNum(Integer.parseInt(uiNumStr));
		}
		user.setUiId("uiId");
		user.setUiPwd("uiPwd");
		user.setUiName("uiName");
		user.setUiGender("uiGender");
		user.setUiBirth("uiBirth");
		user.setUiHobby("uiHobby");
		user.setUiDesc("uiDesc");
		
		if("user-insert".equals(cmd)) {
			request.setAttribute("msg", "유저 등록에 실패했습니다");
			request.setAttribute("uri", "유저");
			
		}
		
	}

}
