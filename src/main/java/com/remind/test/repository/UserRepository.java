package com.remind.test.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.remind.test.common.SqlMybatisConfig;
import com.remind.test.vo.UserVO;

public class UserRepository {
	
	public List<UserVO> selectUsers(UserVO user){
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession()){
			return session.selectList("UserMapper.selectUsers",user);
		}
	}
	
	public UserVO selectUser(int uiNum) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.selectOne("UserMapper.selectUser", uiNum);
		}
	}
	
	public int insertUser(UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.insert("UserMapper.insertUser", user);
		}
	}
	
	public int updateUser(UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.update("UserMapper.updateUser", user);
		}
	}
	
	public int deleteUser(UserVO user) {
		try(SqlSession session = SqlMybatisConfig.getSessionFactory().openSession(true)){
			return session.delete("UserMapper.deleteUser", user);
		}
	}
	
	public static void main(String[] args) {
		UserRepository ur = new UserRepository();
		List<UserVO> users = ur.selectUsers(null);
		System.out.println(users);
		
		UserVO user = ur.selectUser(15);
		System.out.println(user);
		
		user.setUiId("test1111");
		int result = ur.insertUser(user);
		System.out.println(result);
		
		result = ur.updateUser(user);
		System.out.println(result);
		
		result = ur.deleteUser(user);
		System.out.println(result);
		
		
	}
}
