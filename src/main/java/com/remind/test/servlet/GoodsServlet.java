package com.remind.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.remind.test.service.GoodsService;
import com.remind.test.vo.GoodsVO;

public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GoodsService gs = new GoodsService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		
		if("goods-list".equals(cmd)) {
			List<GoodsVO> goodsList = gs.getGoodList(null);
			request.setAttribute("goodsList", goodsList);
			
			
		}else if("goods-view".equals(cmd) || "goods-update".equals(cmd)){
			int giNum = Integer.parseInt(request.getParameter("giNum"));
			GoodsVO goods = gs.getGoods(giNum);
			request.setAttribute("goods", goods);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views" + uri +".jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		String cmd = uri.substring(idx+1);
		GoodsVO goods = new GoodsVO();
		
		String giNumStr = request.getParameter("giNum");
		String giPriceStr = request.getParameter("giPrice");
		if(giNumStr != null && !"".equals(giNumStr)) {
			goods.setGiNum(Integer.parseInt(giNumStr));
		}
		if(giPriceStr != null && !"".equals(giPriceStr)) {
			goods.setGiPrice(Integer.parseInt(giPriceStr));
		}
		goods.setGiName(request.getParameter("giName"));
		goods.setGiDesc(request.getParameter("giDesc"));
		
		if("goods-insert".equals(cmd)) {
			request.setAttribute("msg", "상품 등록이 실패하였습니다");
			request.setAttribute("url", "/views/goods/goods-insert");
			if(gs.insertGoods(goods)==1) {
				request.setAttribute("msg", "상품 등록이 성공했습니다.");
				request.setAttribute("uri", "/goods/goods-list");
			}
		}else if("goods-update".equals(cmd)) {
			request.setAttribute("msg", "상품 수정이 실패하였습니다");
			request.setAttribute("url", "/goods/goods-update");
			if(gs.updateGoods(goods)==1) {
				request.setAttribute("msg", "상품 수정이 성공했습니다.");
				request.setAttribute("uri", "/goods/goods-view?giNum=" + goods.getGiNum());
			}
		}else if("goods-delete".equals(cmd)) {
			request.setAttribute("msg", "삭제가 실패하였습니다");
			request.setAttribute("uri", "/goods/goods-delete?ciNum="+goods.getGiNum());
			if(gs.deleteGoods(goods)==1) {
				request.setAttribute("msg", "삭제 성공하였습니다");
				request.setAttribute("uri", "/goods/goods-list");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		rd.forward(request, response);
	}

	}
