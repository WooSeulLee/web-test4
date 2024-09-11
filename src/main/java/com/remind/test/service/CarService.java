package com.remind.test.service;

import java.util.List;

import com.remind.test.repository.CarRepository;
import com.remind.test.vo.CarVO;

public class CarService {
	private CarRepository cr = new CarRepository();

	public List<CarVO> getCars(CarVO car) {
		return cr.selectCars(car);
	}
	public CarVO getCar(int ciNum) {
		return cr.selectCar(ciNum);
	}
	
	public int insertCar(CarVO car) {
		return cr.insertCar(car);
	}
	
	public int deleteCar(CarVO car) {
		return cr.deleteCar(car);
	}
	
	public int updateCar(CarVO car) {
		return cr.updateCar(car);
	}
	
}
