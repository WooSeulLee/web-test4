package com.remind.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.remind.test.service.UserService;
import com.remind.test.vo.UserVO;

@WebServlet(value = "/user/*", name = "UserServlet", loadOnStartup = 1)
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserService();

	/* GET: /user/user-list , /user/user-view, /user/user-update */
	/* POST: /user/user-insert , /user/user-update, /user/user-delete */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx + 1);

		if ("user-list".equals(cmd)) {
			List<UserVO> users = us.getUsers(null);
			request.setAttribute("users", users);
		} else if ("user-view".equals(cmd) || "user-update".equals(cmd)) {
			int uiNum = Integer.parseInt(request.getParameter("uiNum"));
			UserVO user = us.getUser(uiNum);
			request.setAttribute("user", user);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/" + uri + ".jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx + 1);
		UserVO user = new UserVO();

		String uiNumStr = request.getParameter("uiNum");
		if (uiNumStr != null && !"".equals(uiNumStr)) {
			user.setUiNum(Integer.parseInt(uiNumStr));
		}
		if (request.getParameter("uiBirth") != null) {
			user.setUiBirth(request.getParameter("uiBirth").replace("-", ""));
		}
		user.setUiId(request.getParameter("uiId"));
		user.setUiPwd(request.getParameter("uiPwd"));
		user.setUiName(request.getParameter("uiName"));
		user.setUiGender(request.getParameter("uiGender"));
		user.setUiHobby(request.getParameter("uiHobby"));
		user.setUiDesc(request.getParameter("uiDesc"));

		String[] hobbies = request.getParameterValues("uiHobby");
		if (hobbies != null) {
			String uiHobby = "";
			for (String hobby : hobbies) {
				uiHobby += hobby + ",";
			}
			uiHobby = uiHobby.substring(0, uiHobby.length() - 1);
			user.setUiHobby(uiHobby);
		}

		if ("user-insert".equals(cmd)) {
			request.setAttribute("msg", "등록 실패했습니다");
			request.setAttribute("uri", "/user/user-insert");
			if (us.insertUser(user) == 1) {
				request.setAttribute("msg", "등록 성공했습니다");
				request.setAttribute("uri", "/user/user-list");
			}
		} else if ("user-update".equals(cmd)) {
			request.setAttribute("msg", "수정에 실패하였습니다");
			request.setAttribute("uri", "/user/user-update");
			if (us.updateUser(user) == 1) {
				request.setAttribute("msg", "유저 수정에 성공했습니다");
				request.setAttribute("uri", "/user/user-view?uiNum=" + user.getUiNum());
			}
		} else if ("user-delete".equals(cmd)) {
			request.setAttribute("msg", "삭제에 실패하였습니다");
			request.setAttribute("uri", "/user/user-delete?uiNum=" + user.getUiNum());
			if (us.deleteUser(user) == 1) {
				request.setAttribute("msg", "삭제에 성공했습니다");
				request.setAttribute("uri", "/user/user-list");
			}
		} else if ("login".equals(cmd)) {
			UserVO loginUser = us.login(user);
			request.setAttribute("msg", "아이디 비밀번호를 확인해주세요");
			request.setAttribute("uri", "/user/login");
			if (loginUser != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", loginUser);
				request.setAttribute("msg", loginUser.getUiName() + "님 반갑습니다.");
				request.setAttribute("uri", "/");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
	}

}
