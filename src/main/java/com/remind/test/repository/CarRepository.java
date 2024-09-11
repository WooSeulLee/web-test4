package com.remind.test.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.remind.test.common.SqlMybatisConfig;
import com.remind.test.vo.CarVO;

public class CarRepository {

	public List<CarVO> selectCars(CarVO car) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()) {
			return session.selectList("CarMapper.selectCars", car);
		}
	}

	public CarVO selectCar(int ciNum) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()) {
			return session.selectOne("CarMapper.selectCar", ciNum);
		}
	}

	public int insertCar(CarVO car) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)) {
			return session.insert("CarMapper.insertCar", car);
		}
	}

	public int updateCar(CarVO car) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)) {
			return session.update("CarMapper.updateCar", car);
		}
	}

	public int deleteCar(CarVO car) {
		try (SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)) {
			return session.delete("CarMapper.deleteCar", car);
		}
	}

}
