package com.remind.test.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.remind.test.common.SqlMybatisConfig;
import com.remind.test.vo.GoodsVO;

public class GoodsRepository {
	
	public List<GoodsVO> selectGoodsList(GoodsVO goods){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){ //close대신
			return session.selectList("GoodsMapper.selectGoodsList", goods);
		}
	}
	
	public GoodsVO selectGoods(int giNum) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){ //close대신
			return session.selectOne("GoodsMapper.selectGoods", giNum);
		}
	}
	
	public int insertGoods(GoodsVO goods) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){ //close대신
			return session.insert("GoodsMapper.insertGoods", goods);
		}
	}
	
	public int updateGoods(GoodsVO goods) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){ //close대신
			return session.update("GoodsMapper.updateGoods", goods);
		}
	}
	
	public int deleteGoods(GoodsVO goods) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){ //close대신
			return session.delete("GoodsMapper.deleteGoods", goods);
		}
	}
	
	public static void main(String[] args) {
		GoodsRepository gr = new GoodsRepository();
		List<GoodsVO> list =gr.selectGoodsList(null);
		System.out.println(list);
		
		GoodsVO goods = gr.selectGoods(2);
		System.out.println(goods);
		
		int result = gr.insertGoods(goods);
		System.out.println(result);
		
		result = gr.updateGoods(goods);
		System.out.println(result);
		
		result = gr.deleteGoods(goods);
		System.out.println(result);
	}
}
