package com.service;

import java.sql.SQLException;
import java.util.List;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bean.SetTopBox;
import com.dao.SetTopBoxDao;
import com.dao.interfaces.ISetTopBoxDao;
import com.dao.interfaces.ISampleDao;
import com.dao.interfaces.ISetTopBoxDao;
import com.util.DBConnection;


public class SetTopBoxService {
	
	
	
	
	ISetTopBoxDao dao = (ISetTopBoxDao) new SetTopBoxDao();
	private static final Logger logger = LogManager.getLogger(DBConnection.class);
	
	public Integer addBox(SetTopBox box) throws SQLException, ClassNotFoundException {
		
		return dao.addBox(box);
	}
	
	public List<SetTopBox> getAllSamples() throws SQLException, ClassNotFoundException {
		return dao.getAllSamples();
	}
	
	public SetTopBox getSampleByName(String box) throws SQLException, ClassNotFoundException {
		return dao.getSetTopBox(box);
	}

}
