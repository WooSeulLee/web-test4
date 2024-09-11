package com.remind.test.service;

import java.util.List;

import com.remind.test.repository.GoodsRepository;
import com.remind.test.vo.GoodsVO;

public class GoodsService {
	private GoodsRepository gr = new GoodsRepository();
	
	public List<GoodsVO> getGoodList(GoodsVO goods){
		return gr.selectGoodsList(goods);
	}
	
	public GoodsVO getGoods(int giNum) {
		return gr.selectGoods(giNum);
	}
	
	public int insertGoods(GoodsVO goods){
		return gr.insertGoods(goods);
	}
	
	public int updateGoods(GoodsVO goods){
		return gr.updateGoods(goods);
	}
	
	public int deleteGoods(GoodsVO goods){
		return gr.deleteGoods(goods);
	}
}
