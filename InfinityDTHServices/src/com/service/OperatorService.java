package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.Operator;
import com.dao.OperatorDao;
import com.dao.interfaces.IOperatorDao;


public class OperatorService {
	
	IOperatorDao dao = new OperatorDao();
		
	public Integer addOperator(Operator operator) throws SQLException, ClassNotFoundException {
		return dao.addOperator(operator);
	}
	
	public List<Operator> getAllOperators() throws SQLException, ClassNotFoundException {
		return dao.getAllOperators();
	}
	
	public List<Operator> getOperatorByName(String operatorName) throws SQLException, ClassNotFoundException {
		return dao.getOperatorByName(operatorName);
	}

	public boolean removeOperatorById(Integer operatorId) throws ClassNotFoundException, SQLException {
		return dao.removeOperatorById(operatorId);
	}

	public Operator getOperatorById(Integer operatorId) throws ClassNotFoundException, SQLException {
		return dao.getOperatorById(operatorId);
	}

	public boolean updateOperatorById(Operator operator) throws ClassNotFoundException, SQLException {
		return dao.updateOperatorById(operator);
	}
}

