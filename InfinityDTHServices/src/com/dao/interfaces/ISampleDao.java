package com.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.bean.SampleBean;

// SAMPLE DAO INTERFACE
// THEY WILL LIKELY INCLUDE THE 4 SIMPLE CRUP (Create, Read, Update, Delete) operations
public interface ISampleDao {
	public Integer addSample(SampleBean sample) throws SQLException, ClassNotFoundException;
	public SampleBean getSampleByName(String name) throws SQLException, ClassNotFoundException;
	public List<SampleBean> getAllSamples() throws SQLException, ClassNotFoundException;
}
