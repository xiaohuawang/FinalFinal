package com.dao.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.Operator;

public interface IOperatorDao {
	public Integer addOperator(Operator operator) throws SQLException, ClassNotFoundException;

	public ArrayList<Operator> getAllOperators();

	public List<Operator> getOperatorByName(String operatorName) throws SQLException, ClassNotFoundException;

	boolean removeOperatorById(Integer operatorId)  throws SQLException, ClassNotFoundException;

	public Operator getOperatorById(Integer operatorId) throws SQLException, ClassNotFoundException;

	public boolean updateOperatorById(Operator operator)throws SQLException, ClassNotFoundException;
}