package com.service;

import java.sql.SQLException;
import java.util.List;

import com.bean.SampleBean;
import com.dao.SampleDao;
import com.dao.interfaces.ISampleDao;

public class SampleService {
	ISampleDao dao = new SampleDao();
	
	public Integer addSample(SampleBean sample) throws SQLException, ClassNotFoundException {
		return dao.addSample(sample);
	}
	
	public List<SampleBean> getAllSamples() throws SQLException, ClassNotFoundException {
		return dao.getAllSamples();
	}
	
	public SampleBean getSampleByName(String name) throws SQLException, ClassNotFoundException {
		return dao.getSampleByName(name);
	}
}
