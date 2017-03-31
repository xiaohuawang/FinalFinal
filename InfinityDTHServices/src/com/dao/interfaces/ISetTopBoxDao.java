package com.dao.interfaces;

import java.sql.SQLException;


import java.util.List;

import com.bean.SetTopBox;

public interface ISetTopBoxDao {
	
	public Integer addBox(SetTopBox box) throws SQLException, ClassNotFoundException;
	public SetTopBox getSetTopBox(String box) throws SQLException, ClassNotFoundException;
	public List<SetTopBox> getAllSamples() throws SQLException, ClassNotFoundException;

}
